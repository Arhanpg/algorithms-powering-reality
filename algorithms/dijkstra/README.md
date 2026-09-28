# Dijkstra's Algorithm

This directory builds Dijkstra's algorithm step by step, starting from a weighted graph representation and then implementing the shortest-path algorithm.

## 1. Graph representation

`Graphcreate.java` demonstrates a weighted directed graph using an adjacency-list representation.

## 2. Lazy Dijkstra

`LazyDijkstrasAlgorithm.java` implements **lazy Dijkstra's algorithm** using:

- an adjacency list for the graph
- a map for the best known distance to each vertex
- a `PriorityQueue` ordered by the smallest distance
- edge relaxation
- stale-entry checks instead of a decrease-key operation
- a predecessor map for reconstructing the final shortest path

### Why is it called lazy?

When a shorter distance is discovered, the implementation inserts a new `{vertex, distance}` pair into the priority queue instead of updating/removing the old entry.

The old entry is left in the queue. When it is eventually popped, it is detected as stale and skipped:

```java
if (curr_dist != optimal_dist.get(curr_node)) {
    continue;
}
```

### Path reconstruction

The algorithm stores the previous vertex whenever a better distance is found:

```java
optimal_path.put(eg.dest, curr_node);
```

After Dijkstra finishes, the path is reconstructed by starting from the destination and following predecessors back to the source. The resulting list is then reversed before printing.

For example:

```text
Optimal dist 7 Optimal path [10, 2, 4]
Optimal dist 11 Optimal path [10, 1, 3, 5]
Invalid dest
```

### Current graph

```text
10 -> 1  (weight 2)
1  -> 2  (weight 5)
1  -> 3  (weight 3)
10 -> 2  (weight 3)
2  -> 4  (weight 4)
3  -> 5  (weight 6)
```

For destination `4`, the shortest route is:

```text
10 -> 2 -> 4
```

with total cost:

```text
3 + 4 = 7
```

For destination `5`, the shortest route is:

```text
10 -> 1 -> 3 -> 5
```

with total cost:

```text
2 + 3 + 6 = 11
```

### Important priority queue detail

Each queue element is stored as:

```text
{vertex, distance}
```

Therefore, the priority queue must compare the **second value**:

```java
Comparator.comparingInt(a -> a[1])
```

This makes the vertex with the smallest tentative distance come out first.

### Complexity

With an adjacency list and a binary-heap priority queue, the usual complexity is **O((V + E) log V)** for non-negative edge weights. The lazy implementation can keep multiple queue entries for the same vertex, which are handled by the stale-entry check.
