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

    /**
     * 迭代法的思想是: 先找到次优解 然后再不断找到最优解
     * 例如公共子串 必然是任意字符串的子串 不断的减少子串长度 就能找到最优解
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        //使用最短的字符串作为最长的公共前缀
        String result = strs[0];
        for (String str : strs) {
            if (str.length() < result.length()) {
                result = str;
            }
        }
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
