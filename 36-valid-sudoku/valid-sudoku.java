class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i =0 ;i<9;i++){
            boolean flag[] = new boolean[10];
            for(int j=0;j<9;j++){
                if(board[i][j] == '.')
                    continue;

                if(flag[board[i][j]-'0'])
                    return false;
                flag[board[i][j]-'0']= true;
            }
        }

        for(int j =0 ;j<9;j++){
            boolean flag[] = new boolean[10];
            for(int i=0;i<9;i++){
                if(board[i][j] == '.')
                    continue;

                if(flag[board[i][j]-'0'])
                    return false;
                flag[board[i][j]-'0']= true;
            }
        }

        for(int i = 0;i<9;i+=3){
            for(int j = 0;j<9;j+=3){
                boolean flag[] = new boolean[10];
                for(int x = 0;x<3;x++){
                    for(int y = 0;y<3;y++){
                        if(board[i+x][j+y] == '.')
                            continue;
                        if(flag[board[i+x][j+y]-'0'])
                            return false;
                        flag[board[i+x][j+y]-'0']= true;
                    }
                }
            }
        }
        return true;

    }
}