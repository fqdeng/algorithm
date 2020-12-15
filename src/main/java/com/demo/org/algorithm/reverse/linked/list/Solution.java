package com.demo.org.algorithm.reverse.linked.list;

import com.demo.org.algorithm.common.model.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head.next;
        head.next = null;
        return head(head, temp);
    }

    private ListNode head(ListNode node, ListNode next) {
        if (next == null) {
            return node;
        }
        ListNode temp = next.next;
        next.next = node;
        return head(next, temp);
    }

    private String getListFromLinkedList(ListNode node) {
        List<Integer> results = new ArrayList<>();
        while (node != null) {
            results.add(node.val);
            node = node.next;
        }
        return results.toString().replaceAll(" ", "");
    }

    @Test
    public void testReverseList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Assert.assertEquals(
                "[1,2,3,4,5]",
                getListFromLinkedList(head));
        ListNode result = reverseList(head);
        Assert.assertEquals("[5,4,3,2,1]", getListFromLinkedList(result));
    }
}
