class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: stones){
            pq.offer(num);
        }


        while (pq.size()>1) {
            int a = pq.poll();
            int b = pq.poll();

            if(a>b){
                pq.offer(a-b);
            }else if(b>a){
                pq.offer(b-a);
            }
            
        }


        if(pq.isEmpty()){
            return 0;
        }
        return pq.poll();
        
    }
}