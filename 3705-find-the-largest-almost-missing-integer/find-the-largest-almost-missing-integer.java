class Solution {
    public int largestInteger(int[] nums, int k) {
        int cnt[] = new int[51];
        int start =  k > 1 && k < nums.length ? 1 : 0;
        int end =  k > 1 && k < nums.length ? nums.length - 1 : nums.length;
        for(int i=start;i<end;i++){
            cnt[nums[i]]++;
        }
        // System.out.println(start+" "+ end+" "+cnt[nums[0]]+" "+ cnt[nums[nums.length -1]]);

        if(k==1){
            for(int i=50;i>=0;i--)
                if(cnt[i] == 1)
                    return i;
        }else if(k == nums.length){
            for(int i=50;i>=0;i--)
                if(cnt[i] > 0)
                    return i;
        }else{
            if((cnt[nums[0]] > 0 && cnt[nums[nums.length -1]] > 0) || (nums[0] == nums[nums.length - 1]))
                return -1;
            else if(cnt[nums[0]] > 0)
                return nums[nums.length - 1];
            else if( cnt[nums[nums.length -1]] > 0)
                return  nums[0];
            else
                return Math.max(nums[nums.length -1],nums[0]);
        }
        return -1;
    }
}