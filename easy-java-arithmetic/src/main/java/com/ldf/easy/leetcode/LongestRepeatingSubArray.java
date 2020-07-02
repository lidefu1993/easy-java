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
        System.out.println(subArray.findLength2(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }

    /**
     * 暴力法
     *  对A数组得每个元素，查找B数据相等得元素后，取连续相等得长度
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int max = 0;
        for (int i=0; i<A.length; i++){
            for (int j=0; j<B.length; j++){
                int k=0; //连续相等的长度
                while (i+k<A.length && j+k<B.length && A[i+k] == B[j+k] ){
                    k++;
                }
                max = Math.max(k, max);
            }
        }
        return max;
    }

    /**
     * 定义一个二位数组 al[][]记录i，j位置的最长字串长度
     * 从A,B的末端开始遍历， 若a[i]=[j],那么a[i][j] = a[i+1][j+1]+1 否则 a[i][j]=0
     * @param A
     * @param B
     * @return
     */
    public int findLength2(int[] A, int[] B) {
        int max = 0;
        int[][] al = new int[A.length+1][B.length+1];
        al[A.length][B.length]=0;
        for(int i=A.length-1; i>=0; i--){
            for(int j=B.length-1; j>=0; j--){
                al[i][j] = A[i] == B[j] ? al[i+1][j+1]+1 : 0;
                max = Math.max(al[i][j], max);
            }
        }
        return max;
    }

}
