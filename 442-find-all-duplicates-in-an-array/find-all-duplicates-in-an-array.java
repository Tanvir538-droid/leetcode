class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i =0;
        List<Integer> list = new ArrayList<>();
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
                list.add(nums[k]);
            }
        }
        return list;
    }
}