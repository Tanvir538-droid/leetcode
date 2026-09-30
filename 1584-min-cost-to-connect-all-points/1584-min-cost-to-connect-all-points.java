
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
          (a,b)->  a[0]-b[0]
        );
        int totalCost = 0;
        //pq.offer(new int[]{cost,point});
        pq.offer(new int[]{0,0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int point = current[1];
            if (visited[point]) {
                continue;
            }
            visited[point] = true;
            totalCost+=cost;
            for(int next=0;next<n;next++){
                if (visited[next]) {
                    continue;
                }
                int x1 = points[point][0];
                int y1 = points[point][1];

                int x2 = points[next][0];
                int y2 = points[next][1];
                int distance = Math.abs(x1-x2) + Math.abs(y1-y2);
                pq.offer(new int[]{distance,next});
            }
        }

        return totalCost;
    }
}