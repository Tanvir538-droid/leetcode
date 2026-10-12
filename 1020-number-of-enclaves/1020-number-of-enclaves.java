class Solution {
    public void dfs(int[][] board,int i,int j){
        if (i<0||i>=board.length||j<0||j>=board[i].length||board[i][j]!=1) {
            return;
            }
        board[i][j] = 2;
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);

    }
    public int numEnclaves(int[][] grid) {
        for(int i=0;i<grid.length;i++){
           if (grid[i][0]==1) {
            dfs(grid, i, 0);
           }

           if (grid[i][grid[i].length-1]==1) {
            dfs(grid, i, grid[i].length-1);
           }
        }

        for(int j=0;j<grid[0].length;j++){
            if (grid[0][j]==1) {
                dfs(grid, 0, j);
            }

            if (grid[grid.length-1][j]==1) {
                dfs(grid, grid.length-1, j);
            }
        }
        int counter = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if (grid[i][j]==1) {
                    counter++;
                }
            }
        }

        return counter;
    }
}