class Solution {
    public int[][] kClosest(int[][] points, int k) {

        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(euclideanDistance(a),euclideanDistance(b))
        );
        for(int[] point:points){
            pq.offer(point);
        }
        int[][] result = new int[k][2]; 
        for(int i=0;i<k;i++){
            result[i] = pq.poll();
        }

        return result;

    }

    private int euclideanDistance(int[] point){
        int distance = (point[0] * point[0] + point[1] * point[1]);
        return distance;
    }
}