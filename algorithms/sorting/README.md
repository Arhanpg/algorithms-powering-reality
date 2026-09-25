# Sorting Algorithms

This folder contains implementations of the core sorting algorithms used for learning the fundamentals of algorithm design.

## Implementations

### Bubble Sort
Repeatedly compares neighbouring elements and swaps them when they are out of order.

**Complexity:** O(n²) average/worst, O(n) best with early-exit optimization, O(1) extra space.

### Selection Sort
Finds the smallest remaining element and places it at the current position.

**Complexity:** O(n²) time, O(1) extra space.

### Insertion Sort
Builds a sorted prefix one element at a time by inserting each new element into its correct position.

**Complexity:** O(n²) average/worst, O(n) best for already sorted input, O(1) extra space.

### Merge Sort
Splits the array into smaller halves, recursively sorts them, and merges the sorted halves.

**Complexity:** O(n log n) time, O(n) extra space.

### Quick Sort
Partitions an array around a pivot and recursively sorts the two sides.

**Complexity:** O(n log n) average, O(n²) worst for poor pivot choices.

## Suggested study order

1. Bubble Sort
2. Selection Sort
3. Insertion Sort
4. Merge Sort
5. Quick Sort

Start with the simple O(n²) algorithms, then move to divide-and-conquer algorithms to see how the time complexity improves.
