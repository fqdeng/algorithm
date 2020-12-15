package com.demo.org.algorithm.common.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    public int val;

    public Node left, right;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public void print() {
        print("", true);
    }

    protected List<Node> getChildren() {
        List<Node> nodes = new ArrayList<>();
        if (left != null) nodes.add(left);
        if (right != null) nodes.add(right);
        return nodes;
    }

    private void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└──" : "├──") + val);
        List<Node> children = getChildren();
        for (int i = 0; i < getChildren().size() - 1; i++) {
            children.get(i).print(prefix + (isTail ? " " : "│ "), false);
        }
        if (children.size() > 0) {
            children.get(children.size() - 1).print(prefix + (isTail ? " " : "│ "), true);
        }
    }
}
