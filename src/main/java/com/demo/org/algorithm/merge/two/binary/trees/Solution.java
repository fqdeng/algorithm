package com.demo.org.algorithm.merge.two.binary.trees;

import com.demo.org.algorithm.common.model.TreeNode;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return dfs(t1,t2);
    }

    private TreeNode dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode temp = null;
        if (t1 == null) {
            temp = t2;
        }
        if (t2 == null){
            temp = t1;
        }
        if (t2 != null && t1 != null) {
            t1.val += t2.val;
            temp = t1;
        }
        temp.right = dfs(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        temp.left = dfs(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        return temp;
    }
}
