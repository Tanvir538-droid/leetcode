class Solution {
    public boolean canPartition(int[] nums) {
        int N = nums.length;
       int S = 0;
       for(int i=0;i<N;i++){
        S +=nums[i];
       } 
       int sum = S;
       if(sum%2!=0){
        return false;
       }
       S = S/2;
        int[][] dp = new int[N+1][S+1];
        for(int i=0;i<N+1;i++){
            for(int j=0;j<S+1;j++){
                if (i==0||j==0) {
                    dp[i][j] = 0;
                }else{
                    if (nums[i-1]>j) {
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i-1]]+nums[i-1]);
                    }
                }
            }
        }
        if (2*dp[N][S]==sum) {
            return true;
        }
        return false;
    }
}