class Solution {
    public boolean isPossible(int []nums,int target,int k){
        List<Integer> arr = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i] <= target)
                arr.add(i);
        }
        if(arr.size() < k)
            return false;
        int prev = 0,curr=0;
        for(int i=0;i<arr.size();i++){
            if(i> 0 && arr.get(i-1) + 1 < arr.get(i)){
                prev = curr;
                curr++;
            }else{
                int temp = prev;

                prev = curr;
                curr = Math.max(curr,temp+1);
            }
        }
        // System.out.println(target+" "+curr+" "+prev +" "+arr);
        return curr >= k;
    }
    public int minCapability(int[] nums, int k) {
        int l = 1;
        int r = 1;
        for(int i:nums)
            r = Math.max(i,r);
        
        int ans = -1;
        while(l <= r){
            int mid = (l+r)/2;
            if(isPossible(nums,mid,k)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
        
    }
}