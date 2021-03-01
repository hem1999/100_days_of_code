class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int val = 0;
        for(int i =grid[0].length-1;i>=0;i--){
            val += grid[grid.length-1][i];
            dp[grid.length-1][i] = val;
        }
        val = 0;
        for(int i=grid.length-1;i>=0;i--){
            val+= grid[i][grid[0].length-1];
            dp[i][grid[0].length-1] = val;
        }
        for(int i=grid.length-2;i>=0;i--){
            for(int j=grid[0].length-2;j>=0;j--){
                dp[i][j] = grid[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}