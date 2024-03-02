package com.simultechnology.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode> {
    int frequency;
    char character;
    HuffmanNode leftChild, rightChild;

    HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.frequency - o.frequency;
    }
}

public class HuffmanCodec {
    private Map<Character, String> codeMap = new HashMap<>();

    public HuffmanCodec(String text) {
        buildHuffmanTree(text);
    }

    private void buildHuffmanTree(String text) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            queue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (queue.size() > 1) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
            parent.leftChild = left;
            parent.rightChild = right;
            queue.add(parent);
        }

        generateCodes(queue.poll(), "");
    }

    private void generateCodes(HuffmanNode node, String code) {
        if (node != null) {
            if (node.leftChild == null && node.rightChild == null) {
                codeMap.put(node.character, code);
            }
            generateCodes(node.leftChild, code + "0");
            generateCodes(node.rightChild, code + "1");
        }
    }

    public String encode(String text) {
        StringBuilder encodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedText.append(codeMap.get(c));
        }
        return encodedText.toString();
    }

    public String decode(String encodedText) {
        StringBuilder decodedText = new StringBuilder();
        HuffmanNode node = null; // Implement the method to get the root node of your Huffman tree
        HuffmanNode currentNode = node;
        for (int i = 0; i < encodedText.length(); i++) {
            currentNode = encodedText.charAt(i) == '0' ? currentNode.leftChild : currentNode.rightChild;
            if (currentNode.leftChild == null && currentNode.rightChild == null) {
                decodedText.append(currentNode.character);
                currentNode = node; // Reset to root
            }
        }
        return decodedText.toString();
    }

}
