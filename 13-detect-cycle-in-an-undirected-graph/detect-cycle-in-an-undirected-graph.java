import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Solution {
    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            int i, size;
            Queue<Integer> queue = new LinkedList<>();
            int[] indegree = new int[V];
            
            for(List<Integer> vertices:adj)
                for(int vertice:vertices)
                    indegree[vertice]++;
            for(i=0; i<V; i++)
                if (indegree[i] == 1)
                    queue.add(i);
            while (queue.size() > 0){
                size = queue.size();
                while (size-- > 0){
                    int node = queue.poll();
                    for(int vertice:adj.get(node)){
                        indegree[vertice]--;
                        if (indegree[vertice] == 1)
                            queue.add(vertice);
                    }
                } 
            }
            for(int val:indegree)
                if (val > 1)
                    return true;
            return false;
        }
    };
}
