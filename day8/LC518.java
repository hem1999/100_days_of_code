class Solution {
    public int change(int amount, int[] coins) {
        if(amount==0){
            return 1;
        }
        if(coins.length==1){
            if(amount%coins[0]==0){
                return 1;
            }else{
                return 0;
            }
        }
        
        int[][] dp = new int[coins.length+1][amount+1];
        int m = coins.length+1;
        int n = amount+1;
        for(int i=0;i<=m-1;i++){
            dp[i][0] = 1;
        }
        for(int j=0;j<=n-1;j++){
            dp[0][j] = 0;
        }
        
        for(int i=1;i<=m-1;i++){
            for(int j=1;j<=n-1;j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m-1][n-1];
    }
}   