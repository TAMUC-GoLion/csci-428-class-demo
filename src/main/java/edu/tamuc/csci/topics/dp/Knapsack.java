package edu.tamuc.csci.topics.dp;

/**
 * Demo of knapsack problem
 *  ==> 0-1 Knapsack
 */

public class Knapsack {

    //https://www.lintcode.com/problem/backpack/description
    //Example solution (1):
    public int backPack(int m, int[] A) {
        if (m <= 0 || A == null || A.length < 1) return 0;

        //dp[i][j]: when select i items (i ~[0, A.length], can/can not reach j weight capacity (j ~[0, m])
        //dp[3][9] ==> select 3 items can I reach the size of 9? ==> yes
        boolean[][] dp = new boolean[A.length + 1][m + 1];

        //init
        dp[0][0] = true;

        //trans
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] || (j >= A[i - 1] && dp[i - 1][j - A[i - 1]]);
            }
        }

        //res
        for (int res = m; res >= 0; res--) {
            if (dp[A.length][res]) return res;
        }

        return 0;
    }

    // Rolling Array solution for the above, save space
    int backPackRA(int m, int[] A) {
        if (A == null || A.length < 1 || m <= 0) return 0;

        boolean[][] dp = new boolean[2][m + 1];//pick i items, can reach m capacity

        //init
        dp[0][0] = true;

        //trans
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j] //do not take the i-th (index = i - 1) item
                        || (j >= A[i - 1] && dp[(i - 1) % 2][j - A[i - 1]]); //take the ith (index = i - 1) item; 这就是比用int[][]作为dp快的原因，因为字节运算符效率高于算数运算符！
            }
        }


        //res
        for (int res = m; res >= 0; res--) {
            if (dp[A.length % 2][res]) return res;
        }

        return 0;
    }

    //https://www.lintcode.com/problem/backpack-ii/description
    //Note the only difference is change of the transform function
    public int backPackII(int m, int[] A, int[] V) {
        if(m <= 0 || V == null || V.length < 1 || A == null || A.length < 1) return 0;

        int[][] dp = new int[2][m + 1];//max value of have i items within capacity m

        //init (void)

        //trans
        for(int i = 1; i <= A.length; i++) {
            for(int j = 0; j <= m; j++) {
                dp[i % 2][j] = j >= A[i - 1] ?  Math.max(dp[(i - 1) % 2][j], dp[(i - 1) % 2][j - A[i - 1]] + V[i - 1]) : dp[(i - 1) % 2][j];
            }
        }

        //res
        int maxV = 0;
        for(int value : dp[A.length % 2]) {
            maxV = Math.max(maxV, value);
        }

        return maxV;
    }

}
