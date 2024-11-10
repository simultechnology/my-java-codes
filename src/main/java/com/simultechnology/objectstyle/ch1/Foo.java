package com.simultechnology.objectstyle.ch1;

class Foo {
    private final int someNumber;

    // コンストラクタやメソッドなどの他の部分を追加できます
    public Foo(int number) {
        this.someNumber = number;
    }

    public int getSomeNumberFrom(Foo other) {
        return other.someNumber;   // 2: `getSomeNumber` を経由してアクセス
    }
}