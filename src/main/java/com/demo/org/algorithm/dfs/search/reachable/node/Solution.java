package com.demo.org.algorithm.dfs.search.reachable.node;

import com.demo.org.algorithm.common.model.MultiSubNode;
import com.demo.org.algorithm.common.model.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {


    private List<MultiSubNode> gcRoots = new ArrayList<>();;

    private Set<MultiSubNode> allNodes = new HashSet<>();

    private Set<MultiSubNode> visitedNodes = new HashSet<>();

    public void printNotReferenceByRoot(){
        for (MultiSubNode gcRoot : gcRoots) {
            dfs(gcRoot);
        }
        for (MultiSubNode node : allNodes) {
            if (!visitedNodes.contains(node)) {
                System.out.println(node.value);
            }
        }
    }

    void dfs(MultiSubNode node){
        visitedNodes.add(node);
        if (node.subs == null || node.subs.isEmpty()){
            return;
        }
        for (MultiSubNode sub : node.subs) {
            dfs(sub);
        }
    }



    @Test
    public void testDfs(){
        //模拟场景 gcRoots 1 , 2 , 5
        //被其引用或间接的对象 分别有 3, 7 ,9
        MultiSubNode one = new MultiSubNode(1);
        MultiSubNode two = new MultiSubNode(2);
        MultiSubNode five = new MultiSubNode(5);

        MultiSubNode three = new MultiSubNode(3);
        MultiSubNode seven = new MultiSubNode(7);
        MultiSubNode nine = new MultiSubNode(9);

        //未被GCRoots引用的对象
        MultiSubNode ten = new MultiSubNode(10);

        gcRoots.addAll(Arrays.asList(one,two,five));
        allNodes.addAll(Arrays.asList(one,two,five,three,seven,nine,ten));

        //模拟引用
        //1 -> 3
        one.subs.add(three);

        //3 -> 7
        three.subs.add(seven);

        //7 -> 10
        seven.subs.add(ten);

        //2 -> 9
        two.subs.add(nine);

        //5 -> 3
        five.subs.add(three);

        printNotReferenceByRoot();
    }

}
