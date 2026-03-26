class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

       
        int []arr1 = new int[100001];
        int []arr2 = new int[100001];
        long h[] = new long[n];

        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                arr2[grid[i][j]]++;
            }
            arr1[grid[i][0]]++;
        }

        
        for(int j=0;j<n;j++){
            long t = 0L;
            for(int i=0;i<m;i++){
                t += grid[i][j];   
            }
            h[j] = t + (j>0 ? h[j-1]:0);
        }

        


        // System.out.println(Arrays.toString(v));
        // System.out.println(hMap+" "+hMapR);
        // System.out.println(vMap+" "+vMapR);

        for(int i=0;i<n-1;i++){
            long remains = h[i] + h[i] - h[n-1];
            if(remains > 100000L || remains < -100000L)
                continue;
            int temp = (int)(Math.abs(remains));
            if(remains == 0L)
                return true;
            else if(remains < 0L ){
                
                if(i == n-2 ){
                    if(grid[0][n-1] == temp || grid[m-1][n-1] == temp)
                        return true;
                }else if(m > 1 && temp > 0 && temp < arr2.length && arr2[temp] > 0)
                    return true;
                else if(m == 1 && (grid[0][i+1] == temp || grid[0][n-1] == temp))
                    return true;
            }else{
                if(i == 0){
                    if(grid[0][0] == temp || grid[m-1][0] == temp)
                        return true;
                }else if(m>1 && temp > 0 && temp < arr1.length && arr1[temp] > 0)
                    return true;
                else if(m==1 && (grid[0][0] == temp || grid[0][i] == temp))
                    return true;
            }

            for(int j=0;j<m;j++){
                arr1[grid[j][i+1]]++;
                arr2[grid[j][i+1]]--;
            }
        }
        
        long v[] = new long[m];
        arr1 = new int[100001];
        arr2 = new int[100001];
    
        for(int j=0;j<n;j++){
            for(int i=1;i<m;i++){
                arr2[grid[i][j]]++;
            }
            arr1[grid[0][j]]++;
        }

        for(int i=0;i<m;i++){
            long t = 0L;
            for(int j=0;j<n;j++){
                t += grid[i][j];   
            }
            v[i] = t + (i>0?v[i-1]:0);
        }

        for(int i=0;i<m-1;i++){
            long remains = v[i] + v[i] - v[m-1];
            if(remains > 100000L || remains < -100000L)
                continue;
            int temp = (int)(Math.abs(remains));
            // System.out.println(temp);
            if(remains == 0L){
                // System.out.println("exact");
                return true;
            }
            else if(remains < 0L ){
                if(i == m-2){
                    if(grid[m-1][0] == temp || grid[m-1][n-1] == temp){
                        // System.out.println("last row");
                        return true;
                    }
                }else if(n > 1 && temp > 0 && temp < arr2.length && arr2[temp] > 0){
                    // System.out.println("random cell "+i+" "+temp+" "+arr2[temp]+" "+remains);
                    return true;
                }
                else if(n ==1 && (grid[m-1][0] == temp || grid[i+1][0] == temp ))
                    return true;
            }else{
                if(i == 0){
                    if(grid[0][0] == temp || grid[0][n-1] == temp){
                        // System.out.println("first row");
                        return true;
                    }
                }else if(n > 1 && temp>0 && temp < arr1.length && arr1[temp] > 0){
                    // System.out.println("random match 1st part "+i+" "+temp);
                    return true;
                }
                else if(n == 1 && (grid[0][0] == temp || grid[i][0] == temp))
                    return true;

            }

            for(int j=0;j<n;j++){
                arr1[grid[i+1][j]]++;
                arr2[grid[i+1][j]]--;
            }
        }
        return false;
    }
}