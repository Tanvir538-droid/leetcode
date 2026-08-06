import java.util.PriorityQueue;

class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        );

        // Count soldiers using binary search
        for (int i = 0; i < mat.length; i++) {

            int soldiers = countSoldiers(mat[i]);

            pq.offer(new int[]{soldiers, i});
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[1];
        }

        return ans;
    }

    // Returns the number of soldiers in one row
    private int countSoldiers(int[] row) {

        int left = 0;
        int right = row.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (row[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}