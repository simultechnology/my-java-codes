package com.simultechnology.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode> {
    int frequency;
    char character;
    HuffmanNode leftChild, rightChild;

    // Constructor for a Huffman node
    HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    // CompareTo method to compare two Huffman nodes based on their frequency
    @Override
    public int compareTo(HuffmanNode o) {
        return this.frequency - o.frequency;
    }
}

public class HuffmanCodec {
    private final Map<Character, String> codeMap = new HashMap<>();
    private HuffmanNode rootNode; // Variable to store the root node of the Huffman tree

    // Constructor that takes the input text and builds the Huffman tree
    public HuffmanCodec(String text) {
        buildHuffmanTree(text);
    }

    // Method to build the Huffman tree based on the frequencies of characters in the text
    private void buildHuffmanTree(String text) {
        Map<Character, Integer> freqMap = new HashMap<>();
        // Counting frequencies of each character
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>();
        // Creating a priority queue of nodes based on the frequencies
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            queue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Handling the case for a single character in the text
        if (queue.size() == 1) {
            HuffmanNode node = queue.poll();
            HuffmanNode parent = new HuffmanNode('\0', node.frequency);
            parent.leftChild = node; // Adding the single node as a left child
            rootNode = parent; // Setting the new parent node as the root
        } else {
            // Building the Huffman tree by combining two lowest frequency nodes at a time
            while (queue.size() > 1) {
                HuffmanNode left = queue.poll();
                HuffmanNode right = queue.poll();
                HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
                parent.leftChild = left;
                parent.rightChild = right;
                queue.add(parent);
            }
            rootNode = queue.poll(); // The last node in the queue is the root of the tree
        }
        generateCodes(rootNode, "");
    }

    // Recursive method to generate Huffman codes for each character
    private void generateCodes(HuffmanNode node, String code) {
        if (!Objects.isNull(node)) {
            if (Objects.isNull(node.leftChild) && Objects.isNull(node.rightChild)) {
                codeMap.put(node.character, code);
            }
            generateCodes(node.leftChild, code + "0");
            generateCodes(node.rightChild, code + "1");
        }
    }

    // Method to encode a text using the generated Huffman codes
    public String encode(String text) {
        StringBuilder encodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedText.append(codeMap.get(c));
        }
        return encodedText.toString();
    }

    // Method to decode an encoded string back to the original text using the Huffman tree
    public String decode(String encodedText) {
        StringBuilder decodedText = new StringBuilder();
        HuffmanNode currentNode = rootNode;
        for (int i = 0; i < encodedText.length(); i++) {
            currentNode = encodedText.charAt(i) == '0' ? currentNode.leftChild : currentNode.rightChild;
            if (Objects.isNull(currentNode.leftChild) && Objects.isNull(currentNode.rightChild)) {
                decodedText.append(currentNode.character);
                currentNode = rootNode; // Reset to start from the root node for the next character
            }
        }
        return decodedText.toString();
    }

}
