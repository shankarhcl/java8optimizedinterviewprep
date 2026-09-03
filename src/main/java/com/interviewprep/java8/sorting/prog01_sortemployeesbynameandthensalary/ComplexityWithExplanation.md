# Complexity With Explanation

Let `n` be the number of employees.

## Time Complexity

**O(n log n)** for the sorting operation under the standard interview assumption that each comparison is O(1).

The comparator first compares names. Salary is compared only when names are equal. This secondary comparison does not change the overall asymptotic sorting complexity.

## Space Complexity

### Stream solution
**O(n)** additional space for the new list created by `collect(Collectors.toList())`. The sorting operation can also require temporary memory.

### List.sort()
No separate result list is created, but the underlying sorting implementation may require auxiliary memory. Therefore, do not automatically claim O(1) total auxiliary space.

## Advanced Note
`String.compareTo()` technically depends on the characters examined and therefore can depend on string length. For normal interview analysis with bounded employee-name length, treating the comparison as O(1) is appropriate.

For standard Java object sorting, the practical interview answer is:
- Average: O(n log n)
- Worst: O(n log n)
- Best: O(n) for favorable already/nearly sorted input

---