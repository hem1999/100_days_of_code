class Solution {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        for(int i=nums.length-1;i>=0;--i){
            if(i==nums.length-1){
                dp[i] = nums[i];
            }else if(i==nums.length-2){
                dp[i] = Math.max(nums[i],nums[i+1]);
            }else{
                dp[i] = Math.max(nums[i]+dp[i+2],dp[i+1]);
            }
        }
        return dp[0];
    }
}