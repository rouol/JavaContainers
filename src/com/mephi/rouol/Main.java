package com.mephi.rouol;

public class Main {

    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<Integer>(10, 0);

        //Add elements
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        System.out.println(dynamicArray.get(10));
        System.out.println(dynamicArray.size());
        System.out.println(dynamicArray);
    }
}
