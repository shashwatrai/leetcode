class Solution {
    public int longestMonotonicSubarray(int[] arr) {
        int len=0;
        int start =0 ,end = arr.length - 1;
        int n = arr.length;
        for(int i=1; i < n;i++){
            if(arr[i] <= arr[i-1]){
                len = Math.max(i-start,len);
                start = i;
            }

            if(arr[n-1-i] <= arr[n-i]){
                len = Math.max(end - n + 1 + i,len);
                end = n - 1 - i;
            }
        }
        len = Math.max(n-start,len);
        len = Math.max(end + 1,len);
        return len;


    }
}