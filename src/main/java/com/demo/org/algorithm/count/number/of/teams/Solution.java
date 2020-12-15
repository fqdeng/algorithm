package com.demo.org.algorithm.count.number.of.teams;

public class Solution {
    /**
     * @param rating
     * @return
     * @link https://leetcode-cn.com/problems/count-number-of-teams/
     */
    public int numTeams(int[] rating) {
        int first = 0;
        int second = 0;
        int third = 0;
        int count = 0;
        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    first = rating[i];
                    second = rating[j];
                    third = rating[k];
                    if (first > second && second > third) {
                        count++;
                    }
                    if (first < second && second < third) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
