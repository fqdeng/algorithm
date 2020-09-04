package com.demo.org.algorithm.zuo.xuan.zhuan.zi.fu.chuan.lcof;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public String reverseLeftWords(String s, int n) {
        String tail = s.substring(0, n);
        String head = s.substring(n  );
        return head + tail;
    }

    @Test
    public void test() {
        Assert.assertEquals("cdab", reverseLeftWords("abcd", 2));
    }
}
