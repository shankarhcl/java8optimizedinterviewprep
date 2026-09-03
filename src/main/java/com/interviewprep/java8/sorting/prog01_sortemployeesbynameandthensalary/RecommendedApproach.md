# Recommended Approach

For a Java 8 interview, Approach 1 is the preferred answer when the interviewer wants a Stream API solution:

If Streams are not required, `List.sort()` is simpler when modifying the existing list is acceptable:

`thenComparingDouble()` is appropriate because salary is a primitive `double`.

# Interview tip:

Explain the requirement before coding:
name is the primary key; salary is the secondary key used only when names are equal.
