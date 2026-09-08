

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left =0,right =0;
        for(int weight: weights){
            left = Math.max(weight, left);
            right+=weight;
        }
        
        while (left<right) {
            int mid = left+(right-left)/2;
            int k=1;
            int temp =0;
            
            for(int weight:weights){
                temp+=weight;
                if (temp>mid) {
                    temp = weight;
                    k++;//day increment
                }
            }
            
            if (k<=days) {
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}