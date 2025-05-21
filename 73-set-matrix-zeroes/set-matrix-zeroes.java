class Solution {
    public void setZeroes(int[][] matrix) {
        int flag =0;
    
        if(matrix[0][0] == 0){
            flag = 3;
        }

        
        for(int i=0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    if(i == 0 && j!= 0){
                        if(flag == 2)
                            flag = 3;
                        else if(flag == 0)
                            flag = 1;
                    }
                    else if(i != 0 && j == 0){
                        if(flag == 1)
                            flag = 3;
                        else if(flag == 0)
                            flag = 2;
                    }
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                for(int j =1 ;j < matrix[i].length;j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j] == 0){
                for(int i=1;i<matrix.length;i++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(flag == 3){
            for(int i=0;i<matrix.length;i++)
                matrix[i][0] = 0;
            for(int i=0;i<matrix[0].length;i++)
                matrix[0][i] = 0;
        }else if(flag == 2){
            for(int i=0;i<matrix.length;i++)
                matrix[i][0] = 0;
        }else if(flag == 1){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i] = 0;
            }
        }
    }
}