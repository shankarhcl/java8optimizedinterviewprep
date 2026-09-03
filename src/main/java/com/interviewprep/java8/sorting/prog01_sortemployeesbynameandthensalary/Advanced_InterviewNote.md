# Advanced Interview Note

## Comparator Chaining or Multi-Level Sorting

The comparator follows this decision flow:
Compare name
   |
   +-- different --> name decides order
   |
   +-- equal -----> compare salary

## Stream vs List.sort()

Stream sorting followed by `collect()` creates a separate result list. `List.sort()` sorts the existing list.

The choice depends on whether the original list may be modified and whether the sorting operation is part of a larger stream pipeline.

## Stable Sorting

Java's object sorting is stable. When the comparator considers two employees equal, their relative order is preserved.

## Interview Communication

Before coding, say:
> I need a two-level sort. Name is the primary key in ascending order. Salary is the secondary key and is considered when the names are equal.

This demonstrates understanding before implementation.

---