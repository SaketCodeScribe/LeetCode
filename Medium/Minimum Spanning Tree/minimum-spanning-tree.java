//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class SortByWt implements Comparator<int[]>{
    @Override
    public int compare(int[] a, int[] b){
        return a[0]-b[0];
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    int i, ans = 0;
	    List<List<int[]>> adj = new ArrayList<List<int[]>>();
	    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new SortByWt());
	    boolean[] vis = new boolean[V];
	    
	    for(i=0; i<V; i++)
	        adj.add(new ArrayList<int[]>());
	    for(i=0; i<E; i++){
	        adj.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
	        adj.get(edges[i][1]).add(new int[]{edges[i][0], edges[i][2]});
	    }
	    pq.add(new int[]{0,0,-1});
	    
	    while (!pq.isEmpty()){
	        int[] vertex = pq.poll();
	        if (vis[vertex[1]])
	            continue;
	           ans += vertex[0];
	        for(int[] child:adj.get(vertex[1]))
	            pq.add(new int[]{child[1], child[0], vertex[1]});
	           vis[vertex[1]] = true;
	    }
	    return ans;
	}
}