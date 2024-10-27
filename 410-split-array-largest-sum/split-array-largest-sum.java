class Solution {
    public int countSplits(int []arr,int m){
        int cnt =1;
        int sum=0;
        for(int i:arr){
            sum += i;
            if(sum > m){
                cnt++;
                sum = i;
            }
        }
        return cnt;
    }
    public int splitArray(int[] nums, int k) {
        if(nums.length < k){
            return -1;
        }

        int l =0;
        int r = 0;
        for(int i:nums){
            r+=i;
            l = Math.max(l,i);
        }
        
        while(l<=r){
            int m = (l+r)/2;
            int splits = countSplits(nums,m);
            // System.out.println(l+" "+r+" "+splits);
            if(splits <= k)
                r = m-1;
            else
                l = m+1;
        }
        return l;
    }
}