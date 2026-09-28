import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Graph {

    // Represents one weighted edge from a source vertex to a destination vertex.
    static class Edge {
        int wt;
        int dest;

        Edge(int wt, int dest) {
            this.wt = wt;
            this.dest = dest;
        }
    }

    // Adjacency-list representation of the graph.
    private final Map<Integer, ArrayList<Edge>> graph = new HashMap<>();

    // Creates a vertex if it does not already exist.
    public void createVertex(int vertex) {
        graph.putIfAbsent(vertex, new ArrayList<>());
    }

    // Adds a directed weighted edge: src -> dest.
    public void addEdge(int src, int dest, int wt) {
        createVertex(src);
        createVertex(dest);
        graph.get(src).add(new Edge(wt, dest));
    }

    // Lazy Dijkstra:
    // Instead of decreasing a key already present in the priority queue,
    // we insert the improved distance as a new entry. Old entries are
    // ignored when they become stale.
    public void lazyDijkstra(int start, int end) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            System.out.println("Invalid destination or source");
            return;
        }

        Map<Integer, Integer> optimalDist = new HashMap<>();
        for (int vertex : graph.keySet()) {
            optimalDist.put(vertex, Integer.MAX_VALUE);
        }

        optimalDist.put(start, 0);

        // int[] = {vertex, distance}
        // IMPORTANT: the queue must be ordered by distance, not vertex.
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currNode = current[0];
            int currDist = current[1];

            // Ignore stale entries left in the queue by earlier relaxations.
            if (currDist != optimalDist.get(currNode)) {
                continue;
            }

            for (Edge edge : graph.get(currNode)) {
                int newDist = currDist + edge.wt;

                // Relax the edge if a shorter path has been found.
                if (newDist < optimalDist.get(edge.dest)) {
                    optimalDist.put(edge.dest, newDist);
                    pq.offer(new int[]{edge.dest, newDist});
                }
            }
        }

        if (optimalDist.get(end) == Integer.MAX_VALUE) {
            System.out.println("Node is unreachable");
            return;
        }

        System.out.println("Optimal dist " + optimalDist.get(end));
    }
}

public class LazyDijkstrasAlgorithm {

    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addEdge(10, 1, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 3);
        graph.addEdge(10, 2, 3);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 5, 6);

        graph.lazyDijkstra(10, 4);
        graph.lazyDijkstra(10, 5);
        graph.lazyDijkstra(10, 9);
    }
}
