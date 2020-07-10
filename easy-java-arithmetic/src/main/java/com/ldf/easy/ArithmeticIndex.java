package com.ldf.easy;

import com.ldf.easy.leetcode.*;

/**
 * @author lidefu
 * @date 2020年06月28日13:47
 **/
public enum ArithmeticIndex {

    /**
     * Y 比较容易 N 需要反复笑话
     *
     * 动态规划！！！！！
     *
     */


    最大子序和(MaximumSubsequenceSum.class, 'N'),
    数组中的第K个最大元素(KthLargestElementInArray.class, 'Y'),
    用两个栈实现队列(CQueue.class, 'Y'),
    最长重复子数组(LongestRepeatingSubArray.class, 'N'),
    不同路径2(DifferentPathTwo.class, 'N'),
    跳水板(DivingBoard.class, 'Y'),
    恢复空格(RestoreSpace.class, 'N'),
    最佳买卖股票时机含冷冻期(BestTimeToBuyAndSellStocks.class, 'N'),

    ;

    private Class<?> c;
    private Character t;

    ArithmeticIndex(Class c, Character t){
        this.c = c;
        this.t = t;
    }

}
