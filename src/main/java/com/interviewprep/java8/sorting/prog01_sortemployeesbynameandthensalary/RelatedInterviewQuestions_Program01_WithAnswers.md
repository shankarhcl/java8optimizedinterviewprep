# Related Interview Questions With Answers

This file contains interview-ready questions and concise answers related to this program.

---

## 1. How do you sort employees by name and then salary?

Use a chained `Comparator`:

Comparator.comparing(Employee::getName)
        .thenComparingDouble(Employee::getSalary);

The first comparator sorts by name. If two employees have the same name, the second comparator sorts them by salary.

---

## 2. What is `thenComparing()` used for?

`thenComparing()` adds a secondary comparison to an existing comparator.

The secondary comparison is used only when the previous comparison considers the two objects equal.

Compare name
    |
    +-- different --> name determines order
    |
    +-- equal ------> compare salary

This is commonly used for multi-level sorting.

---

## 3. What is the difference between `thenComparing()` and `thenComparingDouble()`?

`thenComparing()`:
    - A general comparator method that can compare objects or boxed values.

`thenComparingDouble()`:
    - Specialized for a primitive `double` key.
    - For an employee whose salary is a primitive `double`, this is a clear choice:
    - It also avoids unnecessary boxing of the primitive salary during key comparison.

---

## 4. Why use `thenComparingDouble()` for salary?

If `Employee :: getSalary` returns a primitive `double`, `thenComparingDouble()` directly expresses that the secondary key is a `double`.

This is concise, readable, and appropriate for Java 8.

---

## 5. Does `Stream.sorted()` modify the original list?

No.
It produces a sorted stream. It does not sort the source `List` in place.

---

## 6. How would you sort the existing list?

Use `List.sort()`:
This sorts the existing list rather than creating a separate collected result.

---

## 7. How would you sort salary in descending order while keeping name ascending?

Reverse only the salary comparator:

Comparator.comparing(Employee::getName)
        .thenComparing(
                Comparator.comparingDouble(Employee::getSalary)
                        .reversed()
        );

Do not call `.reversed()` on the complete comparator if only salary should be reversed.

---

## 8. How would you handle null employee names?

Comparator.comparing(
        Employee::getName,
        Comparator.nullsLast(String::compareTo)
)
.thenComparingDouble(Employee::getSalary);

The important point is that null handling should be based on the application's business requirement rather than being accidental behavior.

---

## 9. What happens when both name and salary are equal?

The comparator returns `0` for those two sorting keys.
That means the employees are considered equal with respect to this comparator.
If the sorting algorithm is stable, their relative order is preserved.

---

## 10. Is Java object sorting stable?

Yes. Java's object sorting APIs provide stable sorting.
For a stable sort, if two objects compare as equal, their original relative order is preserved.
This is useful when a previous ordering has already been established and a subsequent sort is applied.

---

## 11. What is the time complexity of this solution?

The standard interview answer is: O(n log n)

where `n` is the number of employees.
Sorting is the dominant operation.
The salary comparison is performed only when employee names are equal, but this does not change the overall asymptotic complexity under the normal assumption that each comparison is `O(1)`.

---

## 12. What is the space complexity of the Stream solution?

For this implementation:

employees.stream()
        .sorted(...)
        .collect(Collectors.toList());


the result list contains `n` employees, so the additional result space is: O(n)

The sorting operation can also require temporary memory.
Therefore, for interview purposes, state:
Space: O(n)
for the complete Stream-based implementation.

---

## 13. Can you solve this without Streams?

Yes.
Use `List.sort()`:
This is often the simplest implementation when modifying the original list is acceptable.

---

## 14. Can you implement the comparator manually?

Yes:

employees.sort((e1, e2) -> {
    int nameComparison = e1.getName().compareTo(e2.getName());
    if (nameComparison != 0) {
        return nameComparison;
    }
    return Double.compare(e1.getSalary(), e2.getSalary()
    );
});

---

## 15. Does adding more `thenComparing()` calls make sorting O(n²)?

No.

For example:
Comparator.comparing(Employee::getName)
        .thenComparingDouble(Employee::getSalary)
        .thenComparing(Employee::getDepartment);

still uses the underlying sorting algorithm.
Additional comparison fields can increase the work performed by an individual comparison, but simply adding secondary keys does not turn a sorting algorithm into `O(n²)`.
Under the normal bounded-key assumption, the overall complexity remains: O(n log n)

---

## 16. What is the difference between `Stream.sorted()` and `List.sort()`?

`Stream.sorted()` creates a sorted view of the stream pipeline and does not modify the source list.
`List.sort()` sorts the existing list in place:

Use the Stream approach when the sorting operation naturally belongs inside a stream pipeline or when you want a separate result.
Use `List.sort()` when modifying the existing list is acceptable.

---

## 17. What if name should be descending and salary ascending?

Reverse only the name comparator:

Comparator.comparing(
        Employee::getName,
        Comparator.reverseOrder()
)
.thenComparingDouble(Employee::getSalary);

---

## 18. What if both name and salary must be descending?

Reverse each comparator independently:

Comparator.comparing(
        Employee::getName,
        Comparator.reverseOrder()
)
.thenComparing(
        Comparator.comparingDouble(Employee::getSalary)
                .reversed()
);

The key lesson is that each sorting field can have its own ordering direction.

---

## 19. What happens if the list contains a null Employee?

The basic comparator assumes that every list element is a valid `Employee`.
If null employees are allowed, explicitly handle them:

Comparator<Employee> comparator =
        Comparator.nullsLast(
                Comparator.comparing(Employee::getName)
                        .thenComparingDouble(Employee::getSalary)
        );

Whether null employees should be accepted should normally be decided by the application's input contract.

---

## 20. Is `double` a good choice for salary in a real banking or financial application?

Not usually.

`double` is a floating-point representation and can introduce precision issues for monetary calculations.
For financial amounts where exact decimal arithmetic is required, `BigDecimal` is generally a better choice.
For this interview problem, `double` is acceptable because the primary purpose is demonstrating sorting and Comparator usage.

---

# Interviewer Follow-up Challenge

### Question

Now change the requirement:

> Sort employees by name ascending, salary descending, and employee ID ascending when both name and salary are equal.

### Expected solution

The candidate should extend the comparator chain:

Comparator.comparing(Employee::getName)
        .thenComparing(
                Comparator.comparingDouble(Employee::getSalary)
                        .reversed()
        )
        .thenComparing(Employee::getId);

### What this tests

This follow-up tests whether the candidate understands:

- Comparator chaining
- Primary and secondary sorting
- Independent ascending/descending ordering
- Method references
- Java 8 Comparator APIs
- Extending an existing solution without rewriting the algorithm

---

# Interview Answering Tip

Do not answer only with code.
A strong interview explanation is:

> I need a multi-level sort. Employee name is the primary key and should be ascending. Salary is the secondary key and should be considered only when two names are equal. In Java 8, I can express this cleanly using `Comparator.comparing()` followed by `thenComparingDouble()`.

Then write the implementation.
This demonstrates both problem understanding and Java API knowledge.

---