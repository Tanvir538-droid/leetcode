class Solution {
    public int missingNumber(int[] nums) {

        int i = 0;

        while (i < nums.length) {

            int correct = nums[i];

            // Place the number at its correct index
            // Ignore nums.length because it has no index in the array
            if (nums[i] < nums.length && nums[i] != nums[correct]) {

                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;

            } else {
                i++;
            }
        }

        // Find the missing number
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        // If every index has the correct number,
        // then the missing number is n
        return nums.length;
    }
}