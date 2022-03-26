package com.simultechnology.records;

public record Money(int amount, String symbol) {
    public Money add(Money other) {
        if (symbol.equals(other.symbol)) {
            return new Money(amount + other.amount, symbol);
        } else {
            throw new IllegalArgumentException("The currencies don't match");
        }
    }

    @Override
    public String toString() {
        return  symbol + amount;
    }
}
