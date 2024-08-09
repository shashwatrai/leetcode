class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans =  new ArrayList<>();

        for(int i=0;i<nums.length -2 ;i++){
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int sum = - nums[i];
            
            int x = i+1,y = nums.length -1;
            while(x<y){
                if(sum == nums[x] + nums[y]){
                    ans.add(Arrays.asList(nums[i],nums[x],nums[y]));
                     do{
                        x++;
                    }while(x == i+1 || (x<nums.length && x > i+1 && nums[x] == nums[x-1]));
                    do{
                        y--;
                    }while(y == nums.length - 1 || (y>0 && y < nums.length-1 && nums[y] == nums[y+1]));

                }else if(sum > nums[x]+nums[y]){
                    do{
                        x++;
                    }while(x<nums.length  && nums[x] == nums[x-1]);
                }else{
                    do{
                        y--;
                    }while(y>0 && nums[y] == nums[y+1]);
                }
            }
        }
        return ans;
    }
}