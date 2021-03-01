class Solution {
    public int maxProfit(int[] prices) {
         int n = prices.length;
        if(n==0 || n==1){
            return 0;
        }

        int[] left = new int[n];
        int lowest = prices[0];
        left[0]=0;
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1],prices[i]-lowest);
            lowest = Math.min(lowest,prices[i]);
        }

        int[] right = new int[n];
        int highest = prices[n-1];
        right[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1],highest-prices[i]);
            highest = Math.max(highest,prices[i]);
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,left[i]+right[i]);
        }
        return ans;
    
    }
}