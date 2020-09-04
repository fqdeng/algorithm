package com.demo.org.algorithm.find.a.corresponding.node.of.a.binary.tree.in.a.clone.of.that.tree;

import com.demo.org.algorithm.common.model.TreeNode;

public class Solution {

    private TreeNode target = null;
    private TreeNode cloned = null;


    /**
     * @param original
     * @param cloned
     * @param target
     * @return
     * @link https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/submissions/
     * dfs 找节点即可
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (target == null) {
            return null;
        }
        this.target = target;
        dfs(original, cloned);
        return this.cloned;
    }

    private void dfs(TreeNode original, TreeNode cloned) {
        if (orginal == null) {
            //当前节点为空 递归终止
            return;
        }
        if (orginal == target) {
            //当前节点为找到的节点 递归终止
            this.cloned = cloned;
            return;
        }
        if (orginal.right != null) {
            dfs(orginal.right, cloned.right);
        }
        if (orginal.left != null) {
            dfs(orginal.left, cloned.left);
        }
    }
}
