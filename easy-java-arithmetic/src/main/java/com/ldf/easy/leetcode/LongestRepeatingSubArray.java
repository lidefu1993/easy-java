package com.ldf.easy.leetcode;

/**
 * 最长重复子数组
 * @author lidefu
 * @date 2020年07月01日13:49
 **/
public class LongestRepeatingSubArray {

    /**
     * 暴力法：比较全部的子串
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int max = 0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                int k=0;
                while (i+k<A.length && j+k<B.length && A[i+k]==B[j+k]){
                    k++;
                }
                max = Math.max(k, max);
            }
        }
        return max;
    }

    /**
     * 定义二维数组at[][]记录i，j对应坐标的最长子串 则从后往前遍历，若当前A[i]=A[j],at[i][j]=at[i+1][j+1]+1
     * @param A
     * @param B
     * @return
     */
    public int findLength2(int[] A, int[] B){
        int max = 0;
        int[][] at=new int[A.length+1][B.length+1];
        at[A.length][B.length]=0;
        for(int i=A.length-1; i>=0; i--){
            for(int j=B.length-1; j>=0; j--){
                at[i][j] = A[i]==B[j] ? at[i+1][j+1]+1 : 0;
                max = Math.max(at[i][j], max);
            }
        }
        return max;
    }

    public int findLength3(int[] A, int[] B){
        int max = 0, m=A.length, n=B.length;
        for(int i=0; i<m; i++){
            int len = Math.min(m-i, n);
            int max1 = findMax(A, B, i, 0, len);
            max = Math.max(max, max1);
        }
        for(int j=1; j<n; j++){
            int len = Math.min(n-j, m);
            int max1 = findMax(A, B, 0, j, len);
            max = Math.max(max, max1);
        }
        return max;
    }

    public int findMax(int[] A, int[] B, int addA, int addB, int len){
        int k=0, max=0;
        for(int i=0; i<len; i++){
            if(A[i+addA] == B[i+addB]){
                k++;
            }else {
                k=0;
            }
            max = Math.max(k, max);
        }
        return max;
    }

    public int findLength4(int[] A, int[] B){
        int max = 0;
        int[][] at=new int[A.length][B.length];
        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                if(i==0 || j==0){
                    at[i][j] = A[i]==B[j] ? 1 : 0;
                }else {
                    at[i][j] = A[i]==B[j] ? at[i-1][j-1]+1 : 0;
                }
                max = Math.max(at[i][j], max);
            }
        }
        return max;
    }

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
        System.out.println(subArray.findLength4(new int[]{0,0,0,0,1}, new int[]{1,0,0,0,0}));
    }



}
