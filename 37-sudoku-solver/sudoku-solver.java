class Solution {
    public boolean isValid(char[][] board,int r,int c,char t){
        //System.out.println("t:"+t);
        for(int i=0;i<board.length;i++){
            if(board[r][i] == t || board[i][c] == t)
                return false;
        }
        int lr = 3 *( r/3),lc = 3* (c/3),rr = 3 *((r+3)/3),rc = 3*((c+3)/3);
        for(int i=lr;i<rr;i++){
            for(int j =lc;j<rc;j++){
                if(board[i][j] == t)
                    return false;
            }
        }
        return true;
    }
   
    public boolean solve(char [][] board){
         for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == '.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j] = c;
                            if(solve(board))
                                return true;
                            else 
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
       solve(board);
    }
}