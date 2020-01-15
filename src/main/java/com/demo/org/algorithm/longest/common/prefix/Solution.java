package com.demo.org.algorithm.longest.common.prefix;

import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @link https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Solution {

    //迭代法

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        //先默认第一个为最长公共前缀
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String target = strs[i];
            //迭代后续的每一个字符串 作为target对象 与当前的result进行比对

            while (target.indexOf(result) != 0) {
                //不断循环找到当前result跟target的最长前缀 作为新的result结果
                result = result.substring(0, result.length() - 1);
                // 如果当中result已经为空的话 就不存在最长前缀
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
