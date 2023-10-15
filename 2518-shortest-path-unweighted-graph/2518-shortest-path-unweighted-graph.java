import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution {

	public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
		int i, node, size;
		List<List<Integer>> adj = new ArrayList<>();
		LinkedList<Integer> ans = new LinkedList();
		Queue<Integer> queue = new LinkedList();
		boolean[] vis = new boolean[n+1];
		int par[] = new int[n+1];
		
		for(i=0; i<=n; i++)
			adj.add(new ArrayList<>());
		for(i=0; i<m; i++){
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}
		queue.add(s);
		par[s] = -1;
		vis[s] = true;
		while (!queue.isEmpty()){
			size = queue.size();
			
			while(size-- > 0){
				node = queue.poll();
				for(Integer child:adj.get(node)){
					if (vis[child])
						continue;
					par[child] = node;
					vis[child] = true;
					if (child == t){
						node = child;
						do{
							ans.add(node);
							node = par[node];
						}while(node != -1);
						Collections.reverse(ans);
						return ans;
					}
					queue.add(child);
				}
			}

		}
		return ans;
	}

}