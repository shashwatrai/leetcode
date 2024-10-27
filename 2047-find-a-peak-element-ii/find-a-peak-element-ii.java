class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

            int l = 0,r = n-1;
            while(l<=r){
                int mid = (l+r)/2;

                int leftMax ,midMax , rightMax;
                leftMax  = midMax = rightMax = -1;
                int indx = -1;
                for(int i=0;i<m;i++){
                    if(midMax < mat[i][mid]){
                        indx = i;
                        midMax = mat[i][mid];
                        if(mid > 0)
                            leftMax = Math.max(leftMax,mat[i][mid-1]);
                        if(mid < n-1)
                            rightMax = Math.max(rightMax,mat[i][mid+1]);
                    }    
                }
                // System.out.println(l+" "+r+" "+leftMax+" "+midMax+" "+rightMax);
                if(midMax > Math.max(leftMax,rightMax)){
                    return new int[]{indx,mid};
                }
                if(leftMax > midMax)
                    r = mid-1;
                else 
                    l = mid+1;
                

            }
        return new int[]{};
    }
}
