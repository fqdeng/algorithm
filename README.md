# Java常见面试算法考试大全


## 面试算法的心得体会

* 最近面了b站，美团(已经准备2刷其它部门)，拼多多,阿里, 深感国内受硅谷大厂之风所害，
纷纷搞起了算法面试题，在这里 我觉得有责任普及一点我的算法面试心得，以及我做题的经验，
先声明我自己也是一个菜鸡，我个人的算法能力局限于 二分查找 快速排序 图搜索 生成树 skip-list 等简易中等难度的范畴，
仅能应付常规面试题。

## 为应付算法面试而应该达到的目标

* 在面试3-5年的Java开发岗位，算法面试可能大多着重于对基础数据结构 
ArrayList LinkedList Stack Queue Map 的应用跟原理的掌握，这个我不推荐大家去读JDK的源代码，
里面具体的实现 其实涉及到生产实践中大量的改进，细节十分多，例如JDK8的HashMap 在达到8个hash冲突链表后会转成红黑树，
而在理论学习的阶段中，应该了解除 头接链表法解决hash冲突 其它解决hash冲突的方式，
这里我推荐大家阅读 <<算法>> 第四版，里面有对基础的数据结构算法有详细的介绍，
这本书着重于应用跟理解，不像算法导论大篇幅的描述算法的数学证明。
从工程师的角度来讲，工程师在掌握算法的原理以及实现的思想后，能够熟练运用这些工具解决问题即可，
至于在数学的基础上对算法做出正确性的推导，我觉得并不是一个工程师应该所必须掌握的能力。

* 一些题目其实是有一固定解题套路的，例如在你掌握一个深度搜索 广度搜索的模板之后，
可以通过这个模板来解决大量图相关的问题，当然可能在这上面可能又涉及到减枝 用HashMap去重等操作。

* 很多算法都是从朴素算法出发演化来的，例如KMP求子字符串，同样时间复杂度的RK求字符串，也都是根据朴素的双重循环比对
字符串是否相等演化而来，在学习任何算法前，可以先了解其相关朴素算法的实现，可以加深对算法数据结构的认识

* 手写代码跟白板代码，一定要着重于可理解性，一个著名的观点是代码是写给人看的，顺便让机器执行一下，在算法面试中，如果
面试官对 空间复杂度 时间复杂度没有特殊要求，应该尽量选最好解释且最容易实现的方式去写，如果你写的代码不能通过简单的test case证明其正确性，
那么面试可能会大打折扣，其实短短几十分钟的时间，很难让你写出一个炫技的实现。

* 无论任何时候先处理dirty-case，就是防御式编程，不相信任何人提交参数的正确性，这种编程思维会让你受益终身。

* 推导完各种情况之后再写代码，在很多链表或者需要进行count++的题目里面，我以前一个通常习惯是先写一段验证一下，然后debug修改 这是不好的习惯

* 写一个问题规模比较小的test-case验证思路

* 待补充

## 基本常识跟技巧

* 了解基本的算法复杂度分析，了解O(N) O(N^2) O(LogN) 等复杂度
* 递归不好写，容易写错， 必须要掌握写对递归的三要素
* 二分搜索有模板，可以背下来，如果不确定，可以把目标值跟 mid low指针上的元素都比较一下
* 待补充


## 常见的套路模板

* 二分查找模板
```java
public class BinarySearch { //二分查找模板
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target){ 
                return mid;
            }
            // 如果你面试记不住 可以顺便比较一下 if nums[low] == target
            else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
//
//循环条件： left <= right
//中间位置计算： mid = left + ((right -left) >> 1)
//左边界更新：left = mid + 1
//右边界更新： right = mid - 1
//返回值： mid / -1
```

* bfs广度搜索优先模板

```java
    
public class Solution {

    class TreeNode {
        public int val;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode left;

        public TreeNode right;
    }

    //           0               <- 第一次从队列里面取到0  然后把子节点1放回去
    //         /   \
    //        1     null         <- 第二次从队列里面取到1 然后把子节点 3 4 放回去
    //      /  \
    //     3   4                 <- 第三次从队列里面取到3，4 因为其没有子节点 所以队列为空 返回 得到count = 3
    //   null -> layer   
    // 这里其实思路很简单，因为bfs是层序遍历，每次针对队列的循环，都是取得同层级别的节点，除开二叉树 多叉树亦是如此


    //求二叉树的最大层数 算是bfs模板题
    public int calculateBinaryTreeLayer(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //不管怎么样通常bfs是要进队的
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int count = 0;

        while (!queue.isEmpty()) {
            List<TreeNode> polls = new ArrayList<>();
            //这个是取出当前这一层所有的左右节点 实际上针对多叉树 其思想也是一样
            while (!queue.isEmpty()) {
                polls.add(queue.poll());
            }
            
            //把所有节点的子节点再塞回去
            polls.forEach(poll -> {
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
            });
            
            //计数+1
            count++;
        }
        return count;
    }

    /**
     * not full binary tree
     */
    @Test
    public void testCalculateBinaryTreeTestCase2() {
        
        TreeNode top = new TreeNode(0);
        top.left = new TreeNode(1);
        top.right = new TreeNode(2);
        top.left.left = new TreeNode(3);
        top.left.right = new TreeNode(4);
        Assert.assertEquals(3, calculateBinaryTreeLayer(top));
    }

    /**
     * full binary tree
     */
    @Test
    public void testCalculateBinaryTreeTestCase1() {
        //           0
        //         /   \
        //        1     2
        //      /  \   /  \
        //     3   4   5   6
        //   null -> layer

        TreeNode top = new TreeNode(0);
        top.left = new TreeNode(1);
        top.right = new TreeNode(2);
        top.left.left = new TreeNode(3);
        top.left.right = new TreeNode(4);
        top.right.left = new TreeNode(5);
        top.right.right = new TreeNode(6);
        Assert.assertEquals(3, calculateBinaryTreeLayer(top));
    }
}

```

## 待续...


