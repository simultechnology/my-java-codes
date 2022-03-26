package com.simultechnology.records;

final class OldMoney {
    private final int amount;
    private final String symbol;

    public OldMoney(int amount, String symbol) {
        this.amount = amount;
        this.symbol = symbol;
    }

    public int getAmount() {
        return amount;
    }

    public String getSymbol() {
        return symbol;
    }

}
