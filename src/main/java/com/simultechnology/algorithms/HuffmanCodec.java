package com.simultechnology.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
    private final Map<Character, String> codeMap = new HashMap<>();
    private HuffmanNode rootNode; // Variable to store the root node of the Huffman tree


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

        // 単一の文字に対応するノードを正しく扱うための修正
        if (queue.size() == 1) {
            HuffmanNode node = queue.poll();
            HuffmanNode parent = new HuffmanNode('\0', node.frequency);
            parent.leftChild = node; // 単一のノードを左子として追加
            rootNode = parent; // 新しい親ノードをルートとして設定
        } else {
            while (queue.size() > 1) {
                HuffmanNode left = queue.poll();
                HuffmanNode right = queue.poll();
                HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
                parent.leftChild = left;
                parent.rightChild = right;
                queue.add(parent);
            }
            rootNode = queue.poll();
        }
        generateCodes(rootNode, "");
    }

    private void generateCodes(HuffmanNode node, String code) {
        if (!Objects.isNull(node)) {
            if (Objects.isNull(node.leftChild) && Objects.isNull(node.rightChild)) {
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
        HuffmanNode currentNode = rootNode;
        for (int i = 0; i < encodedText.length(); i++) {
            currentNode = encodedText.charAt(i) == '0' ? currentNode.leftChild : currentNode.rightChild;
            if (Objects.isNull(currentNode.leftChild) && Objects.isNull(currentNode.rightChild)) {
                decodedText.append(currentNode.character);
                currentNode = rootNode;
            }
        }
        return decodedText.toString();
    }

}
