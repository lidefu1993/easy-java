package com.ldf.easy;

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

    ;

    private Class<?> c;

    ArithmeticIndex(Class c){
        this.c = c;
    }

}
