class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> res = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<m;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                min = Math.min(min,matrix[i][j]);
            }

            for(int j=0;j<n;j++){
                if(min == matrix[i][j]){
                    res.add(i*n + j);
                }
            }
        }

        for(int j=0;j<n;j++){
            int max = Integer.MIN_VALUE;
            for(int i=0;i<m;i++){
                max = Math.max(max,matrix[i][j]);
            }

            for(int i=0;i<m;i++){
                if(max == matrix[i][j] && res.contains(i*n+j)){
                    ans.add( matrix[i][j]);
                }
            }
        }
        return ans;
    }
}