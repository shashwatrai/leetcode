class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        

        int n = rows*cols;
        int ans[][] = new int[n][2];
        int r = Math.max(Math.max(rows-rStart-1,rStart),Math.max(cols-cStart-1,cStart));
        int x= rStart,y = cStart;
        int k=0;
        ans[k][0] = x++;
        ans[k][1] = y;
        k++;
        for(int i=1;i<=r;i++){
            int c = 8*i;
            x = x - 1;
            y = cStart+i;
           
            for(int j=0;j<c;j++){
                System.out.println(x+" "+y);
                if(x>=0 && x<rows && y>=0 && y<cols){

                    ans[k][0] = x;
                    ans[k][1] = y;
                    k++;
                    
                }
                if( x < rStart+i && y-cStart == i){
                    x++;
                }
                else if(x > rStart - i && cStart-y == i)
                    x--;
                else if(y < cStart + i && rStart - x == i)
                    y++;
                else if(y>cStart-i && x - rStart == i)
                    y--;  
            }

        }
        return ans; 
    }
}
