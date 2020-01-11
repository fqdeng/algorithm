package com.demo.org.algorithm.longest.common.prefix;

import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String target = strs[i];
            while (target.indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if (result.isEmpty()) {
                    return "";
                }
            }
        }
        return result;

    }


    @Test
    public void testLongestCommonPrefix() {
        Assert.assertEquals(longestCommonPrefix(new String[]{"ab", "abc", "abdc", "a"}), "a");
        Assert.assertEquals(longestCommonPrefix(new String[]{"ab", "abc", "abdc", "dfd"}), "");
    }

}
