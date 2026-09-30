class Solution {

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean[] visited = new boolean[n];
        int[] minCost = new int[n];

        Arrays.fill(minCost, Integer.MAX_VALUE);

        minCost[0] = 0;

        int totalCost = 0;

        for (int i = 0; i < n; i++) {

            // Find cheapest unvisited point
            int current = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] &&
                    (current == -1 || minCost[j] < minCost[current])) {
                    current = j;
                }
            }

            // Add it to MST
            visited[current] = true;
            totalCost += minCost[current];

            // Update connection costs
            for (int j = 0; j < n; j++) {

                if (!visited[j]) {

                    int distance =
                        Math.abs(points[current][0] - points[j][0])
                        + Math.abs(points[current][1] - points[j][1]);

                    minCost[j] = Math.min(minCost[j], distance);
                }
            }
        }

        return totalCost;
    }
}