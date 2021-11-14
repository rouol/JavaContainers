package com.mephi.rouol.AccountantBot;

import java.util.ArrayList;

public class AccountantDemo {

    //private static final ArrayList<Employee> employees = Employee.createShortList();
    /** Выплата премии женщинам сотрудникам **/
    public static void payPremiumWomen(ArrayList<Employee> employees) {
        employees.stream()
                .filter(p -> p.getGender() == Employee.Gender.FEMALE)
                .map(Accountant::payPremium)
                .forEach(System.out::println);
    }
    /** Выплата зарплаты сотрудникам определенного департамента **/
    public static void paySalaryFromDept(ArrayList<Employee> employees, Employee.Dept dept) {
        employees.stream()
                .filter(p -> p.getDept() == dept)
                .map(Accountant::paySalary)
                .forEach(System.out::println);
    }
    /** Выплата премии сотрудникам старше 30, работающим в определенном департаменте **/
    public static void payPremiumOverThirtyFromDept(ArrayList<Employee> employees, Employee.Dept dept) {
        employees.stream()
                .filter(p -> p.getDept() == dept && p.getAge() > 30)
                .map(Accountant::payPremium)
                .forEach(System.out::println);
    }
    /** Выплата зарплаты менеджерам **/
    public static void paySalaryManagers(ArrayList<Employee> employees) {
        employees.stream()
                .filter(p -> p.getRole() == Employee.Role.MANAGER)
                .map(Accountant::paySalary)
                .forEach(System.out::println);
    }
    /** Выплата премии стаффу **/
    public static void payPremiumStaff(ArrayList<Employee> employees) {
        employees.stream()
                .filter(p -> p.getRole() == Employee.Role.STAFF)
                .map(Accountant::payPremium)
                .forEach(System.out::println);
    }

}
