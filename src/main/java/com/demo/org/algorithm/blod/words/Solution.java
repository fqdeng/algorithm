package com.demo.org.algorithm.blod.words;

import org.junit.Assert;
import org.junit.Test;


/**
 * @link https://leetcode-cn.com/problems/bold-words-in-string/
 */
public class Solution {
    public String boldWords(String[] words, String S) {
        //1检查
        String word = "";
        int repeat[] = new int[S.length()];
        int flag = 0;
        for (int k = 0; k < words.length; k++) {
            word = words[k];
            for (int i = 0; i < S.length() - word.length() + 1; i++) {
                if (S.charAt(i) == word.charAt(0)) {
                    for (int j = 0; j < word.length(); j++) {
                        if (S.charAt(i + j) == word.charAt(j)) {
                            flag++;
                        } else {
                            flag = 0;
                            break;
                        }
                    }
                }
                if (flag == word.length()) {
                    for (int j = i, l = 0; l < word.length(); j++, l++) {
                        repeat[j] = 1;
                    }
                    flag = 0;
                }
            }
        }

        //2插入
        StringBuilder stringBuilder = new StringBuilder(S);
        boolean isNotFirst = false;
        CharSequence charSequence = "<b></b>";
        int len = S.length();
        for (int i = 0, j = 0; i < len; i++, j++) {
            if (repeat[j] == 1 && isNotFirst == false) {
                if (i != len - 1) {
                    stringBuilder.insert(i, charSequence, 0, 3);
                    i += 3;
                    len += 3;
                    isNotFirst = true;
                } else {
                    stringBuilder.insert(i, charSequence, 0, 3);
                    stringBuilder.insert(i + 4, charSequence, 3, 7);
                }
            } else if (repeat[j] == 0 && isNotFirst == true) {
                stringBuilder.insert(i, charSequence, 3, 7);
                i += 4;
                len += 4;
                isNotFirst = false;
            } else if (i == len - 1 && isNotFirst == true) {
                stringBuilder.insert(i + 1, charSequence, 3, 7);
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void testCase() {
        Assert.assertEquals("<b>ad</b>c<b>ad</b>d<b>ece</b>d", boldWords(new String[]{"e", "ad", "ce", "a", "b"}, "adcaddeced"));
        Assert.assertEquals("<b>c</b>e<b>bc</b>e<b>cc</b>e<b>ab</b>", boldWords(new String[]{"b", "dee", "a", "ee", "c"}, "cebcecceab"));
        Assert.assertEquals("a<b>abc</b>d", boldWords(new String[]{"ab", "bc"}, "aabcd"));
    }
}
