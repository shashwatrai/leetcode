class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res =new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n-3;i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j =i+1;j<n-2;j++){
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                
                long sum = (long)((long)target - (long)nums[i] - (long)nums[j]);
                int l = j+1,r = n-1;
                while(l<r){
                    if(nums[l] + nums[r] > sum){
                        do{
                            r--;
                        }while(r > l && nums[r] == nums[r+1]);
                    }else if(nums[l] +  nums[r] < sum){
                        do{
                            l++;
                        }while(l < r && nums[l] == nums[l-1]);
                    }else{
                        System.out.println((nums[l] + nums[r]) +" "+sum);
                        res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        do{
                            r--;
                        }while(r > l && nums[r] == nums[r+1]);
                        do{
                            l++;
                        }while(l < r && nums[l] == nums[l-1]);
                    }
                }
            }
        }
        return res;
    }
}