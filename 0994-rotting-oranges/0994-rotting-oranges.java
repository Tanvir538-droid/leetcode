class Solution {

    public int freshOrangeChecker(int[][] grid) {
        int counter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public int rottenOrangeChecker(int[][] grid) {
        int counter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public int orangesRotting(int[][] grid) {

        // No fresh oranges -> already finished
        if (freshOrangeChecker(grid) == 0) {
            return 0;
        }

        // Fresh oranges exist but no rotten oranges -> impossible
        if (rottenOrangeChecker(grid) == 0) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();

        // Put all rotten oranges into the queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int minutes = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                // Down
                if (row + 1 < grid.length &&
                    grid[row + 1][col] == 1) {

                    grid[row + 1][col] = 2;
                    queue.offer(new int[]{row + 1, col});
                }

                // Up
                if (row - 1 >= 0 &&
                    grid[row - 1][col] == 1) {

                    grid[row - 1][col] = 2;
                    queue.offer(new int[]{row - 1, col});
                }

                // Right
                if (col + 1 < grid[0].length &&
                    grid[row][col + 1] == 1) {

                    grid[row][col + 1] = 2;
                    queue.offer(new int[]{row, col + 1});
                }

                // Left
                if (col - 1 >= 0 &&
                    grid[row][col - 1] == 1) {

                    grid[row][col - 1] = 2;
                    queue.offer(new int[]{row, col - 1});
                }
            }

            minutes++;
        }

        // If fresh oranges are still left, they cannot be reached
        if (freshOrangeChecker(grid) > 0) {
            return -1;
        }

        return minutes - 1;
    }
}