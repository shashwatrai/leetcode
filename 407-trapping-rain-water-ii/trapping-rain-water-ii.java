class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        int left[][] = new int[m][n];
        int right[][] = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                left[i][j] = Math.max(heightMap[i][j],j> 0?left[i][j-1]:0);
                right[i][n-1-j] = Math.max(heightMap[i][n-1-j],j>0?right[i][n-j]:0);
            }
        }

        int up[][] = new int[m][n];
        int down[][] = new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                up[j][i] = Math.max(heightMap[j][i],j> 0?up[j-1][i]:0);
                down[m-1-j][i] = Math.max(heightMap[m-1-j][i],j>0?down[m-j][i]:0);
            }
        }
        int finalH[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                finalH[i][j]= Math.min(left[i][j],Math.min(right[i][j],Math.min(up[i][j],down[i][j])));
            }
        }
        // System.out.println(Arrays.deepToString(finalH)); 
        while(true){
            int [][]temp = new int[m][];
            for(int i=0;i<m;i++)
                temp[i] = Arrays.copyOf(finalH[i],n);
            
            for(int i=1;i<m-1;i++){
                for(int j=1;j<n-1;j++){
                    finalH[i][j] = Math.max(heightMap[i][j],Math.min(finalH[i-1][j],Math.min(finalH[i+1][j],Math.min(finalH[i][j-1],finalH[i][j+1]))));
                }
            }
            // System.out.println(Arrays.deepToString(finalH));        
            if(Arrays.deepEquals(temp,finalH))
                break;
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                ans += finalH[i][j] - heightMap[i][j];
        }
        // System.out.println(Arrays.deepToString(left));
        // System.out.println(Arrays.deepToString(right));
        // System.out.println(Arrays.deepToString(up));
        // System.out.println(Arrays.deepToString(down));
        //  System.out.println(Arrays.deepToString(finalH));
        return ans;
    }
}