package com.mephi.rouol.AccountantBot;

public class Accountant {

    /** Выплата зарплаты сотруднику **/
    public static String paySalary(Employee employee) {
        employee.setSalary(employee.getRole().getSalary());
        return (employee.getGender().equals(Employee.Gender.MALE) ? "Работник " : "Работница ")
                + employee.getGivenName() + " " + employee.getSurName()
                + " с ролью " + employee.getRole() + " "
                + (employee.getGender().equals(Employee.Gender.MALE) ? "получил" : "получила")
                + " зарплату в размере " + employee.getRole().getSalary() + "₽";
    }
    /** Выплата премии сотруднику **/
    public static String payPremium(Employee employee) {
        employee.setSalary(employee.getSalary() + (int)(employee.getRole().getPremium() * employee.getRole().getSalary()));
        return (employee.getGender().equals(Employee.Gender.MALE) ? "Работник " : "Работница ")
                + employee.getGivenName() + " " + employee.getSurName()
                + " с ролью " + employee.getRole() + " "
                + (employee.getGender().equals(Employee.Gender.MALE) ? "получил" : "получила")
                + " премию в размере " + (int)(employee.getRole().getPremium() * employee.getRole().getSalary()) + "₽";
    }

}
