package com.mephi.rouol.Shop;

import java.io.*;

public class Item implements Serializable {
    int id;
    String description;
    double cost;

    public Item(int id, String description, double cost) {
        this.id = id;
        this.description = description;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
