package com.mephi.rouol;

import com.mephi.rouol.AccountantBot.Accountant;
import com.mephi.rouol.AccountantBot.AccountantDemo;
import com.mephi.rouol.AccountantBot.Employee;
import com.mephi.rouol.AccountantBot.FunctionalInterfacesDemo;
import com.mephi.rouol.Containers.List;
import com.mephi.rouol.Containers.Map;

import java.util.ArrayList;

import com.mephi.rouol.StringEditor.StringEditor;

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

        System.out.println("\n/** LAB 3 **/");
        ArrayList<Employee> employees = Employee.createShortList();
        //System.out.println(employees);
        System.out.println(Accountant.paySalary(employees.get(11)));
        System.out.println(Accountant.payPremium(employees.get(9)));
        System.out.println("\n/** Выплата премии женщинам сотрудникам **/");
        AccountantDemo.payPremiumWomen(employees);
        System.out.println("\n/** Выплата зарплаты сотрудникам определенного департамента **/");
        AccountantDemo.paySalaryFromDept(employees, Employee.Dept.IT);
        System.out.println("\n/** Выплата премии сотрудникам старше 30, работающим в определенном департаменте **/");
        AccountantDemo.payPremiumOverThirtyFromDept(employees, Employee.Dept.SALES);
        System.out.println("\n/** Выплата зарплаты менеджерам **/");
        AccountantDemo.paySalaryManagers(employees);
        System.out.println("\n/** Выплата премии стаффу **/");
        AccountantDemo.payPremiumStaff(employees);

        System.out.println("\n/** HW for LAB 3 **/\n");
        System.out.println("/** Consumer Lambda Expression **/");
        FunctionalInterfacesDemo.exampleConsumerLambdaExpression(employees);
        System.out.println("/** Function Lambda Expression **/");
        FunctionalInterfacesDemo.exampleFunctionLambdaExpression(employees);
        System.out.println("/** Supplier Lambda Expression **/");
        FunctionalInterfacesDemo.exampleSupplierLambdaExpression();
        System.out.println("\n/** BiPredicate Lambda Expression **/");
        FunctionalInterfacesDemo.exampleBiPredicateLambdaExpression(employees);
    }
}
