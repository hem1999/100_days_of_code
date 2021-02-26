class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][n-1] = 1;
        }
        for(int j=0;j<n;j++){
            dp[m-1][j] = 1;
        }
        for(int k=m-2;k>=0;--k){
            for(int l = n-2;l>=0;--l ){
                dp[k][l] = dp[k+1][l]+dp[k][l+1];
            }
        }
        return dp[0][0];
    }
}