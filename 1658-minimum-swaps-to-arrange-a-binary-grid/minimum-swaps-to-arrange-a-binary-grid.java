class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int arr[] = new int[n];

        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=n-1;j>0;j--){
                if(grid[i][j] == 0)
                    count++;
                else
                    break;

            }
            arr[i] = count;
        }
        int placed = 0;
        int ans = 0;

        for(int i=0;i<n;i++){
            boolean found = false;
            for(int j=i;j<n;j++){
                if(arr[j] >= n -  1 - i){
                    ans += j - i;
                    int temp = arr[j];
                    for(int k = j; k > i ;k--)
                        arr[k] = arr[k-1];
                    arr[i] = temp;
                    found = true;
                    break;
                }
            }
            if(!found)
                return -1;
        }
        return ans;
    }
}