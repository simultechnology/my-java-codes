package com.simultechnology.samples;

public record Container<T>(T value) {

    public T getValue() {
        return value;
    }
}
