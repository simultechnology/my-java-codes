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
        // 符号から文字へのマップを生成
        map.put("100", "l");
        map.put("110", "o");
        map.put("000", "y");
        map.put("0010", "c");
        map.put("0011", "e");
        map.put("0100", "g");
        map.put("0101", "h");
        map.put("0110", "i");
        map.put("0111", "m");
        map.put("1010", "n");
        map.put("1011", "s");
        map.put("1110", "t");
        map.put("1111", "u");

        char[] charArray = binaryValues.toCharArray();
        StringBuilder decodeBuffer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (Character c : charArray) {
            System.out.print(c);
            sb.append(c);
            if (map.containsKey(sb.toString())) {
                System.out.println(" found");
                decodeBuffer.append(map.get(sb.toString()));
                sb.delete(0, sb.length());
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
