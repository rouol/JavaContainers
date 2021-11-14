package com.mephi.rouol.AccountantBot;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.BiPredicate;

public class FunctionalInterfacesDemo {

    /** prints Employees with given surname **/
    public static void exampleConsumerLambdaExpression(ArrayList<Employee> employees){
        Consumer<String> consumer;
        consumer = (surname) -> {
            System.out.println("Сотрудники с фамилией " + surname + ":");
            boolean found = false;
            for (Employee employee:employees) {
                if (employee.getSurName().equals(surname)) {
                    System.out.println(employee);
                    found = true;
                }
            }
            if (!found) System.out.println("Сотрудникм с такой фамилией не найдены.\n");
            else System.out.println();
        };
        String[] surnames = {"Дмитриев", "Воронин", "Соколова", "Морозова"};
        for (String surname:surnames){
            consumer.accept(surname);
        }
    }

    /** prints Employee's dept with given surname **/
    public static void exampleFunctionLambdaExpression(ArrayList<Employee> employees) {
        Function<String, ArrayList<Employee.Dept>> function;
        function = (surname) -> {
            ArrayList<Employee.Dept> requestedEmployeesDept = new ArrayList();
            for (Employee employee:employees) {
                if (employee.getSurName().equals(surname)) {
                    requestedEmployeesDept.add(employee.getDept());
                }
            }
            return requestedEmployeesDept;
        };
        String[] surnames = {"Дмитриев", "Воронин", "Соколова", "Морозова"};
        for (String surname:surnames){
            System.out.println("Отделы сотрудников с фамилией " + surname + ":");
            ArrayList<Employee.Dept> depts = function.apply(surname);
            if(depts.size() == 0) {
                System.out.println("Сотрудники с такой фамилией не найдены.\n");
            } else {
                System.out.println("Найдены в отделах " + depts + "\n");
            }
        }
    }

    /** prints an arbitrary Employee **/
    public static void exampleSupplierLambdaExpression(){
        Supplier<String> supplier = () -> {return "just an an arbitrary Employee: " + Employee.generateEmployee();};
        System.out.println(supplier.get());
    }

    /** checks if is there an Employee with specified surnames and from specified depts **/
    public static void exampleBiPredicateLambdaExpression(ArrayList<Employee> employees) {
        BiPredicate<String, Employee.Dept> biPredicate = (surname, dept) -> {
            for (Employee employee:employees) {
                if (employee.getSurName().equals(surname)) {
                    if (employee.getDept().equals(dept)) {
                        return true;
                    }
                }
            }
            return false;
        };
        String[] surnames = {"Дмитриев", "Воронин", "Соколова", "Морозова"};
        for (String surname:surnames){
            for (Employee.Dept dept: Employee.Dept.values()){
                boolean result = biPredicate.test(surname, dept);
                if (result) {
                    System.out.println("Нашелся сотрудник с фамилией " + surname + " из департамента " + dept);
                }
            }
        }
    }
}
