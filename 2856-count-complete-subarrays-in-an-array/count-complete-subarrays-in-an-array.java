class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int start  = 0;
        int n = nums.length;
        
        Set<Integer> count = new HashSet<>();
        for(int i=0;i<n;i++){
           count.add(nums[i]);
        }
        // System.out.println(count.size());
        int ans=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            while(map.size() == count.size()){
                ans += n- i;
                map.put(nums[start],map.get(nums[start])-1);
                if(map.get(nums[start]) == 0)
                    map.remove(nums[start]);
                start++;
            }
        }
        while(map.size() == count.size()){
            ans += 1;
            map.put(nums[start],map.get(nums[start])-1);
            if(map.get(nums[start]) == 0)
                map.remove(nums[start]);
            start++;
        }
        return ans;
    }
}