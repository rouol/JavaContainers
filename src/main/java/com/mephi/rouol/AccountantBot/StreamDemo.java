package com.mephi.rouol.AccountantBot;

import java.util.List;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;

public class StreamDemo {
    // демонстрация работы map
    /** Выплата зп всем сотрудникам IT отдела **/
    public static void paySalaryToITDept(List<Employee> employees) {
        employees.stream()
                .filter(p -> p.getDept().equals(Employee.Dept.IT))
                .map(Accountant::paySalary)
                .forEach(System.out::println);
    }
    // демонстрация работы peek - выводит список работников
    /** Выплата зп всем сотрудникам IT отдела **/
    public static void paySalaryToITDeptANDPrint(List<Employee> employees) {
        employees.stream()
                .filter(p -> p.getDept().equals(Employee.Dept.IT))
                .peek(System.out::println)
                .map(Accountant::paySalary)
                .forEach(System.out::println);
    }
    // демонстрация работы findFirst
    /** Выводит первого работника из ИТ отдела **/
    public static void showFirstFromITDept(List<Employee> employees) {
        Optional<Employee> e = employees.stream().filter(p -> p.getDept().equals(Employee.Dept.IT)).findFirst();
        e.ifPresent(System.out::println);
    }
    // lazy
    /** Выплата премии всем сотрудникам IT отдела **/
    public static void payPremiumToITDept(List<Employee> employees) {
        employees.stream()
                .filter(p -> p.getDept().equals(Employee.Dept.IT))
                .peek(System.out::println)
                .map(Accountant::paySalary)
                .forEach(System.out::println);
    }
    // max
    /** Сотрудник с самой большой зарплатой **/
    public static void employeeWithMaxSalary(List<Employee> employees) {
        employees.stream().map(Accountant::paySalary);
        employees.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);
    }
    // min
    /** Сотрудник с самой маленькой зарплатой **/
    public static void employeeWithMinSalary(List<Employee> employees) {
        Optional<Employee> e = employees.stream().min(Comparator.comparing(Employee::getSalary));
        e.ifPresent(System.out::println);
    }
    // average
    /** Средняя зп сотрудников **/
    public static void employeesAvgSalary(List<Employee> employees) {
        OptionalDouble e = employees.stream().mapToInt(p -> (int) p.getSalary()).average();
        e.ifPresent(System.out::println);
    }
    // sum
    /** Сумма зп сотрудников **/
    public static void employeesSumSalary(List<Employee> employees) {
        int e = employees.stream().mapToInt(p -> (int) p.getSalary()).sum();
        System.out.println(e);
    }
}
