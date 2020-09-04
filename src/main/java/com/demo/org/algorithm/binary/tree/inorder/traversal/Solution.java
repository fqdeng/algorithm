package com.demo.org.algorithm.binary.tree.inorder.traversal;

import com.demo.org.algorithm.common.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> result = new ArrayList();

    /**
     * @param root
     * @return
     * @link https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            dfs(root);
        }
        return result;
    }

    /**
     * 中序遍历
     * @param root
     */
    void dfs(TreeNode root) {
        if (root.left != null) {
            //往左递归 找到左节点 为空的节点
            dfs(root.left);
        }
        //加入列表
        result.add(root.val);
        if (root.right != null) {
            dfs(root.right);
        }
    }
}
