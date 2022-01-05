package com.simultechnology.samples;

import java.util.ArrayList;
import java.util.List;

public class Container2<T> {
    List<T> list = new ArrayList<>();

    public void addAll(List<? extends T> src) {
        for (T t: src) {
            list.add(t);
        }
    }

    public void copy(List<? super T> dest) {
        for (T v: list) {
            dest.add(v);
        }
    }

    public List<T> getList() {
        return list;
    }


}
