package com.demo.org.algorithm.common.model;

import lombok.Data;

@Data
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
