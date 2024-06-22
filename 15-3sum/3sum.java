class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort( nums);
        List<List<Integer>> res = new ArrayList<>();
        int prev = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            if(prev == nums[i])
                continue;
            prev = nums[i];
            int target = -nums[i];

            int l = i+1;
            int r = n-1;
            while(l<r){
                if(nums[l]+nums[r] > target){
                    r--;
                }else if(nums[l] + nums[r] < target){
                    l++;
                }else{
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    int test = nums[l];
                    while(l<r && nums[l] == test)
                        l++;
                    test = nums[r];
                    while(l<r && nums[r] == test)
                        r--;
                }
            }
            
        }
        return res;
    }
}