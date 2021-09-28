package com.mephi.rouol;

public class Main {

    public static void main(String[] args) {
        List list = new List();

        System.out.println(list.isEmpty());

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

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
}
