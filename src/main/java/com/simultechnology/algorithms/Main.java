package com.simultechnology.algorithms;

public class Main {

    public static void main(String[] args) {
        String text = "simultechnology";
        HuffmanCodec codec = new HuffmanCodec(text);
        String encoded = codec.encode(text);
        System.out.println("Encoded: " + encoded);
        String decoded = codec.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}
