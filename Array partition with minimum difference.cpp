int minSubsetSumDifference(vector<int>& arr, int n)
{
	int totalSum = 0;
	for(int i = 0 ; i<n ; i++){
		totalSum += arr[i];
	}

	vector<vector<bool>> dp(n,vector<bool>(totalSum+1,0));

	for(int i = 0 ; i<n ; i++){
		dp[i][0] = true;
	}

	if(arr[0] <= totalSum) dp[0][arr[0]] = true;

	for(int i = 1 ; i < n; i++){
		for(int j = 1 ; j<totalSum+1 ; j++){
			bool notTake = dp[i-1][j];
			bool take = false;
			if(arr[i] <= j){
				take = dp[i-1][j-arr[i]];
			}

			dp[i][j] = take || notTake;
		}
	}

	int mini = 1e9;

	for(int i = 0  ; i<totalSum/2 + 1 ; i++){
		if(dp[n-1][i] == true){
			int s2 = totalSum - i;
			mini = min(mini,abs(s2-i));
		}
	}

	return mini;
}
