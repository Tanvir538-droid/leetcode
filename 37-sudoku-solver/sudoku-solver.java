class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }


    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char num='1';num<='9';num++){
                        if(isValid(board,i,j,num)){
                            board[i][j]=num;
                            if(solve(board)){
                                return true;
                            }
                            board[i][j]='.';

                        }

                    }
                    return false;
                }
            }
        }

        return true;
    } 

    public boolean isValid(char[][] board,int row,int col,char num){
        //check for the row
        for(int j=0;j<9;j++){
            if(board[row][j]==num){
                return false;
            }
        }

        //check for the column 
        for(int i=0;i<9;i++){
            if(board[i][col]==num){
                return false;
            }
        }

        //check for the sub box or you can say 3x3 box
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;

        for(int i=startRow;i<startRow + 3;i++){
            for(int j=startCol;j<startCol + 3;j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }

        return true;
    }
}