
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //here k is the source
        int source = k;
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }


        for(int[] edge :times){
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph.get(from).add(new int[]{to,weight});
        }

        int[] distance = new int[n+1];
         
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->a[0]-b[0]
        );
        ///pq.add(new int[]{distance,source});
        pq.add(new int[]{0,source});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[1];
            int currentDistance = current[0];
            if (currentDistance>distance[currentNode]) {
                continue;
            }


            for(int[] edge:graph.get(currentNode)){
                int nextNode =edge[0];
                int weight = edge[1];
                int newDistance = weight+currentDistance;
                if (newDistance<distance[nextNode]) {
                    distance[nextNode] = newDistance;
                    pq.offer(new int[]{newDistance,nextNode});
                }
            }
        }
        int answer = 0;

        for(int i = 1; i <= n; i++){

            if(distance[i] == Integer.MAX_VALUE){
                return -1;
            }

            answer = Math.max(answer, distance[i]);
        }

        return answer;
    }
}