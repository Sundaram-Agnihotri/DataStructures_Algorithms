import java.util.* ;

import java.io.*; 

 

public class Solution{

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        //RECURSION

        //return findMax(weight, value, n-1, maxWeight);

        

        //DP- MEMOIZATION

        // int[][] dp = new int[n][maxWeight+1];

        // for(int i=0; i<n; i++){

        //     Arrays.fill(dp[i],-1);

        // }

        // return findMem(weight, value, n-1, maxWeight, dp);

 

        //DP- TABULATION

        //return findTab(weight, value, n, maxWeight);

 

        //DP- Space Optimized

        //return findOpt(weight, value, n, maxWeight);

        

        //DP- Most Space Optimized

        return findMostOpt(weight, value, n, maxWeight);

    }

    public static int findMostOpt(int[] weight, int[] value, int n, int capacity){

        int[] curr = new int[capacity+1];

        for(int i=0; i<n; i++){

            for(int j=capacity; j>=0; j--){

                int inc =0;

                int exc =0;

                if(j-weight[i]>=0)

                inc = value[i] + curr[j-weight[i]];

                exc = curr[j];

                curr[j] = Math.max(inc, exc);

            }

        }

        return curr[capacity];

 

    }

    public static int findOpt(int[] weight, int[] value, int n, int capacity){

        int[] prev = new int[capacity+1];

        for(int i=0; i<n; i++){

            int[] curr = new int[capacity+1];

            for(int j=0; j<=capacity; j++){

                int inc =0;

                int exc =0;

                if(j-weight[i]>=0)

                inc = value[i] + prev[j-weight[i]];

                exc = prev[j];

                curr[j] = Math.max(inc, exc);

            }

            prev = curr;

        }

        return prev[capacity];

    }

    public static int findTab(int[] weight, int[] value, int n, int capacity){

        int[][] dp = new int[n][capacity+1];

 

        for(int i=0; i<=capacity; i++){

            if(weight[0]<=i)

            dp[0][i] = value[0];

            else

            dp[0][i] = 0;

        }

        int index = n;  

        for(int i=1; i<n; i++){

            for(int j=0; j<=capacity; j++){

                int inc = 0;

                int exc = 0;

                if((j-weight[i])>=0)

                inc =value[i] + dp[i-1][j - weight[i]];

                exc = dp[i-1][j];

                dp[i][j] = Math.max(inc, exc);

            }

        }

        return dp[n-1][capacity];

    }

    public static int findMem(int[] weight, int[] value, int index, int capacity, int[][] dp){

        if(index<0)

        return 0;

 

        if(dp[index][capacity]!=-1)

        return dp[index][capacity];

 

        int inc = 0;

        int exc = 0;

 

        if(capacity >= weight[index])

        inc = value[index] + findMem(weight, value, index-1, capacity-weight[index], dp);

        exc = findMem(weight, value, index-1, capacity, dp);

 

        return dp[index][capacity] = Math.max(inc, exc);

    }

    public static int findMax(int[] weight, int[] value, int index, int capacity){

        if(index<0)

        return 0;

 

        int inc = 0;

        int exc = 0;

        if(capacity>=weight[index])

        inc = value[index] + findMax(weight, value, index-1, capacity - weight[index]);

        exc = findMax(weight, value, index - 1, capacity);

        return Math.max(inc, exc);

    } 

}

