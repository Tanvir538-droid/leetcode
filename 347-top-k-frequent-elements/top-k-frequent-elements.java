class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //the problem is get the k most frequent numbers

        //base case: the numbers in the array can be one
        if(nums.length==1){
            return nums;
        }

        //count the frequency of each number 
        //saave them into a hashmap where the number is the key
        //and the frequency is the value
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num, 0) +1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b) -> a[1]-b[1]
            );

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(new int[]{
                entry.getKey(),
                entry.getValue()
            });

            if (pq.size()>k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];

        for(int i=0;i<k;i++){
            ans[i] = pq.poll()[0];
        }
        return ans;
        
    }
}