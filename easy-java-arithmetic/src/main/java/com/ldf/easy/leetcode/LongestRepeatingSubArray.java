package com.ldf.easy.leetcode;

/**
 * 最长重复子数组
 * @author lidefu
 * @date 2020年07月01日13:49
 **/
public class LongestRepeatingSubArray {

    /**
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

     示例 1:

     输入:
     A: [1,2,3,2,1]
     B: [3,2,1,4,7]
     输出: 3
     解释:
     长度最长的公共子数组是 [3, 2, 1]。
     说明:

     1 <= len(A), len(B) <= 1000
     0 <= A[i], B[i] < 100

     */

    public static void main(String[] args) {
        LongestRepeatingSubArray subArray = new LongestRepeatingSubArray();
        System.out.println(subArray.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }

    public int findLength(int[] A, int[] B) {
        return 0;
    }

}
