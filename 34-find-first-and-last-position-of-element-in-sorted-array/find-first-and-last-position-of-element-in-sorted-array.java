class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] result = {-1, -1};

        result[0] = search(nums, target, true);   // First occurrence
        result[1] = search(nums, target, false);  // Last occurrence

        return result;
    }

    public int search(int[] nums, int target, boolean findFirst) {

        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;

                if (findFirst) {
                    end = mid - 1;      // Search on the left
                } else {
                    start = mid + 1;    // Search on the right
                }
            }
        }

        return ans;
    }
}