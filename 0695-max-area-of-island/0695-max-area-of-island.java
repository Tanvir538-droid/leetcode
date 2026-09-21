class Solution {
    ///global counter to keep track 
    int counter = 0 ;
    public int dfs(int[][]grid,int i,int j){
        if (grid[i][j]==0) {
            return 0;
        }
        int temp = 0;
        grid[i][j] = 0;
        temp++;
        if (i<grid.length-1) {
            temp = temp + dfs(grid, i+1, j);
        }
        if (i>0) {
             temp = temp +dfs(grid, i-1, j);
        }
        if (j<grid[0].length-1) {
             temp = temp +dfs(grid, i, j+1);
        }
        if (j>0) {
             temp = temp +dfs(grid, i, j-1);
        }
        counter = Math.max(counter, temp);
        return temp;
    }
    public int maxAreaOfIsland(int[][] grid) {
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
               dfs(grid, i, j);
            }
        }

        return counter;
    }
}