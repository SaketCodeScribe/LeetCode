import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        int i;
        int[] indegree = new int[v];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(i=0; i<v; i++)
            adj.add(new ArrayList<>());
        for(ArrayList<Integer> edge:edges){
            indegree[edge.get(1)]++;
            adj.get(edge.get(0)).add(edge.get(1));
        }
        for(i=0; i<v; i++)
            if(indegree[i] == 0)
                pq.add(i);
        while (!pq.isEmpty()){
            int node = pq.poll();
            ans.add(node);
            for(Integer child:adj.get(node)){
                indegree[child]--;
                if (indegree[child] == 0)
                    pq.add(child);
            }
        }
        return ans;
    }
}
