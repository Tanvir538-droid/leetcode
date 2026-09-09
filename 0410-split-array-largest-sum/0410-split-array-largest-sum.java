
class Solution {
    public int splitArray(int[] nums, int k) {
        int left =0,right = 0;
        for(int num:nums){
            left = Math.max(left, num);
            right+=num;
        }
        
        while (left<right) {
            int mid = left+(right-left)/2;
            int m =1;//array split count
            int addition = 0;
            for(int num:nums){
                addition+=num;
                if (addition>mid) {
                    m++;
                    addition = num;
                }
            }
            if (m<=k) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}