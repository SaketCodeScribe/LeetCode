import java.util.* ;
import java.util.stream.Collectors;
import java.io.*; 

class SortByDist implements Comparator<int[]>{
	@Override
	public int compare (int[] a, int[] b){
		return a[1]-b[1];
	}
}
public class Solution {
	
	public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int v, int e, int s){
		int i, node, d;
		int[] dist = new int[v];
		List<List<int[]>> adj = new ArrayList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>(new SortByDist());
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(i=0; i<v; i++)
			adj.add(new ArrayList<>());
		for(ArrayList<Integer> edge:vec){
			adj.get(edge.get(0)).add(new int[]{edge.get(1), edge.get(2)});
			adj.get(edge.get(1)).add(new int[]{edge.get(0), edge.get(2)});
		}
		dist[s] = 0;
		pq.add(new int[]{s, dist[s]});

		while (!pq.isEmpty()){
			node = pq.peek()[0];
			d = pq.poll()[1];
			for(int[] child:adj.get(node)){
				if (dist[child[0]] > d+child[1]){
					dist[child[0]] = d+child[1];
					pq.add(new int[] {child[0], dist[child[0]]});
				}
			}
		}
		return Arrays.stream(dist).boxed().collect(Collectors.toCollection(ArrayList::new));
	}
}