package com.ldf.easy.leetcode;

/**
 * 跳水板
 * @author lidefu
 * @date 2020年07月08日19:19
 **/
public class DivingBoard {

    /**
     * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。
     * 编写一个方法，生成跳水板所有可能的长度。

     返回的长度需要从小到大排列。

     示例：

     输入：
     shorter = 1
     longer = 2
     k = 3
     输出： {3,4,5,6}
     提示：

     0 < shorter <= longer
     0 <= k <= 100000

     */

    public static void main(String[] args) {
        DivingBoard board = new DivingBoard();
        int[] ints = board.divingBoard(1,2,3);
        for(int i : ints){
            System.out.println(i);
        }
    }

    /**
     * 把K分为两份（m+n=k） m*shorter+n*longer (m,n)的全部组合即为结果
     * @param shorter -
     * @param longer -
     * @param k -
     * @return -
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0){
            return new int[]{};
        }
        if(shorter==longer){
            return new int[]{k*shorter};
        }
        int[] r = new int[k+1];
        for(int i=0; i<=k; i++){
            r[i] = i*longer + shorter*(k-i);
        }
        return r;
    }

}
