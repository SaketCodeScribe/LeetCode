class Solution {
    List<Integer> ans;
    List<List<Integer>> adj;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses, i;
        int[] indegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        ans = new ArrayList<>();
        adj = new ArrayList<>();
        for(i=0; i<n; i++)
            adj.add(new ArrayList<Integer>());
        for(int[] prerequisite:prerequisites){
            adj.get(prerequisite[0]).add(prerequisite[1]);
            indegree[prerequisite[1]]++;
        }
        for(i=0; i<n; i++)
            if(indegree[i] == 0)
                queue.add(i);
        while (queue.size() > 0){
            int node = queue.poll();
            for(Integer child:adj.get(node)){
                indegree[child]--;
                if (indegree[child] == 0)
                    queue.add(child);
            }
            ans.add(node);
        }
        if (Arrays.stream(indegree).sum() > 0)
            return new int[]{};
        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}