class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int i = 0;

        while (i < nums.length) {

            int correct = nums[i] - 1;

            if (nums[i] != nums[correct]) {
                // Swap nums[i] with its correct position
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                answer.add(i + 1);
            }
        }

        return answer;
    }
}