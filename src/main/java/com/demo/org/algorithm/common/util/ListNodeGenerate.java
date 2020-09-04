package com.demo.org.algorithm.common.util;

import com.demo.org.algorithm.common.model.ListNode;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ListNodeGenerate {

    public static ListNode generate(String json) {
        Type type = new TypeToken<List<Integer>>() {
        }.getType();
        List<Integer> vars = Json.gson.fromJson("[1,2,3,4,5]", type);
        ListNode head = new ListNode(vars.get(0));
        ListNode result = head;
        for (int i = 1; i < vars.size(); i++) {
            ListNode next = new ListNode(vars.get(i));
            head.next = next;
            head = head.next;
        }
        return result;
    }
}
