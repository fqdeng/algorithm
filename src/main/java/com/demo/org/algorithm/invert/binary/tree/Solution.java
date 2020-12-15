package com.demo.org.algorithm.invert.binary.tree;

import com.demo.org.algorithm.common.model.TreeNode;

public class Solution {

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
        dfs(treeNode.left);
        dfs(treeNode.right);
    }
}
