package com.ldf.easy.leetcode;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * @author lidefu
 * @date 2020年06月30日13:49
 **/
public class CQueue {

    /**
     *
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
       分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

     示例 1：

     输入：
     ["CQueue","appendTail","deleteHead","deleteHead"]
     [[],[3],[],[]]
     输出：[null,null,3,-1]
     示例 2：

     输入：
     ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
     [[],[],[5],[2],[],[]]
     输出：[null,-1,null,null,5,2]
     提示：

     1 <= values <= 10000
     最多会对 appendTail、deleteHead 进行 10000 次调用
     *
     */

    /**
     * 首先理清栈跟队列的特征  栈：先进后出  队列：先进先出
     * 思路： 定义两个栈（stack_in,stack_out），
     *   添加的数据全入stack_in， 出的时候想要删除最先入栈的，把当前栈的数据腾到stack_out中，那么在stack_out中的顺序即为先进入的在栈顶，
     *   每次删stack_out的栈顶，每当stack_out为空，再将stack_in的数据腾到stack_out中
     */

    private Stack<Integer> stack_in = new Stack<>();
    private Stack<Integer> stack_out = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack_in.add(value);
    }

    public int deleteHead() {
        if(!stack_out.empty()){
            return stack_out.pop();
        }
        if(!stack_in.empty()){
            while (!stack_in.isEmpty()){
                Integer pop = stack_in.pop();
                stack_out.add(pop);
            }
            return stack_out.pop();
        }
        return -1;
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
    }


}
