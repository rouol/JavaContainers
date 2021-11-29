package com.mephi.rouol.AccountantBot;

import java.util.ArrayList;

public class AccountantDemo {

    //private static final ArrayList<Employee> employees = Employee.createShortList();
    /** Выплата премии женщинам сотрудникам **/
    public static void payPremiumToWomen(ArrayList<Employee> employees) {
        employees.stream()
                .filter(p -> p.getGender().equals(Employee.Gender.FEMALE))
                .map(Accountant::payPremium)
                .forEach(System.out::println);
    }
    /** Выплата зарплаты сотрудникам определенного департамента **/
    public static void paySalaryByDept(ArrayList<Employee> employees, Employee.Dept dept) {
        employees.stream()
                .filter(p -> p.getDept().equals(dept))
                .map(Accountant::paySalary)
                .forEach(System.out::println);
    }
    /** Выплата премии сотрудникам старше 30, работающим в определенном департаменте **/
    public static void payPremiumByDept30Plus(ArrayList<Employee> employees, Employee.Dept dept) {
        employees.stream()
                .filter(p -> p.getDept().equals(dept) && p.getAge() > 30)
                .map(Accountant::payPremium)
                .forEach(System.out::println);
    }
    /** Выплата зарплаты менеджерам **/
    public static void paySalaryToManagers(ArrayList<Employee> employees) {
        employees.stream()
                .filter(p -> p.getRole().equals(Employee.Role.MANAGER))
                .map(Accountant::paySalary)
                .forEach(System.out::println);
    }
    /** Выплата премии стаффу **/
    public static void payPremiumToStaff(ArrayList<Employee> employees) {
        employees.stream()
                .filter(p -> p.getRole().equals(Employee.Role.STAFF))
                .map(Accountant::payPremium)
                .forEach(System.out::println);
    }

}
