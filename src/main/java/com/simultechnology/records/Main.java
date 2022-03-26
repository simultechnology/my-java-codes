package com.simultechnology.records;

public class Main {
    public static void main(String[] args) {
        System.out.println("start!");

        Money money = new Money(1000, "￥");

        int amount = money.amount();
        String symbol = money.symbol();
    }
}
