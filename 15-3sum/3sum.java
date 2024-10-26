class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];

            int l = i+1,r = n-1;
            while(l<r){
                if(nums[l] + nums[r] > target){
                    do{
                        r--;
                    }while(r > l && nums[r] == nums[r+1]);
                }else if(nums[l]+ nums[r] < target){
                    do{
                        l++;
                    }while(l < r && nums[l] == nums[l-1]);
                }else{
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    do{
                        l++;
                    }while(l < r && nums[l] == nums[l-1]);
                    do{
                        r--;
                    }while(r > l && nums[r] == nums[r+1]);
                }
            }
        }
        return res;
    }
}