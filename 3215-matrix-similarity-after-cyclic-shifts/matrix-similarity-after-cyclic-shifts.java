class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;


        for(int i=0;i<m;i++){
            for(int j= i%2 == 0? k%n: (n - k%n)%n,l=0 ;l<n;l++,j++){
                if(mat[i][j%n] != mat[i][l])
                    return false;
            }
        }
        return true;
    }
}