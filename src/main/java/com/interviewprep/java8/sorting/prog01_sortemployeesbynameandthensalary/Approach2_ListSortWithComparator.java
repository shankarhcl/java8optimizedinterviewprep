package com.interviewprep.java8.sorting.prog01_sortemployeesbynameandthensalary;

import com.interviewprep.java8.model.Employee;

import java.util.Comparator;
import java.util.List;

import static com.interviewprep.java8.sorting.prog01_sortemployeesbynameandthensalary.Approach1_Java8StreamApi.getEmployees;

/**
 * Approach 2: List.sort() with Comparator.
 * Sorts the existing list in place.
 */
public class Approach2_ListSortWithComparator {
    public static void main(String[] args) {
        List<Employee> employees = createSampleEmployees();
        sortedEmployees(employees);
    }

    private static void sortedEmployees(List<Employee> employees) {
        employees.sort(
                Comparator.comparing(Employee::getName)
                        .thenComparingDouble(Employee::getSalary)
        );

        employees.forEach(System.out::println);
    }

    private static List<Employee> createSampleEmployees() {
        return getEmployees();
    }
}