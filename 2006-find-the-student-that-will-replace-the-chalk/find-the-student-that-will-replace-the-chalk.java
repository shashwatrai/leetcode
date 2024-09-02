class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long []arr = new long[n];
        arr[0] = chalk[0];
        for(int i=1;i<chalk.length;i++){
            arr[i] = chalk[i] + arr[i-1];
        }
        k %= arr[n-1];
        for(int i=n-1;i>=0;i--){
            if(k >= arr[i])
                return i+1;
        }
        return 0;
    }
}