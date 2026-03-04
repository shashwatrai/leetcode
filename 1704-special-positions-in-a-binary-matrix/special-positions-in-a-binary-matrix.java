class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int hor[] = new int[m];

        int n = mat[0].length;
        int ver[] = new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                hor[i] += mat[i][j];
        }

        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++){
                ver[j] += mat[i][j];
            }
        }

        int ans =0 ;
        // System.out.println(Arrays.toString(ver));
        // System.out.println(Arrays.toString(hor));
        for(int i =0;i<m;i++){
            for(int  j=0;j<n;j++){
                if(mat[i][j] == 1 && ver[j] == 1 && hor[i] == 1 )
                    ans++;
            }
        }
        return ans;
    }
}