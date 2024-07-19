class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<m;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                min = Math.min(min,matrix[i][j]);
            }

            for(int j=0;j<n;j++){
                if(min == matrix[i][j]){
                    boolean isTrue = true;
                    for(int k=0;k<m;k++){
                        if(min < matrix[k][j]){
                            isTrue = false;
                            break;
                        }
                    }
                    if(isTrue)
                        ans.add(matrix[i][j]);
                }
            }
        }

        return ans;
    }
}