class SortBystart implements Comparator<int[]>{
    @Override
    public int compare(int[] a, int[] b){
        return a[0]-b[0];
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        int i, j = 0, n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, new SortBystart());
        
        ans.add(intervals[0]);
        for(i=1; i<n; i++){
            if (intervals[i][0] > ans.get(j)[1]){
                ans.add(intervals[i]);
                j++;
            }
            else if (intervals[i][0] <= ans.get(j)[1] && intervals[i][1] > ans.get(j)[1])
                ans.get(j)[1] = intervals[i][1];
        }
        int[][] res = new int[ans.size()][2];
        i=0;
        for(var pair:ans)
            res[i++] = pair;
        return res;
    }
}