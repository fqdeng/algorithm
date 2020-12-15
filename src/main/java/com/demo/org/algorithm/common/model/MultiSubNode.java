package com.demo.org.algorithm.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MultiSubNode {

    public MultiSubNode(int value) {
        this.value = value;
        this.subs = new ArrayList<>();
    }

    public int value;

    public List<MultiSubNode> subs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiSubNode that = (MultiSubNode) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
