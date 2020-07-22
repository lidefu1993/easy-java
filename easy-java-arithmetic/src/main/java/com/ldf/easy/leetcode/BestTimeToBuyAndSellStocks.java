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

    /**
     * 动态规划
     *

     我们目前持有一支股票，对应的「累计最大收益」记为 f[i][0]；
     我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 f[i][1]；
     我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 f[i][2]。

     * @param prices -
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        for(int i=1; i<prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0]+prices[i];
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
        }
        int n = prices.length-1;
        int max = Math.max(dp[n][0], dp[n][1]);
        return Math.max(max, dp[n][2]);
    }

}
