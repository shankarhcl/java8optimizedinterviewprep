# Program 01: Sort Employees by Name and Then Salary

## Problem Statement
Sort employees by:
1. Name in ascending order.
2. Salary in ascending order when names are equal.

## Concepts Covered
- Java 8 Stream API
- Stream.sorted()
- Comparator.comparing()
- thenComparingDouble()
- Method references
- Multi-level sorting
- List.sort()
- Custom Comparator
- Stable sorting
- Time and space complexity

## Approaches
1. Java 8 Stream API
2. List.sort() with Comparator
3. Custom Comparator

## Recommended Approach
Use the Stream solution when the interviewer asks specifically for Java 8 Stream API. Use `List.sort()` when modifying the existing list is acceptable and a direct solution is preferred.

## Complexity
Under the standard interview assumption that name comparison is O(1):
- Stream solution: Time O(n log n), additional space O(n) for the collected result.
- List.sort/custom comparator: Time O(n log n); sorting may require auxiliary memory.

See `ComplexityWithExplanation.md` for details.

## Edge Cases
Empty list, one employee, duplicate names, equal name and salary, null values, negative salary if the domain permits it, and very large salary values.

## Interview Follow-ups
Why use `thenComparingDouble()`? Does Stream sorting modify the original list? How would you sort salary descending? How would you handle null names? Is Java object sorting stable? Can you solve it without Streams?

See `RelatedInterviewQuestions_Program01_WithAnswers.md`.

## Practice Strategy
Try the problem yourself first. Then compare all approaches, explain the complexity aloud, review edge cases, and practice the follow-up questions. The goal is to understand the solution, not memorize it.

---