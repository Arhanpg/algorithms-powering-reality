# Dijkstra's Algorithm

This directory builds Dijkstra's algorithm step by step, starting from a weighted graph representation and then implementing the shortest-path algorithm.

## 1. Graph representation

`Graphcreate.java` demonstrates a weighted directed graph using an adjacency-list representation.

## 2. Lazy Dijkstra

`LazyDijkstrasAlgorithm.java` implements **lazy Dijkstra's algorithm** using:

- an adjacency list for the graph
- a distance map for the best known distance to each vertex
- a `PriorityQueue` ordered by the smallest distance
- edge relaxation
- stale-entry checks instead of a decrease-key operation

### Why is it called lazy?

When a shorter distance is discovered, the implementation simply inserts a new `{vertex, distance}` pair into the priority queue. It does not remove the older pair. When an old pair is later popped, this check discards it:

```java
if (currDist != optimalDist.get(currNode)) {
    continue;
}
```

### Example

The current example contains:

```text
10 -> 1  (2)
1  -> 2  (5)
1  -> 3  (3)
10 -> 2  (3)
2  -> 4  (4)
3  -> 5  (6)
```

The program produces:

```text
Optimal dist 7
Optimal dist 11
Invalid destination or source
```

The `7` path is `10 -> 2 -> 4`, while the `11` path is `10 -> 1 -> 3 -> 5`.

### Important implementation detail

The priority queue stores `{vertex, distance}`, so it must be ordered using the **distance field**. Ordering it by vertex ID would break Dijkstra's selection of the currently smallest tentative distance.

### Complexity

With an adjacency list and binary-heap priority queue, the standard bound is **O((V + E) log V)** for non-negative edge weights. This implementation may place multiple entries for the same vertex in the queue because it uses the lazy approach.
