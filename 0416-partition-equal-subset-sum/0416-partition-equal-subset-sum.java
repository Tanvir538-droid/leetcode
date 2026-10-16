class Solution {
    public boolean canPartition(int[] nums) {
       int N = nums.length;
       int S = 0;
       for(int i=0;i<N;i++){
        S +=nums[i];
       } 
       //S = S/2;
       ///this is the solution based on 2d dp
        // int[][] dp = new int[N+1][S+1];
        // for(int i=0;i<N+1;i++){
        //     for(int j=0;j<S+1;j++){
        //         if (i==0||j==0) {
        //             dp[i][j] = 0;
        //         }else{
        //             if (nums[i-1]>j) {
        //                 dp[i][j] = dp[i-1][j];
        //             }else{
        //                 dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i-1]]+nums[i-1]);
        //             }
        //         }
        //     }
        // }
        // if (dp[N][S]==S) {
        //     return true;
        // }
        // return false;
        if(S%2!=0){
            return false;
        }
        //this is the solution based on the 1d dp
        int target = S/2;
        int[] dp = new int[target+1];
        dp[0] = 0;
        for(int num:nums){
            for(int i=target;i>=num;i--){
                dp[i] = Math.max(dp[i], dp[i-num]+num);
            }
        }

        return dp[target]==target;
    }
}