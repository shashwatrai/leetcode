class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int sum = -nums[i];

            int l = i+1,r = nums.length-1;
            while(l<r){
                if(nums[l] + nums[r] == sum){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    do{
                        l++;
                    }while(l< r && nums[l] == nums[l-1]);
                    do{
                        r--;
                    }while(r > l && nums[r] == nums[r+1]);

                }else if(nums[l] + nums[r] > sum){
                    do{
                        r--;
                    }while(r > l && nums[r] == nums[r+1]);
                }else{
                    do{
                        l++;
                    }while(l< r && nums[l] == nums[l-1]);
                }
            }
        }
        return res;
    }
}