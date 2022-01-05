package com.simultechnology.main;

import com.simultechnology.samples.Container;
import com.simultechnology.samples.Container2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("start!!");

        final Container<String> container = new Container<String>("123");
        String value = container.getValue();
        System.out.println(value);

        List<String> texts = List.of("test", "sample", "banana");
        for (String text : texts) {
            System.out.print(text + " ");
        }
        System.out.println("----------------");

        var list = new ArrayList<>();
        list.add("A");
        list.add(12);
        for (Object obj : list) {
            System.out.println(obj);
        }
        System.out.println("----------------");

        Container2<Number> container2 = new Container2<>();

        List<Number> numberList = List.of(10, 11, 12, 13);
        container2.addAll(numberList);

        List<Integer> integerList = List.of(0, 1, 2, 3);
        container2.addAll(integerList);

        List<Number> list1 = container2.getList();
        for (Number num : list1) {
            System.out.println(String.format("num : %d", num));
        }

        System.out.println("----------------");
        Container2<Integer> myContainer2 = new Container2<>();

        List<Number> nums = new ArrayList<>();
        myContainer2.copy(nums);
    }
}
