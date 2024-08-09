class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int hor[][] = new int[n][m];
        int ver[][] = new int[n][m];
        int dia1[][] = new int[n][m];
        int dia2[][] = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                hor[i][j] = grid[i][j] + (j>0 ? hor[i][j-1]:0);
            }
        }

        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                ver[i][j] = grid[i][j] + (i>0 ? ver[i-1][j]:0);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dia1[i][j] = grid[i][j] + (i>0 && j >0 ? dia1[i-1][j-1]:0);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=m-1;j>=0;j--){
                dia2[i][j] = grid[i][j] + (i>0 && j < m-1 ? dia2[i-1][j+1]:0);
            }
        }

        int count=0;

        for(int i=2;i<n;i++){
            for(int j=2;j<m;j++){
                boolean find[] = new boolean[10];
                for(int x=i-2;x<=i;x++){
                    for(int y = j-2;y<=j;y++)
                        if(grid[x][y] < 10 && grid[x][y] > 0){
                            find[grid[x][y]] = true;
                        }
                }
                boolean isValid = true;
                for(int x=1;x<10;x++){
                    isValid = isValid && find[x];
                }
                if(!isValid)
                    continue;
                int horval1 = hor[i-2][j] - (j > 2 ? hor[i-2][j-3] : 0);
                int horval2 = hor[i-1][j] - (j > 2 ? hor[i-1][j-3] : 0);
                int horval3 = hor[i][j] - (j > 2 ? hor[i][j-3] : 0);

                int verval1 = ver[i][j-2] - (i > 2 ? ver[i-3][j-2]:0);
                int verval2 = ver[i][j-1] - (i > 2 ? ver[i-3][j-1]:0);
                int verval3 = ver[i][j] - (i > 2 ? ver[i-3][j]:0);

                
                int dia1val = dia1[i][j] - ( i>2 && j>2 ? dia1[i-3][j-3]:0);
                int dia2val = dia2[i][j-2] - ( i>2 && j<m-1? dia2[i-3][j+1]:0);
                System.out.println(horval1+" "+horval2+" "+horval3);
                System.out.println(verval1+" "+verval2+" "+verval3);
                System.out.println(dia1val+" "+dia2val);
                if(horval3 == verval3 && horval3 == dia1val &&  horval3 == dia2val && 
                    horval3 == horval2 && horval3 == horval1 &&
                     verval3 == verval2 && verval3 == verval1)
                        count++;
            }
        }
        return count;
    }
} 