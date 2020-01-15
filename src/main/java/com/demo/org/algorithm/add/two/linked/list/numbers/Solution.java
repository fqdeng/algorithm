package com.demo.org.algorithm.add.two.linked.list.numbers;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @link https://leetcode-cn.com/problems/add-two-numbers-ii/submissions/
 */
public class Solution {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
    //
    //你可以假设除了数字 0 之外，这两个数字都不会以零开头。
    //
    //进阶:
    //
    //如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
    //
    //示例:
    //
    //输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    //输出: 7 -> 8 -> 0 -> 7


    // 整体的思路 还是将链表转成栈 然后从个位开始进行 加法进位运算 空间复杂度为 O(N) 时间复杂度 O(N)
    // 有人可以做到空间复杂度 O(1) 但是面试的时候的没有必要这么做 除非特殊要求空间复杂度


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 第一步 把两个链表分别转换成Stack  1-> 2 -> 3 的链表 ,转换成stack 出栈的顺序就回变成  3 -> 2 -> 1
        // 从可读性的角度来讲 人脑习惯从个位数开始计算
        // 这样写出的代码不容易出错 容易理解 也是大部分人接受的小学加法方式

        Stack<Integer> l1Stack = nodeConvertStack(l1);
        Stack<Integer> l2Stack = nodeConvertStack(l2);

        //这个时候判断两个栈的大小 默认左边的入参
        if (l1Stack.size() > l2Stack.size()) {
            return getListNode(l1Stack, l2Stack);
        } else {
            return getListNode(l2Stack, l1Stack);
        }
    }

    private ListNode getListNode(Stack<Integer> l1Stack, Stack<Integer> l2Stack) {
        ListNode result = null;
        boolean needDecade = false;

        //以栈最大的那个容器做迭代截止条件
        while (!l1Stack.isEmpty()) {
            //活得第一个栈的个位数 百位数 依次..
            Integer val = l1Stack.pop();

            //活得第二个栈的个位数 百位数 依次..
            if (!l2Stack.isEmpty()) {
                //相加
                val += l2Stack.pop();
            }
            if (needDecade) {
                //需要进位
                val += 1;
                //进位完之后处理为false
                needDecade = false;
            }

            if (val >= 10) {
                //检查下次运算是否需要进位
                val = val - 10;
                //进位标志
                needDecade = true;
            }

            //组装链表
            ListNode temp = result;
            result = new ListNode(val);
            result.next = temp;

            //如果较长的栈已经为空  但是又存在剩余的进位
            //这个时候应该生成一个单独的 1链表 作为链表的头
            // 这种情况一般是针对  链表一:  5 -> 5 链表二:  4 -> 5 这种生成的链表比原链表都要长的特殊情况 新生成的链表应该为 1 -> 0 -> 0 (长度为3)
            if (l1Stack.isEmpty() && needDecade) {
                temp = result;
                result = new ListNode(1);
                result.next = temp;
            }
        }
        return result;
    }

    //链表转成栈
    private Stack<Integer> nodeConvertStack(ListNode node) {
        Stack<Integer> result = new Stack<>();
        while (node != null) {
            result.push(node.val);
            node = node.next;
        }
        return result;
    }
}
