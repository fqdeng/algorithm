package com.demo.org.algorithm.kth.node.from.end.of.list.lcci;

import com.demo.org.algorithm.common.model.ListNode;
import com.demo.org.algorithm.common.util.ListNodeGenerate;
import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = null;

        while (head != null) {
            k--;
            head = head.next;
            if (k < 0) {
                slow = slow.next;
                if (head == null) {
                    return slow.val;
                }
            }

        }
        return slow.val;
    }


    @Test
    public void test() {
        Assert.assertEquals(4,
                kthToLast(ListNodeGenerate.generate("[1,2,3,4,5]"), 2));
    }

}
