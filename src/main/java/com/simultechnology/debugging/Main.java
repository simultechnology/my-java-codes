package com.simultechnology.debugging;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("start!");
        int i = 0;
        while (true) {
            UUID uuid = UUID.randomUUID();
            products.add(
                    new Product(uuid.toString(), i++)
            );
            System.out.println(products.size() + " " + i);
        }
    }
}
