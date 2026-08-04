
class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        List<Integer> lt = new ArrayList<>();
        Arrays.sort(nums);
        int difference = nums[0];
        int first = nums[0];
        int last = nums[nums.length-1];
        int length = nums.length;
        int temp = last - first + 1;
        int[] arr = new int[last - first + 1];
        for(int i=0;i<last - first + 1;i++){
            arr[i] = first+i;
             
        }
        
        for (int i = 0; i < temp; i++) {
            boolean found = false;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == arr[i]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                lt.add(arr[i]);
            }
        }
        return lt;

        
    }
}