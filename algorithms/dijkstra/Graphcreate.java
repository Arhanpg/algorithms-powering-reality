import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class graph {

    // Represents one weighted edge from a source vertex to a destination vertex.
    class edge {
        int wt;
        int dest;

        public edge(int wt, int dest) {
            this.wt = wt;
            this.dest = dest;
        }

        @Override
        public String toString() {
            return " -> " + dest + " Weight: " + wt;
        }
    }

    // Adjacency list representation:
    // vertex -> list of outgoing weighted edges
    Map<Integer, ArrayList<edge>> m1;

    public graph() {
        this.m1 = new HashMap<>();
    }

    // Creates the vertex only if it does not already exist.
    public void addVertex(int vertex) {
        m1.putIfAbsent(vertex, new ArrayList<>());
    }

    // Adds a directed weighted edge: src -> dest.
    public void AddEdge(int src, int dest, int wt) {
        addVertex(src);

        ArrayList<edge> arr = m1.get(src);
        arr.add(new edge(wt, dest));
        m1.put(src, arr);
    }

    // Prints every vertex and the weighted edges going out of it.
    public void PrintGraph() {
        if (m1.isEmpty()) {
            System.out.println("Graph is empty");
            return;
        }

        Set<Integer> s1 = m1.keySet();

        for (int obj : s1) {
            System.out.print(obj + " is connected to");

            ArrayList<edge> arr = m1.get(obj);

            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i));
            }

            System.out.println();
        }
    }
}

public class Graphcreate {

    public static void main(String[] args) {

        graph G1 = new graph();

        // Demonstrate the empty graph first.
        G1.PrintGraph();

        // Build a small weighted directed graph.
        G1.AddEdge(10, 1, 2);
        G1.AddEdge(1, 2, 5);
        G1.AddEdge(10, 2, 3);
        G1.AddEdge(2, 4, 4);
        G1.AddEdge(3, 5, 6);

        G1.PrintGraph();
    }
}
