class Solution {
    public boolean isPossible(int []nums, int size){
        Map<Integer,Integer> even = new HashMap<>();
        Map<Integer,Integer> odd = new HashMap<>();

        for(int i=0;i<size;i++){
            if(nums[i]%2 == 0)
                even.put(nums[i],even.getOrDefault(nums[i],0)+1);
            else
                odd.put(nums[i],odd.getOrDefault(nums[i],0)+1);
        }
        if(even.size() == odd.size())
            return true;
        
        for(int i=size; i< nums.length;i++){
            if(nums[i-size]%2 == 0){
                even.put(nums[i-size],even.get(nums[i-size])-1);
                if(even.get(nums[i-size]) == 0)
                    even.remove(nums[i-size]);
            }
            else{
                odd.put(nums[i-size],odd.get(nums[i-size])-1);
                if(odd.get(nums[i-size]) == 0)
                    odd.remove(nums[i-size]);
            }

            if(nums[i]%2 == 0)
                even.put(nums[i],even.getOrDefault(nums[i],0)+1);
            else
                odd.put(nums[i],odd.getOrDefault(nums[i],0)+1);
            
            if(even.size() == odd.size())
                return true;
        }
        return false;
    }
    public int longestBalanced(int[] nums) {
        

        for(int i=nums.length;i>0;i--){
            if(isPossible(nums,i))
                return i;
        }
        return 0;
    }
}