
class Solution {
    public void dfs(char[][]grid,int i,int j){
        if (grid[i][j]=='0') {
            return ;
        }
        grid[i][j]='0';
        if (i<grid.length-1) {
            dfs(grid, i+1, j);
        }
        if (i>0) {
            dfs(grid, i-1, j);
        }
        if (j<grid[0].length-1) {
            dfs(grid, i, j+1);
        }
        if (j>0) {
            dfs(grid, i, j-1);
        }
        return ;
    }
    public int numIslands(char[][] grid) {
        int islandCounter = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                
                if (grid[i][j]=='1') {
                    islandCounter++;
                    dfs(grid,i,j);
                }
                
            }
        }
        return  islandCounter;
    }
}