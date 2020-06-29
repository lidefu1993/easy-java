package com.ldf.easy.leetcode;

import java.util.Arrays;

/**
 * 数组中的第K个最大元素
 * @author lidefu
 * @date 2020年06月29日13:43
 **/
public class KthLargestElementInArray {

    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

     示例 1:

     输入: [3,2,1,5,6,4] 和 k = 2
     输出: 5
     示例 2:

     输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     输出: 4
     说明:

     你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     */

    public static void main(String[] args) {
        KthLargestElementInArray elementInArray = new KthLargestElementInArray();
        System.out.println(elementInArray.findKthLargest1(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(elementInArray.findKthLargest1(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    /**
     * 排序后取第K-1位
     * @param nums -
     * @param k -
     * @return -
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    /**
     * 维护一个长度为K的数组temp 第一位始终为temp中最小的数字
     * @param nums -
     * @param k -
     * @return -
     */
    public int findKthLargest1(int[] nums, int k) {
        int[] temp = new int[k];
        temp[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            if(i<k){
                //临时数组没满
                if(temp[0] < nums[i]){
                    temp[i]=nums[i];
                }else {
                    //保证temp[0]始终为最小值
                    int tt=temp[0];
                    temp[0]=nums[i];
                    temp[i]=tt;
                }
            }else {
                //临时数组已满
                if(temp[0] < nums[i]){
                    temp[0] = nums[i];
                    //reset temp 保证temp[0]始终为temp中的最小值
                    for(int j=1; j<k; j++){
                        if(temp[0]>temp[j]){
                            //交换
                            int ttt = temp[0];
                            temp[0] = temp[j];
                            temp[j] = ttt;
                        }
                    }
                }
            }
        }
        return temp[0];
    }

}
