package com.mephi.rouol.AccountantBot;

public class EmployeeBuilder {
    private String givenName;
    private String surName;
    private int age;
    private Employee.Gender gender;
    private Employee.Role role;
    private Employee.Dept dept;
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state;
    private int code;

    public EmployeeBuilder setGivenName(String givenName) {
        this.givenName = givenName;
        return this;
    }

    public EmployeeBuilder setSurName(String surName) {
        this.surName = surName;
        return this;
    }

    public EmployeeBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public EmployeeBuilder setGender(Employee.Gender gender) {
        this.gender = gender;
        return this;
    }

    public EmployeeBuilder setRole(Employee.Role role) {
        this.role = role;
        return this;
    }

    public EmployeeBuilder setDept(Employee.Dept dept) {
        this.dept = dept;
        return this;
    }

    public EmployeeBuilder seteMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public EmployeeBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public EmployeeBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public EmployeeBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public EmployeeBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public EmployeeBuilder setCode(int code) {
        this.code = code;
        return this;
    }

    public Employee createEmployee() {
        return new Employee(givenName, surName, age, gender, role, dept, eMail, phone, address, city, state, code);
    }
}