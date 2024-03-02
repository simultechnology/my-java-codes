package com.simultechnology.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanCoding {
    public static void main(String[] args) {
        System.out.println("start!");

        String text = "simultechnology";

        String binaryValues = "1011011001111111100111000110010010110101101001100100000";

        HashMap<String, String> map = new HashMap<>();
        map.put("l", "100");
        map.put("o", "110");
        map.put("y", "000");
        map.put("c", "0010");
        map.put("e", "0011");
        map.put("g", "0100");
        map.put("h", "0101");
        map.put("i", "0110");
        map.put("m", "0111");
        map.put("n", "1010");
        map.put("s", "1011");
        map.put("t", "1110");
        map.put("u", "1111");

        char[] charArray = binaryValues.toCharArray();
        StringBuilder decodeBuffer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (Character c : charArray) {
            System.out.print(c);
            sb.append(c);
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value.contentEquals(sb)) {
                    System.out.println(" found");
                    decodeBuffer.append(key);
                    sb.delete(0, sb.length());
                }
            }
        }

        System.out.println("decoded: " + decodeBuffer);
//        HuffmanTree tree = new HuffmanTree(text);
//        String encoded = tree.encode(text);
//        String decoded = tree.decode(encoded);

        System.out.println("Original text: " + text);
//        System.out.println("Encoded text: " + encoded);
//        System.out.println("Decoded text: " + decoded);
    }
}
