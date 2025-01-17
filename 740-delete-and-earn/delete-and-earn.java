class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);

        TreeMap<Integer,Integer> map = new TreeMap<>();

        map.put(nums[0],nums[0]);
        int prev = nums[0];
        int max = nums[0];

        for(int i=1;i<nums.length;i++){
            int curr;
            if(nums[i] == nums[i-1]){
                curr = prev + nums[i];
            }else{
                curr = nums[i] + (map.floorKey(nums[i]-2) == null ? 0 : map.get(map.floorKey(nums[i]-2)));
            }
            max = Math.max(curr,max);
            map.put(nums[i],max);
            prev = curr;
        }
        return max;
    }
}