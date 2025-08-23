class Solution {

    public int reducedSize(int [][]grid, int x1,int y1,int x2,int y2){

        int l1 = x2,l2 = x1,b1 = y2, b2 = y1;
        for(int i =x1 ;i <= x2; i++){
            for(int j = y1;j <= y2 ; j++){
                if(grid[i][j] == 0)
                    continue;
                l1 = Math.min(i,l1);
                l2 = Math.max(i,l2);
                b1 = Math.min(j,b1);
                b2 = Math.max(j,b2);
            }
        }
        System.out.println( x1 +" "+ x1 +" "+y1 +" "+y2);
        System.out.println( l1 +" "+ l2 +" "+b1 +" "+b2);
        if(l1 == x2 && b1 == y2)
            return 1;

        return (l2 - l1 + 1) * (b2 - b1 + 1);
    }

    public int minimumSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int area = Integer.MAX_VALUE;
        for(int i=1;i<=m-1;i++){
            int minArea1, minArea2;
            minArea1 = minArea2 = Integer.MAX_VALUE;
            for(int j = 1;j<=n-1;j++){
                
                minArea1 = Math.min(minArea1,
                                 reducedSize(grid,i,0,m-1,j-1) + reducedSize(grid,i,j,m-1,n-1));
                
                minArea2 = Math.min(minArea2,
                                 reducedSize(grid,0,0,m-1-i,j-1) + reducedSize(grid,0,j,m-1-i,n-1));
                 
                // System.out.println(minArea1+" "+minArea2);

            }

            area = Math.min ( area,Math.min(minArea1+reducedSize(grid,0,0,i-1,n-1) , minArea2 + reducedSize(grid,m-i,0,m-1,n-1)));
            // System.out.println(area);
        }

        //  System.out.println();
        for(int j = 1;j<=n-1;j++){
            int minArea1, minArea2;
            minArea1 = minArea2 = Integer.MAX_VALUE;
            for(int i = 1;i<= m-1;i++){
                minArea1 = Math.min(minArea1,
                                 reducedSize(grid,0,j,i-1,n-1) + reducedSize(grid,i,j,m-1,n-1));
                
                minArea2 = Math.min(minArea2,
                                 reducedSize(grid,0,0,i-1,n-1-j) + reducedSize(grid,i,0,m-1,n-1-j));
                // System.out.println(minArea1+" "+minArea2);
            }
            area = Math.min ( area,Math.min(minArea1+reducedSize(grid,0,0,m-1,j-1) , minArea2 + reducedSize(grid,0,n-1-j,m-1,n-1)));
            // System.out.println(area);
        }

        for(int i = 1;i<= m - 2; i++){
            for(int j = i+1;j <= m-1;j++){
                area = Math.min(area,
                            reducedSize(grid,0,0,i-1,n-1) + 
                            reducedSize(grid,i,0,j-1,n-1) + 
                            reducedSize(grid,j,0,m-1,n-1)
                        );
            }
        }

        for(int i = 1;i<= n - 2; i++){
            for(int j = i+1;j <= n-1;j++){
                area = Math.min(area,
                            reducedSize(grid,0,0,m-1,i-1) + 
                            reducedSize(grid,0,i,m-1,j-1) + 
                            reducedSize(grid,0,j,m-1,n-1)
                        );
            }
        }
        return area;
    }
}