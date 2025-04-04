class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;

        int arr[] = new int[n*m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // System.out.println(i+" "+j +" "+(i*m+j));
                arr[i*m + j] = grid[i][j];
            }
        }
        Arrays.sort(arr);

        int med = arr[arr.length/2];
        int steps = 0;
        for(int i=0;i<arr.length;i++){
            if(Math.abs(med-arr[i])%x != 0)
                return -1;
            steps+= Math.abs(med - arr[i])/x;
        }
        return steps;
        
       
    }
}