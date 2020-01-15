package com.demo.org.algorithm.merge.two.sorted.linked.list;

import org.junit.Test;

import java.util.List;

/**
 * 合并两个有序链表
 * @link https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val > l2.val) {
            return mergeList(l2, l1);
        } else {
            return mergeList(l1, l2);
        }
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode currentL1 = l1;
        while (l2 != null) {
            ListNode currentL2 = l2;
            // if you have already separate the current l2 node from l2 linked-list,
            // make sure the original l2 reference l2.next,
            // if don't do like that before next insert operation ,
            // your current l2 node's next reference will be changed to a wrong node what may be a l1's node or a null value
            // it will cause circle loop and no result will be return
            l2 = l2.next;
            while (currentL1 != null) {
                if (currentL2.val >= currentL1.val && (currentL1.next == null || currentL2.val <= currentL1.next.val)) {
                    insertAfterNode(currentL1, currentL2);
                    currentL1 = currentL1.next;
                    break;
                }
                currentL1 = currentL1.next;
            }
        }
        return l1;
    }

    /**
     * insert targetNode after sourceNode and return the original targetNode's next node
     * @param sourceNode
     * @param targetNode
     */
    ListNode insertAfterNode(ListNode sourceNode, ListNode targetNode) {
        ListNode nextCopy = sourceNode.next;
        ListNode targetNodeNextCopy = targetNode.next;
        sourceNode.next = targetNode;
        targetNode.next = nextCopy;
        return targetNodeNextCopy;
    }

    @Test
    public void testMergeList() {
        ListNode headOfFirstList = new ListNode(1);
        headOfFirstList.next = new ListNode(4);
        headOfFirstList.next.next = new ListNode(89);

        ListNode headOfSecondList = new ListNode(2);
        headOfSecondList.next = new ListNode(22);
        headOfSecondList.next.next = new ListNode(122);

        printList(mergeTwoLists(headOfFirstList, headOfSecondList));
    }

    private void printList(ListNode node) {
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }


}
