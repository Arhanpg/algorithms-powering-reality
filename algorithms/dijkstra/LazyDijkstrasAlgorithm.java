import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Graph {

    class Edge {
        int wt;
        int dest;

        public Edge(int wt, int dest) {
            this.wt = wt;
            this.dest = dest;
        }
    }

    // Adjacency-list representation of the weighted directed graph.
    Map<Integer, ArrayList<Edge>> m1;

    public Graph() {
        this.m1 = new HashMap<>();
    }

    public void create_vertex(int vertex) {
        m1.putIfAbsent(vertex, new ArrayList<>());
    }

    // Adds a directed edge: src -> dest with the given weight.
    public void add_node(int src, int dest, int wt) {
        create_vertex(src);
        create_vertex(dest);

        ArrayList<Edge> arr = m1.get(src);
        arr.add(new Edge(wt, dest));
        m1.put(src, arr);

        // No reverse edge is added because this graph is directed.
    }

    public void Lazy_Dijkastra(int start, int end) {

        if (!m1.containsKey(end)) {
            System.out.println("Invalid dest");
            return;
        }

        Map<Integer, Integer> optimal_dist = new HashMap<>();

        // Stores the previous vertex used to obtain the shortest path.
        Map<Integer, Integer> optimal_path = new HashMap<>();

        Set<Integer> keySet = m1.keySet();

        for (int vertex : keySet) {
            optimal_dist.put(vertex, Integer.MAX_VALUE);
        }

        optimal_dist.put(start, 0);

        // Each PQ element is {vertex, current distance}.
        // Dijkstra must always process the smallest distance first.
        PriorityQueue<int[]> PQ =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        PQ.offer(new int[]{start, 0});

        while (!PQ.isEmpty()) {

            int[] curr = PQ.poll();

            int curr_node = curr[0];
            int curr_dist = curr[1];

            // Ignore stale entries created by the lazy approach.
            if (curr_dist != optimal_dist.get(curr_node)) {
                continue;
            }

            ArrayList<Edge> arr = m1.get(curr_node);

            for (Edge eg : arr) {

                int new_dist = curr_dist + eg.wt;

                // Relax the edge if a shorter distance is found.
                if (new_dist < optimal_dist.get(eg.dest)) {

                    optimal_dist.put(eg.dest, new_dist);

                    // Store the predecessor so the final path can be rebuilt.
                    optimal_path.put(eg.dest, curr_node);

                    PQ.offer(new int[]{eg.dest, new_dist});
                }
            }
        }

        if (optimal_dist.get(end) == Integer.MAX_VALUE) {
            System.out.println("Node is unreachable");
            return;
        }

        System.out.print("Optimal dist " + optimal_dist.get(end) + " ");

        // Reconstruct the path by following predecessors backwards.
        ArrayList<Integer> arr = new ArrayList<>();
        Integer curr = end;

        while (curr != null) {
            arr.add(curr);
            curr = optimal_path.get(curr);
        }

        // The path was collected from destination to source,
        // so reverse it before printing.
        Collections.reverse(arr);

        System.out.println("Optimal path " + arr);
    }
}

public class LazyDijkstrasAlgorithm {

    public static void main(String[] args) {

        Graph G1 = new Graph();

        G1.add_node(10, 1, 2);
        G1.add_node(1, 2, 5);
        G1.add_node(1, 3, 3);
        G1.add_node(10, 2, 3);
        G1.add_node(2, 4, 4);
        G1.add_node(3, 5, 6);

        G1.Lazy_Dijkastra(10, 4);
        G1.Lazy_Dijkastra(10, 5);
        G1.Lazy_Dijkastra(10, 9);
    }
}
