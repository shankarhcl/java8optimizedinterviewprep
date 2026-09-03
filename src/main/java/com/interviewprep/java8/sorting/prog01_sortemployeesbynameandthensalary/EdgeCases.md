# Edge Cases

1. **Empty list**: return an empty result.
2. **Single employee**: already sorted.
3. **Duplicate names**: salary determines the order.
4. **Same name and salary**: comparator returns zero for the two keys.
5. **Null name**: basic implementation assumes non-null names. If null is valid, define a null policy with `Comparator.nullsFirst()` or `nullsLast()`.
6. **Null employee**: requires explicit null handling if permitted by the domain.
7. **Negative salary**: technically sortable, but validity depends on the business domain.
8. **Large monetary values**: for real financial calculations, `BigDecimal` is generally more appropriate than `double`.

---