## Sorting Techniques in Arrays (Step 2)

Sorting is the process of arranging elements in a specific order
(ascending or descending) to improve data organization, searching,
and processing efficiency.

- **Selection Sort**
  - Repeatedly, selecting the minimum (or maximum) element from unsorted array and swapping it with the first element in the correct position.
  - Time Complexity: O(n²).
  - Space Complexity: O(1).


- **Bubble Sort**
  - Repeatedly compares adjacent elements and swaps them if they are in the wrong order.
  - This moves the maximum element to the end.
  - Time Complexity: O(n²) (Worst & Average case); O(n) (Best case, if array is nearly sorted).
  - Space Complexity: O(1).


- **Insertion Sort**
  - Builds the sorted array one element at a time by taking an element and inserting it into their correct position.
  - Time Complexity: O(n²) (Worst & Average case); O(n) (Best case, when array is nearly sorted).
  - Space Complexity: O(1).


> Selection Sort, Bubble Sort and Insertion Sort are pretty straightforward sorting algorithms. These are not used in production code.
> However, these are important to understand the basic concepts of sorting.

- **Merge Sort**

  - Divide and Merge: Splits the array into halves, sorts them, and merges back into the same array.
  - Time Complexity: O(n log n).
  - Space Complexity: O(n).


- **Quick Sort**
  - Divide and Conquer: Selecting a pivot, placing it in correct order; smaller on left and larger on right.
  - Placing pivot will partition elements around it, then recursively sorting subarrays.
  - Time Complexity: O(n²) (Worst case), O(n log n) (Best & Average case).
  - Space Complexity: O(log n).

### Resources for Sorting:

- [Selection Sort, Bubble Sort and Insertion Sort](https://www.youtube.com/watch?v=HGk_ypEuS24)
- [Merge Sort](https://www.youtube.com/watch?v=ogjf7ORKfd8)
- [Quick Sort](https://www.youtube.com/watch?v=WIrA4YexLRQ)

## Important Questions

| Topic   | Rating | Question   | Solution Link                  | Date          |
|---------|--------|------------|--------------------------------|---------------|
| Sorting | Medium | Merge Sort | [Here](./lec2/MergeSort1.java) | 15th Sep 2025 |
| Sorting | Medium | Quick Sort | [Here](./lec2/QuickSort4.java) | 15th Sep 2025 |
