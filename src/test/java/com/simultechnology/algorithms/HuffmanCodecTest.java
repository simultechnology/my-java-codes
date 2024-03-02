package com.simultechnology.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HuffmanCodecTest {

    @Test
    public void testEncodeDecode() {
        String originalText = "simultechnology";
        HuffmanCodec codec = new HuffmanCodec(originalText);

        String encoded = codec.encode(originalText);
        String decoded = codec.decode(encoded);

        assertEquals(originalText, decoded, "Decoded text should match the original text.");
    }

    @Test
    public void testEmptyString() {
        String originalText = "";
        HuffmanCodec codec = new HuffmanCodec(originalText);

        String encoded = codec.encode(originalText);
        String decoded = codec.decode(encoded);

        assertEquals(originalText, decoded, "Decoded text should match the original text even if it is empty.");
    }

    @Test
    public void testSingleCharacterString() {
        String originalText = "aaaaaa";
        HuffmanCodec codec = new HuffmanCodec(originalText);

        String encoded = codec.encode(originalText);
        String decoded = codec.decode(encoded);

        assertEquals(originalText, decoded, "Decoded text should match the original text even if it consists of a single character.");
    }
}
