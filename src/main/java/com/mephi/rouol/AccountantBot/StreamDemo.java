package com.mephi.rouol.AccountantBot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;

public class StreamDemo {
    // демонстрация работы map
    /** Выплата зп всем сотрудникам IT отдела **/
    public static void paySalaryToITDept(ArrayList<Employee> employees) {
        employees.stream()
                .filter(p -> p.getDept().equals(Employee.Dept.IT))
                .map(Accountant::paySalary)
                .forEach(System.out::println);
    }
    // демонстрация работы peek - выводит список работников
    /** Выплата зп всем сотрудникам IT отдела **/
    public static void paySalaryToITDeptANDPrint(ArrayList<Employee> employees) {
        employees.stream()
                .filter(p -> p.getDept().equals(Employee.Dept.IT))
                .peek(System.out::println)
                .map(Accountant::paySalary)
                .forEach(System.out::println);
    }
    // демонстрация работы findFirst
    /** Выводит первого работника из ИТ отдела **/
    public static void showFirstFromITDept(ArrayList<Employee> employees) {
        Optional<Employee> e = employees.stream().filter(p -> p.getDept().equals(Employee.Dept.IT)).findFirst();
        e.ifPresent(System.out::println);
    }
    // lazy
    /** Выплата премии всем сотрудникам IT отдела **/
    public static void payPremiumToITDept(ArrayList<Employee> employees) {
        employees.stream()
                .filter(p -> p.getDept().equals(Employee.Dept.IT))
                .map(Accountant::paySalary)
                .forEach(System.out::println);;
    }
    // max
    /** Сотрудник с самой большой зарплатой **/
    public static void employeeWithMaxSalary(ArrayList<Employee> employees) {
        employees.stream().map(Accountant::paySalary);
        Optional<Employee> e = employees.stream().max(Comparator.comparing(Employee::getSalary));
        e.ifPresent(System.out::println);
    }
    // min
    /** Сотрудник с самой маленькой зарплатой **/
    public static void employeeWithMinSalary(ArrayList<Employee> employees) {
        Optional<Employee> e = employees.stream().min(Comparator.comparing(Employee::getSalary));
        e.ifPresent(System.out::println);
    }
    // average
    /** Средняя зп сотрудников **/
    public static void employeesAvgSalary(ArrayList<Employee> employees) {
        OptionalDouble e = employees.stream().mapToInt(p -> (int) p.getSalary()).average();
        e.ifPresent(System.out::println);
    }
    // sum
    /** Сумма зп сотрудников **/
    public static void employeesSumSalary(ArrayList<Employee> employees) {
        int e = employees.stream().mapToInt(p -> (int) p.getSalary()).sum();
        System.out.println(e);
    }
}
