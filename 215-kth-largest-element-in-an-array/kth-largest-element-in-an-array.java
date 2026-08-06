class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Create a priority queue 
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        //copy all the elements into the queue
        int j=0;
        for(int i = 0; i<nums.length;i++){
            if(j==k){
                pq.add(nums[i]);
                pq.poll();
                continue;
            }
            pq.add(nums[i]);
            j++;
        }

        return pq.poll();
        
    }
}