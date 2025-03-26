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

        if(arr.length%2 == 1){
            int med = arr[arr.length/2];
            int ans = 0;
            for(int i=0;i<arr.length;i++){
                if(Math.abs(arr[i]-med)%x != 0){
                    return -1;
                }
                ans+=Math.abs(arr[i]-med)/x;
            }
            return ans;
        }else{
            int med = arr[arr.length/2];
            int ans1 = 0;
            for(int i=0;i<arr.length;i++){
                if(Math.abs(arr[i]-med)%x != 0){
                    ans1 = Integer.MAX_VALUE;
                    break;
                }
                ans1+=Math.abs(arr[i]-med)/x;
            }
            
            med = arr[arr.length/2-1];
            int ans2 = 0;
            for(int i=0;i<arr.length;i++){
                if(Math.abs(arr[i]-med)%x != 0){
                    ans2 = Integer.MAX_VALUE;
                    break;
                }
                ans2+=Math.abs(arr[i]-med)/x;
            }

            med = (arr[arr.length/2-1] + arr[arr.length/2])/2;
            int ans3 = 0;
            for(int i=0;i<arr.length;i++){
                if(Math.abs(arr[i]-med)%x != 0){
                    ans3 = Integer.MAX_VALUE;
                    break;
                }
                ans3+=Math.abs(arr[i]-med)/x;
            }
            int ans = Math.min(ans1,Math.min(ans2,ans3));
            return ans == Integer.MAX_VALUE?-1:ans;
        }
        
       
    }
}