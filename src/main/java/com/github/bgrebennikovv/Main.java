package com.github.bgrebennikovv;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Иванов Иван Алексеевич", 1, 50000);
        employees[1] = new Employee("Петров Петр Николаевич", 2, 60000);
        employees[2] = new Employee("Сидоров Алексей Владимирович", 3, 45000);
        employees[3] = new Employee("Кузнецова Марина Олеговна", 4, 70000);
        employees[4] = new Employee("Васильев Олег Сергеевич", 5, 55000);
        employees[5] = new Employee("Тихонов Андрей Иванович", 1, 48000);
        employees[6] = new Employee("Федорова Анна Степановна", 2, 52000);
        employees[7] = new Employee("Громов Виктор Васильевич", 3, 47000);
        employees[8] = new Employee("Самойлова Елена Александровна", 4, 75000);
        employees[9] = new Employee("Дмитриев Артем Дмитриевич", 5, 62000);


        printAllEmployees();
        System.out.println("Общие затраты на ЗП: " + calculateTotalSalary());
        System.out.println("Сотрудник с минимальной ЗП: " + findMinSalaryEmployee());
        System.out.println("Сотрудник с максимальной ЗП: " + findMaxSalaryEmployee());
        System.out.println("Средняя зарплата: " + calculateAverageSalary());
        printEmployeeNames();


    }

    private static void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static double calculateTotalSalary() {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary();
        }
        return total;
    }

    private static Employee findMinSalaryEmployee() {
        return Arrays.stream(employees)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    private static Employee findMaxSalaryEmployee() {
        return Arrays.stream(employees)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    private static double calculateAverageSalary() {
        return calculateTotalSalary() / employees.length;
    }

    private static void printEmployeeNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }
}