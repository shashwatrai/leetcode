class Solution {
    public int findIndex(int [][]matrix,int col,int target){
        int l = 0 , r = matrix[col].length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(matrix[col][m] < target)
                l = m+1;
            else if(matrix[col][m] > target)
                r = m-1;
            else 
                return m;
        }
        return l;
    }
    public boolean searchMatrix(int[][] matrix, int target) {

        int l1 = findIndex(matrix,0,target);
        int l2 = findIndex(matrix,matrix.length-1,target);
        
        if((l1 < matrix[0].length && matrix[0][l1] == target ) ||
        ( l2 < matrix[matrix.length-1].length && matrix[matrix.length-1][l2] == target))
            return true;

        // System.out.println(l1+" "+l2);
        for(int i=l2;i<l1;i++){
            int x=0,y = matrix.length -1;
            while(x<=y){
                int m = (x+y)/2;
                if(matrix[m][i] < target)
                    x = m+1;
                else if(matrix[m][i] > target)
                    y = m-1;
                else
                    return true;
            }
        }
        
        return false;
    }
}
