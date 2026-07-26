class Solution {
    public int[] findErrorNums(int[] nums) {
        int i =0;
        int[] arr = new int[2];
        while(i<nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }else{
                i++;
            }
        }
        
        for(int k =0;k<nums.length;k++){
            if (nums[k] != k + 1) {
                arr[0]  = nums[k];
                arr[1] = k+1;
                break;
            }
        }
        
        return arr;
    }
}