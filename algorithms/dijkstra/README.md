# Dijkstra's Algorithm

This directory starts with the graph representation used for the upcoming Dijkstra implementation.

## Graphcreate.java

`Graphcreate.java` demonstrates a **weighted directed graph** using an adjacency-list representation.

### What it contains

- `Map<Integer, ArrayList<edge>>` to store graph connections.
- A nested `edge` class containing destination and edge weight.
- `AddEdge(src, dest, wt)` for adding weighted directed edges.
- `PrintGraph()` for displaying the graph.

The current example builds edges such as:

```text
10 -> 1 (weight 2)
1  -> 2 (weight 5)
10 -> 2 (weight 3)
2  -> 4 (weight 4)
3  -> 5 (weight 6)
```

This graph representation will be reused when implementing **Dijkstra's shortest-path algorithm**.
