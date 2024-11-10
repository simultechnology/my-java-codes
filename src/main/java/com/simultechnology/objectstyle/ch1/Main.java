package com.simultechnology.objectstyle.ch1;

public class Main {
    public static void main(String[] args) {
        System.out.println("start!");

        Foo object1 = new Foo(3);
        Foo object2 = new Foo(8);
        int someNumberFrom = object2.getSomeNumberFrom(object1);
        System.out.println(someNumberFrom);
    }
}
