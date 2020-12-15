package com.demo.org.algorithm.flatten.binary.tree;

import com.demo.org.algorithm.common.model.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<TreeNode> treeNodeList = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root);
        for (int i = 0; i < treeNodeList.size() - 1; i++) {
            root.left = null;
            root.right = treeNodeList.get(i + 1);
            root = root.right;
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        treeNodeList.add(root);
        dfs(root.left);
        dfs(root.right);
    }


    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(5);

        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);

        treeNode.right.left = null;
        treeNode.right.right = new TreeNode(6);

        flatten(treeNode);
        System.out.println(treeNodeList);
    }

}
