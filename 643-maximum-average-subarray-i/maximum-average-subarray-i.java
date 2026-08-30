class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int result =0;
        for(int i=0;i<k;i++){
            result+=nums[i];
        }
        int temp = result;
        for(int i=k;i<nums.length;i++){
            result = result + nums[i] - nums[i-k];
            if (result>temp) {
                temp = result;
            }
        }

        double mainResult = (double) temp/k;
        return mainResult;
    }
}