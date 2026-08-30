class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        threshold = threshold * k;
        int counter=0;
        int currentResult = 0;
        for(int i=0;i<k;i++){
            currentResult+=arr[i];
        }

        if (currentResult>=threshold) {
            counter++;
        }
        for(int i=k;i<arr.length;i++){
            currentResult = currentResult+arr[i]-arr[i-k];
            if (currentResult>=threshold) {
            counter++;
            }
        }
        return counter;
    }
}