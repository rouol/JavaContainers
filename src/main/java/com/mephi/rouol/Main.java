package com.mephi.rouol;

import com.mephi.rouol.AccountantBot.*;
import com.mephi.rouol.Containers.List;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // old labs
        /*
        // checking the List
        System.out.println("\n        checking the List\n");
        {
            List list = new List();

            System.out.println(list.isEmpty());

            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            list.remove(2);
            System.out.println(list.get(2));

            System.out.println(list.get(0));

            System.out.println(list.contains(8));
            list.add(8, 1);
            System.out.println(list.contains(8));
            System.out.println(list.indexOf(8));

            System.out.println(list.size());

            System.out.println(list.isEmpty());

            System.out.println(list);
            System.out.println(list.remove(1));
            System.out.println(list);

            list.add(10, 4);
            System.out.println(list);

            System.out.println(list.set(100, 4));
            System.out.println(list);

            List newlist = new List(10, "sdjfhjshdfkjsh");
            System.out.println(newlist);
        }

        // checking the Map
        {
            System.out.println("\n        checking the Map\n");

            Map map = new Map();

            System.out.println(map.isEmpty());

            map.put(0, 10);
            map.put(1, "ааа");
            map.put(17, new List(3, "ыыы"));
            map.put(2, 228);
            map.put(3, "java");
            map.put("dsjfkl", "sdfsdfsdf");
            System.out.println(map);
            System.out.println(map.get("dsjfkl"));
            System.out.println(map.remove(1));
            System.out.println(map.keyContains(100));
            System.out.println(map.get(100, "100"));
            System.out.println(map.keyContains(100));
            System.out.println(map);
            System.out.println(map.getKeys().toString());
            System.out.println(map.getValues().toString());
            System.out.println(map.getEntries().toString());
            System.out.println(map.size());

            System.out.println(map.isEmpty());
        }

        // checking mergeSortedLists
        {
            List a = new List(new Object[]{0, 1, 2, 7, 9});
            List b = new List(new Object[]{-1, 2, 3, 4, 5, 8, 11});
            List merged = List.mergeSortedLists(a, b);
            System.out.println(merged);
        }

        System.out.println();
        System.out.println("\n                          LAB 2\n");
        System.out.println("\n        checking countAllSubstr and reduceOccurences\n");
        // checking countAllSubstr
        {
            String str = "aaa bab jsd sdfs jsd aaa aaa aba";
            System.out.println(str);
            System.out.println(StringEditor.countAllSubstr(str));
            System.out.println(StringEditor.reduceOccurences(str));
        }
        */

//        System.out.println("\n/** LAB 3 **/");
//        {
//            ArrayList<Employee> employees = Employee.createShortList();
//            //System.out.println(employees);
//            System.out.println(Accountant.paySalary(employees.get(11)));
//            System.out.println(Accountant.payPremium(employees.get(9)));
//            System.out.println("\n/** Выплата премии женщинам сотрудникам **/");
//            AccountantDemo.payPremiumToWomen(employees);
//            System.out.println("\n/** Выплата зарплаты сотрудникам определенного департамента **/");
//            AccountantDemo.paySalaryByDept(employees, Employee.Dept.IT);
//            System.out.println("\n/** Выплата премии сотрудникам старше 30, работающим в определенном департаменте **/");
//            AccountantDemo.payPremiumByDept30Plus(employees, Employee.Dept.SALES);
//            System.out.println("\n/** Выплата зарплаты менеджерам **/");
//            AccountantDemo.paySalaryToManagers(employees);
//            System.out.println("\n/** Выплата премии стаффу **/");
//            AccountantDemo.payPremiumToStaff(employees);
//
//            System.out.println("\n/** HW for LAB 3 **/\n");
//            System.out.println("/** Consumer Lambda Expression **/");
//            FunctionalInterfacesDemo.exampleConsumerLambdaExpression(employees);
//            System.out.println("/** Function Lambda Expression **/");
//            FunctionalInterfacesDemo.exampleFunctionLambdaExpression(employees);
//            System.out.println("/** Supplier Lambda Expression **/");
//            FunctionalInterfacesDemo.exampleSupplierLambdaExpression();
//            System.out.println("\n/** BiPredicate Lambda Expression **/");
//            FunctionalInterfacesDemo.exampleBiPredicateLambdaExpression(employees);
//        }

        System.out.println("\n/** LAB 4 **/");
        {
            ArrayList<Employee> employees = Employee.createShortList();
            System.out.println("/** map **/");
            StreamDemo.paySalaryToITDept(employees);
            System.out.println("/** map and peek **/");
            StreamDemo.paySalaryToITDeptANDPrint(employees);
            System.out.println("/** findFirst **/");
            StreamDemo.showFirstFromITDept(employees);
            System.out.println("/** lazy **/");
            StreamDemo.payPremiumToITDept(employees);

            employees = Employee.createShortList();
            employees.stream().map(Accountant::paySalary).forEach(System.out::print);
            employees.stream().map(Accountant::payPremium).forEach(System.out::print);;

            System.out.println("/** max **/");
            StreamDemo.employeeWithMaxSalary(employees);
            System.out.println("/** min **/");
            StreamDemo.employeeWithMinSalary(employees);
            System.out.println("/** average **/");
            StreamDemo.employeesAvgSalary(employees);
            System.out.println("/** sum **/");
            StreamDemo.employeesSumSalary(employees);
        }

        System.out.println("\n/** LAB 5 **/");
        {

            List list = new List(new Object[]{-1, 2, 3, 4, 5, 8, 11});
            try {
                list.remove(20);
                } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("поймано " + e);
            }

            System.out.println("\n/** FileNotFoundException **/");
            try {
                File file = new File("nonexistent.txt");
                Scanner scan = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println("поймано " + e);
            }

            System.out.println("\n/** NullPointerException **/");
            try {
                String myString = null;
                System.out.println(myString.toLowerCase(Locale.ROOT));
            } catch (NullPointerException e) {
                System.out.println("поймано " + e);
            }

            System.out.println("\n/** IOException **/");
            try {
                File file = new File("nonexistent.txt");
                FileInputStream fileInputStream = new FileInputStream(file);
            } catch (IOException e) {
                System.out.println("поймано " + e);
            }

            System.out.println("\n/** ClassCastException **/");
            try {
                Object i = 42;
                String s = (String)i;
            } catch (ClassCastException e) {
                System.out.println("поймано " + e);
            }

            System.out.println("\n/** ArithmeticException **/");
            try {
                int exampleVariableOne = 500/0;
            } catch (ArithmeticException e) {
                System.out.println("поймано " + e);
            }

        }

    }
}
