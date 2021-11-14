package com.mephi.rouol.AccountantBot;

public class Accountant {

    public static String paySalary(Employee employee) {
        return (employee.getGender() == Employee.Gender.MALE ? "Работник " : "Работница ")
                + employee.getGivenName() + " " + employee.getSurName()
                + " с ролью " + employee.getRole() + " "
                + (employee.getGender() == Employee.Gender.MALE ? "получил" : "получила")
                + " зарплату в размере " + employee.getRole().getSalary() + "₽";
    }

    public static String payPremium(Employee employee) {
        return (employee.getGender() == Employee.Gender.MALE ? "Работник " : "Работница ")
                + employee.getGivenName() + " " + employee.getSurName()
                + " с ролью " + employee.getRole() + " "
                + (employee.getGender() == Employee.Gender.MALE ? "получил" : "получила")
                + " премию в размере " + (int)(employee.getRole().getPremium() * employee.getRole().getSalary()) + "₽";
    }

}
