class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<nums.length-2;i++){
            int newTarget = target - nums[i];

            int x = i+1;
            int y = nums.length-1;

            while(x<y){
                if(nums[x]+nums[y] < newTarget){
                    if(minDiff > Math.abs(newTarget - nums[x] - nums[y])){
                        ans = nums[x]+nums[y]+nums[i];
                        minDiff = Math.abs(newTarget - nums[x] - nums[y]); 
                    }
                    x++;
                }else if(nums[x]+nums[y] > newTarget){
                    if(minDiff > Math.abs(newTarget - nums[x] - nums[y])){
                        ans = nums[x]+nums[y]+nums[i];
                        minDiff = Math.abs(newTarget - nums[x] - nums[y]); 
                    }
                    y--;
                }else 
                    return target;
            }
        }
        return ans;
    }
}

