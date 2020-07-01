package com.ldf.easy;

import com.ldf.easy.leetcode.CQueue;
import com.ldf.easy.leetcode.KthLargestElementInArray;
import com.ldf.easy.leetcode.LongestRepeatingSubArray;
import com.ldf.easy.leetcode.MaximumSubsequenceSum;

/**
 * @author lidefu
 * @date 2020年06月28日13:47
 **/
public enum ArithmeticIndex {

    /**
     *
     */

    最大子序和(MaximumSubsequenceSum.class),
    数组中的第K个最大元素(KthLargestElementInArray.class),
    用两个栈实现队列(CQueue.class),
    最长重复子数组(LongestRepeatingSubArray.class),

    ;

    private Class<?> c;

    ArithmeticIndex(Class c){
        this.c = c;
    }

}
