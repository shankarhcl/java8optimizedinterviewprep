package com.interviewprep.java8.sorting.prog01_sortemployeesbynameandthensalary;

import com.interviewprep.java8.model.Employee;

import java.util.Comparator;
import java.util.List;

import static com.interviewprep.java8.sorting.prog01_sortemployeesbynameandthensalary.Approach1_Java8StreamApi.getEmployees;

/**
 * Approach 3: Custom Comparator.
 * Demonstrates the mechanics of multi-level comparison explicitly.
 */
public class Approach3_CustomComparator {
    public static void main(String[] args) {
        List<Employee> employees = createSampleEmployees();
        sortedEmployees(employees);
    }

    private static void sortedEmployees(List<Employee> employees) {
        // Custom Comparator for multi-level sorting
        Comparator<Employee> customComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                // First compare by name
                int nameComparison = e1.getName().compareTo(e2.getName());
                if (nameComparison != 0) {
                    return nameComparison;
                }
                // If names are equal, compare by salary
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        };

        // Sort the employees using the custom comparator
        employees.sort(customComparator);
        employees.forEach(System.out::println);
    }

    private static List<Employee> createSampleEmployees() {
        return getEmployees();
    }
}