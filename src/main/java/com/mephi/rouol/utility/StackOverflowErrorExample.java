package com.mephi.rouol.utility;

public class StackOverflowErrorExample {
    public void print(int myInt) {
        StackOverflowErrorExample soee = new StackOverflowErrorExample();
        soee.print(0);
        System.out.println(myInt);
        print(myInt);
    }
}