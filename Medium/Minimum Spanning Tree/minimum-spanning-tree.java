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
        return a[2]-b[2];
    }
}

class Solution{
    static int ans;
    static int[] par, size;
    static int spanningTree(int V, int E, int edges[][]){
	    int i;
	    ans = 0;
	    size = new int[V];
	    par = new int[V];
	    
	    for(i=0; i<V; i++){
	        par[i] = i;
	        size[i] = 1;
	    }
	    Arrays.sort(edges, new SortByWt());
	    
	    for(i=0; i<E; i++)
	        union(edges[i][0], edges[i][1], edges[i][2]);
	    return ans;
	}
	
	static void union(int a, int b, int wt){
	    int parA, parB, sizeA, sizeB;
	    parA = findPar(a);
	    parB = findPar(b);
	    sizeA = size[parA];
	    sizeB = size[parB];
	    
	    if (parA == parB)
	        return;
	    ans += wt;
	    if (sizeA < sizeB){
	        par[parA] = parB;
	        sizeB += sizeA;
	    }
	    else{
	        par[parB] = parA;
	        sizeA += sizeB;
	    }
	}
	
	static int findPar(int a){
	    if (a == par[a])
	        return a;
	    return par[a] = findPar(par[a]);
	}
}