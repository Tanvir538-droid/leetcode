
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int pile: piles){
            right = Math.max(pile, right);
        }

        while (left<right) {
            //calculating the mid hour
            int k = left+ (right-left)/2;
            //now calculate the hour
            long hours = 0;
            for(int pile: piles){
                hours +=pile/k;
                if (pile%k!=0) {
                    hours++;
                }
            }
            if (hours<=h) {
                right = k;
            }else{
                left = k+1;
            }
        }
        return right;
    }
}