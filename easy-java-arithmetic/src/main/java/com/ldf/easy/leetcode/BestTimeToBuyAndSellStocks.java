package com.ldf.easy.leetcode;

/**
 * 最佳买卖股票时机含冷冻期
 * @author lidefu
 * @date 2020年07月10日17:34
 **/
public class BestTimeToBuyAndSellStocks {

    /**
     *
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

     设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

     你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     示例:

     输入: [1,2,3,0, 2]
     输出: 3
     解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

     *
     */

    public static void main(String[] args) {
        BestTimeToBuyAndSellStocks sellStocks = new BestTimeToBuyAndSellStocks();
        System.out.println(sellStocks.maxProfit(new int[]{1,2,3,0, 2}));
    }

    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int r = 0;
        //true 买入
        boolean b = true;
        for(int i=0; i<prices.length; i++){
            if(b){
                r-=prices[i];
            }else {
                r+=prices[i];
                i+=1;
            }
            b=!b ;
        }
        return r;
    }

}