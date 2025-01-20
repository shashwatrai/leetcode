class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int rowMap [] = new int[m];
        int colMap[] = new int[n];

        Arrays.fill(rowMap,n);
        Arrays.fill(colMap,m);

        int matMap[][] = new int[m*n+1][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matMap[mat[i][j]] = new int[]{i,j};
            }
        }

        for(int i=0;i<arr.length;i++){
            int x[] = matMap[arr[i]];
            rowMap[x[0]]--;
            colMap[x[1]]--;
            if(rowMap[x[0]] == 0 || colMap[x[1]] == 0)
                return i;
        }
        return -1;
    }
}