package com.ldf.easy.leetcode;

/**
 * 不同路径 II
 * @author ldf
 * @date 2020/7/6 21:26
 **/
public class DifferentPathTwo {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

     机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角

     网格中的障碍物和空位置分别用 1 和 0 来表示。

     说明：m 和 n 的值均不超过 100。

     示例 1:

     输入:
     [
       [0,0,0],
       [0,1,0],
       [0,0,0]
     ]
     输出: 2
     解释:
     3x3 网格的正中间有一个障碍物。
     从左上角到右下角一共有 2 条不同的路径：
     1. 向右 -> 向右 -> 向下 -> 向下
     2. 向下 -> 向下 -> 向右 -> 向右

     */

    public static void main(String[] args) {
        DifferentPathTwo two = new DifferentPathTwo();
        int[][] ints = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(ints[1][1]);
        System.out.println(ints[0]);
        int obstacles = two.uniquePathsWithObstacles1(ints);
        System.out.println(obstacles);
    }

    /**
     * 官方题解：没看懂 ！！！
     * @param obstacleGrid ！！
     * @return ！！
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
                System.out.println(f);
            }
        }

        return f[m - 1];
    }

    /**
     * 定义f[i][j]记录到改点的路径数，则到f[i][j] = f[i-1][j]+f[i][j-1]
     * @param obstacleGrid -
     * @return
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        //初始化第一行和第一列 当前位置==0 ？ 步数=1 ： 步数=0
        for(int i=0; i<m && obstacleGrid[i][0]==0; i++){
            f[i][0]=1;
        }
        for(int j=0; j<n && obstacleGrid[0][j]==0; j++){
            f[0][j]=1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j] == 0){
                    f[i][j] = f[i][j-1] + f[i-1][j];
                }
            }
        }
        return f[m-1][n-1];
    }

}
