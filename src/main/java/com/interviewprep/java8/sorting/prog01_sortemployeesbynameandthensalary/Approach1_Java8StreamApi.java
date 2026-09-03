package com.interviewprep.java8.sorting.prog01_sortemployeesbynameandthensalary;

import com.interviewprep.java8.model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Approach 1: Java 8 Stream API.
 * Sort by name ascending, then salary ascending.
 */
public class Approach1_Java8StreamApi {
    public static void main(String[] args) {
        List<Employee> employees = createSampleEmployees();
        List<Employee> sortedEmployees = sortedEmployees(employees);
        sortedEmployees.forEach(System.out::println);
    }

    private static List<Employee> sortedEmployees(List<Employee> employees) {
        return employees.stream()
                .sorted(
                        Comparator.comparing(Employee::getName)
                                .thenComparingDouble(Employee::getSalary)
                )
                .collect(Collectors.toList());
    }

    private static List<Employee> createSampleEmployees() {
        return getEmployees();
    }

    static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 100000.0));
        employees.add(new Employee("Jane Doe", 200000.0));
        employees.add(new Employee("Eric", 400000.0));
        employees.add(new Employee("Hanary", 700000.0));
        employees.add(new Employee("Hanary", 500000.0));
        employees.add(new Employee("Eric", 300000.0));
        return employees;
    }
}