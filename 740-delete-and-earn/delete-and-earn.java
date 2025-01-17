class Solution {
    public int deleteAndEarn(int[] nums) {
        int []arr = new int[10001];

        for(int i:nums)
            arr[i]++;
        
        int curr=0;
        int prev=0;
        int pprev=0;
        for(int i=1;i<arr.length;i++){
            curr = Math.max(arr[i] * i + pprev, prev);
            pprev = prev;
            prev = curr;
        }
        return curr;
    }
}