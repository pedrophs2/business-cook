package com.arpdevs.businesscook.helpers;

import java.util.Collection;

public class IterableHelper<T> {
    Iterable<T> list;

    public IterableHelper(Iterable<T> list) {
        super();
        this.list = list;
    }

    public boolean isEmpty() {
        if (((Collection<?>) list).size() <= 0)
            return true;

        return false;
    }
}
