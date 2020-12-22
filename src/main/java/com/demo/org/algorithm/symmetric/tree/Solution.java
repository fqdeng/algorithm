package com.demo.org.algorithm.symmetric.tree;

import com.demo.org.algorithm.common.model.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private LinkedList<Integer> list = new LinkedList<>();

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        leftFirstDFS(root.left);
        return rightFirstDFS(root.right);
    }

    boolean rightFirstDFS(TreeNode root) {
        if (root == null) {
            if (list.getFirst() == null) {
                list.removeFirst();
                return true;
            } else {
                return false;
            }
        }
        if (list.getFirst() == null) {
            return false;
        }
        if (list.getFirst() == root.val) {
            list.removeFirst();
        }else{
            return false;
        }
        return rightFirstDFS(root.right) &&
        rightFirstDFS(root.left);
    }

    void leftFirstDFS(TreeNode root) {
        if (root == null) {
            list.add(null);
            return;
        }
        list.add(root.val);
        leftFirstDFS(root.left);
        leftFirstDFS(root.right);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);


        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean b = isSymmetric(root);
        System.out.println("test");
    }
}
