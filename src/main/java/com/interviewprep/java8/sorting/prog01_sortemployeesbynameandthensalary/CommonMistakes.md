# Common Mistakes

## 1. Sorting only by name
This fails when duplicate names exist.

## 2. Reversing the entire comparator
If only salary must be descending, reverse only the salary comparator.

Comparator.comparing(Employee::getName)
        .thenComparing(
                Comparator.comparingDouble(Employee::getSalary)
                        .reversed()
        );


## 3. Claiming `thenComparing()` makes sorting O(n²)
It does not. The overall sorting complexity remains O(n log n) under normal interview assumptions.

## 4. Assuming Stream sorting modifies the original list
`stream().sorted()` does not sort the original list in place.

## 5. Ignoring null requirements
Ask whether employees or names can be null before choosing the comparator.

## 6. Using custom comparison unnecessarily
Prefer the standard Comparator API when it expresses the requirement clearly. Use a custom comparator when custom logic is needed or when the interviewer asks for it.

---
