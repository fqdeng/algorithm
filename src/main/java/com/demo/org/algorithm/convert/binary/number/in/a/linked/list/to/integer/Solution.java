package com.demo.org.algorithm.convert.binary.number.in.a.linked.list.to.integer;

import com.demo.org.algorithm.common.model.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int getDecimalValue(ListNode head) {
        int current = 0;
        while (head != null) {
            if (head.next != null) {
                current = (head.val+current) * 2;
            } else {
                //处理二进制最后一位 无需*2
                current += head.val;
            }
            head = head.next;
        }
        return current;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(0);
        ListNode next2 = new ListNode(1);
        head.next = next;
        next.next = next2;
        Assert.assertEquals(5, getDecimalValue(head));
    }
}
