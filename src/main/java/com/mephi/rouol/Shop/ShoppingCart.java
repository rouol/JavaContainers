package com.mephi.rouol.Shop;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class ShoppingCart implements Serializable {
    int cartID;
    ArrayList<Item> items;
    int itemCount;
    transient double cartTotal;
    Date serializationDate;

    public ShoppingCart() {
        Random random = new Random();
        this.cartID = random.nextInt(100000);
        this.items = new ArrayList<Item>();
        this.itemCount = 0;
        this.cartTotal = 0;
    }

    public Date getSerializationDate() {
        return serializationDate;
    }

    public void writeToFile(String filePath) throws IOException {
        try (OutputStream os = Files.newOutputStream(Path.of(filePath));
             ObjectOutputStream oos = new ObjectOutputStream(os)) {
            this.serializationDate = Date.valueOf(LocalDate.now());
            oos.writeObject(this);
            }
    }

    public static ShoppingCart readFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (InputStream is = Files.newInputStream(Path.of(filePath));
             ObjectInputStream ois = new ObjectInputStream(is)) {
            ShoppingCart shoppingCart = (ShoppingCart) ois.readObject();
            shoppingCart.items.forEach(item -> shoppingCart.cartTotal += item.cost); // зачем? неясно
            return shoppingCart;
        }
    }

//    public void writeItemsToFile(String filePath) throws IOException {
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
//        try (OutputStream os = Files.newOutputStream(Path.of(filePath));
//             ObjectOutputStream oos = new ObjectOutputStream(os)) {
//            oos.writeObject(this.items);
//        }
//    }
//
//    public void readItemsFromFile(String filePath) throws IOException, ClassNotFoundException {
//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
//
//        try (InputStream is = Files.newInputStream(Path.of(filePath));
//             ObjectInputStream ois = new ObjectInputStream(is)) {
//            // WARN Files.newInputStream is not buffered; ObjectInputStream might
//            // be buffered (I don't remember).
//            ArrayList<Item> itemList = (ArrayList<Item>) ois.readObject();
//            itemList.forEach(this::add);
//        }
//    }

    public void add(Item item) {
        this.items.add(item);
        this.itemCount++;
        this.cartTotal += item.cost;
    }

    public void remove(Item item) {
        this.items.remove(item);
        this.itemCount--;
        this.cartTotal -= item.cost;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartID=" + cartID +
                ", items=" + items +
                ", itemCount=" + itemCount +
                ", cartTotal=" + cartTotal +
                '}';
    }
}
