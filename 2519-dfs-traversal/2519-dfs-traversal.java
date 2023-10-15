import java.util.ArrayList;
import java.util.List;

public class Solution {
    static boolean[] vis;
    static ArrayList<ArrayList<Integer>> adj;
    static ArrayList<Integer> temp;

    public static void dfs(int node){
        vis[node] = true;
        temp.add(node);
        for(Integer child:adj.get(node)){
            if (!vis[child])
                dfs(child);
        }
    }
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        int i;
        adj = new ArrayList<>();
        vis = new boolean[v];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(i=0; i<v; i++)
            adj.add(new ArrayList<>());
        for(ArrayList<Integer> edge:edges){
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        for(i=0; i<v; i++){
            temp = new ArrayList<>();
            if (!vis[i]){
                dfs(i);
                temp.sort(Integer::compareTo);
                ans.add(temp);
            }
        }

        return ans;
    }
}