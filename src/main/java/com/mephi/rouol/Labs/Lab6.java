package com.mephi.rouol.Labs;

import com.mephi.rouol.Shop.Item;
import com.mephi.rouol.Shop.ShoppingCart;
import com.mephi.rouol.StringEditor.StringFileEditor;

import java.io.IOException;
import java.util.Random;

public class Lab6 {

    public static void Task1(){
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        StringFileEditor stringFileEditor = new StringFileEditor("sample.txt");
        System.out.println(stringFileEditor.findInputString());
        System.out.println(stringFileEditor.countOccurrences("Lorem"));
    }

    public static void Task2() {
        ShoppingCart shoppingCart = new ShoppingCart();

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            shoppingCart.add(
                    new Item(
                            random.nextInt(100000),
                            "description",
                            random.nextDouble() * 10000)
            );
        }

        System.out.println(shoppingCart);

        // write to file
        try {
            shoppingCart.writeToFile("shoppingCart.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read from file
        ShoppingCart _shoppingCart = null;
        try {
            _shoppingCart = ShoppingCart.readFromFile("shoppingCart.bin");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert _shoppingCart != null;
        System.out.println("Serialized at " + _shoppingCart.getSerializationDate().toString());
        System.out.println(_shoppingCart);

    }

}
