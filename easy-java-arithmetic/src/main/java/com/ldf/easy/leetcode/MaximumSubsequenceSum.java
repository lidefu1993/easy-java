package com.ldf.easy.leetcode;

/**
 * 最大子序和
 * @author lidefu
 * @date 2020年06月28日13:52
 **/
public class MaximumSubsequenceSum {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

     示例:

     输入: [-2,1,-3,4,-1,2,1,-5,4],
     输出: 6
     解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */

    public static void main(String[] args) {
        MaximumSubsequenceSum sum = new MaximumSubsequenceSum();
        System.out.println(sum.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * sum为当前连续数组的和，sum<0,继续相加只会得到一个更小的值,所以sum从当前值继续累加
     * @param nums -
     * @return 最大连续子数组的和
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = nums[0];
        for (int num : nums){
            if(sum > 0){
                sum += num;
            }else {
                sum = num;
            }
            res = Math.max(sum, res);
        }
        return res;
    }

}
