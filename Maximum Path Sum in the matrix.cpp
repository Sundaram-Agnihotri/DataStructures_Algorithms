#include <bits/stdc++.h> 

int tab(int n, int m, const vector<vector<int>>& matrix, vector<vector<int>>& dp){
    for (int i=0; i<n; i++){
        for (int j=0; j<m; j++){
            int leftd=-1e9, rightd=-1e9;
            if (i==0) dp[i][j] = matrix[i][j];
            else{
                int up=dp[i-1][j] + matrix[i][j];
                if (j>0)leftd=dp[i-1][j-1] + matrix[i][j];
                if (j<m-1) rightd=dp[i-1][j+1] + matrix[i][j];
                dp[i][j] = max(up, max(rightd, leftd));
            }
        }
    }int maxi=INT_MIN;
    for (int j=0; j<m; j++){
        maxi=max(maxi, dp[n-1][j]);
    }
    return maxi;
}


int getMaxPathSum(vector<vector<int>> &matrix)
{
    //  Write your code here.
    int n = matrix.size();
    int m = matrix[0].size();
    vector<vector<int>> dp(n, vector<int>(m, -1));
    return tab(n, m, matrix, dp);
}
