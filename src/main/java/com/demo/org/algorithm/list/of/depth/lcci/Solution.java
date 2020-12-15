package com.demo.org.algorithm.list.of.depth.lcci;

import com.demo.org.algorithm.common.model.ListNode;
import com.demo.org.algorithm.common.model.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(tree);
        List<ListNode> results = new ArrayList<>();
        while (!treeNodeQueue.isEmpty()) {
            ListNode head = null;
            ListNode layer = null;
            List<TreeNode> nextLayer = new ArrayList<>();
            while (!treeNodeQueue.isEmpty()) {
                TreeNode treeNode = treeNodeQueue.poll();
                if (head == null) {
                    head = new ListNode(treeNode.val);
                    layer = head;
                } else {
                    head.next = new ListNode(treeNode.val);
                    head = head.next;
                }
                if (treeNode.left != null) {
                    nextLayer.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLayer.add(treeNode.right);
                }
            }
            results.add(layer);
            treeNodeQueue.addAll(nextLayer);
        }
        ListNode[] nodes = new ListNode[results.size()];
        for (int i = 0; i < results.size(); i++) {
            nodes[i]  = results.get(i);
        }
        return nodes;
    }

    @Test
    public void test(){

    }
}
