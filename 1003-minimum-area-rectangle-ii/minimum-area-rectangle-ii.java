class Solution {
    public boolean checkIsParallel(Double a, Double b){
        if(Math.abs(a) == Double.POSITIVE_INFINITY && Math.abs(b) == Double.POSITIVE_INFINITY )
            return true;
        else
            return Math.abs(a - b ) <= 1e-5 ;
    }
    public boolean checkIsOrthogonal(Double a,Double b){
        if( (Math.abs(a) < 1e-10 && Math.abs(b) == Double.POSITIVE_INFINITY )  || 
        (Math.abs(b) < 1e-10 && Math.abs(a) == Double.POSITIVE_INFINITY))
            return true;
        
        else 
            return Math.abs( a * b + 1) <= 1e-10; 
    }
    public double minAreaFreeRect(int[][] points) {
        int n  = points.length;
        Double dist[][] = new Double[n][n];
        Double slope[][] = new Double[n][n];

        //calculated slope and distance
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                
                dist[i][j] = dist[j][i] = Math.sqrt((points[i][0]-points[j][0]) *(points[i][0]-points[j][0]) + 
                             (points[i][1]-points[j][1]) *(points[i][1]-points[j][1])
                             );
                
                slope[i][j] = slope[j][i] = (double)(points[i][1]- points[j][1])/(points[i][0]-points[j][0]);

            }
        }
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(slope[i]));
        }
       
        double minArea = Double.MAX_VALUE;
        boolean found = false;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    continue;
                for(int k = 0;k<n;k++){
                    if(k == i || k==j)
                        continue;
                    for(int l = 0;l<n;l++){

                        if(l == k || l == i || l== j)
                            continue;
                        if(checkIsParallel(slope[i][j] , slope[k][l] ) && checkIsParallel(slope[i][l] ,slope[j][k]) 
                           && checkIsOrthogonal( slope[i][j] , slope[j][k] ) && checkIsOrthogonal(slope[j][k] , slope[k][l]) 
                            && checkIsOrthogonal(slope[k][l] , slope[l][i] )  && checkIsOrthogonal(slope[l][i] , slope[i][j])   
                            && (Math.abs(dist[i][j] - dist[k][l]) <= 1e-5) && (Math.abs(dist[i][l] - dist[j][k]) <= 1e-5)){
                                 
                                minArea = Math.min(minArea,dist[i][j] * dist[j][k]);
                                found = true;
                            }
                    }
                }
            }
        }

         return found ? minArea : 0f;
    }
}