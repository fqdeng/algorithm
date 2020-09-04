package com.demo.org.algorithm.binary.tree.paths;

import com.demo.org.algorithm.common.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    private List<List<Integer>> temps = new ArrayList<>();

    private List<Integer> temp = new ArrayList<>();


    /**
     * 典型的 dfs
     * 还是牢记递归三要素
     * 1. 终止条件
     * 2. 当前需要解决的问题 子问题是什么 问题的规模是否能简化
     * 3. 父子问题不能重叠
     * @param root
     * @return
     * @link https://leetcode-cn.com/problems/binary-tree-paths/
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        dfs(root);
        List<String> results = new ArrayList<>();
        for (List<Integer> result : temps) {
            results.add(convert(result));
        }
        return results;
    }

    private String convert(List<Integer> result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            stringBuilder.append(result.get(i));
            if (i != result.size() - 1) {
                stringBuilder.append("->");
            }
        }
        return stringBuilder.toString();
    }

    private void dfs(TreeNode node) {
        //到叶子节点才算终结 所以终结条件是当前节点的两个子节点都为Null
        // 此时深度搜索到此为止
        if (node.right == null && node.left == null) {
            temp.add(node.val);
            //将已经搜索的路径 快照下来
            temps.add(new ArrayList<>(temp));
            //因为temp记录是深度搜索的路径
            //所以每次加入当前节点后都需要清理节点 还原状态
            temp.remove(temp.size() - 1);
            return;
        }
        temp.add(node.val);
        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
        //同理
        //因为temp记录是深度搜索的路径
        //所以每次加入当前节点后都需要清理节点 还原状态
        temp.remove(temp.size() - 1);
    }

}
