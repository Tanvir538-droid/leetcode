class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        //I need to create a max heap here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //copy the score array into the priority queue
        for(int num : score){
            pq.offer(num);
        }





        //then I need to create a hashmap of Integer key and string value
        HashMap<Integer,String> map = new HashMap<>();


        //then move the values accordingly in the hashmap 
        
        for(int i=0;i<score.length;i++){
            String str = "";
            if(i==0){
                str = "Gold Medal";
            }else if (i==1) {
                str = "Silver Medal";
            }else if(i==2){
                str = "Bronze Medal";
            }else{
                int j = i+1;
                str = String.valueOf(j);
            }
            map.put(pq.poll(), str);
        }

        //I need to create an array of the same size of the array score
        String[] ans = new String[score.length];
        
        //copy the values from the hashmap into an array

        for (int i = 0; i < score.length; i++) {
            ans[i] = map.get(score[i]);
        }

        //then return the array
        return ans;
    }
}