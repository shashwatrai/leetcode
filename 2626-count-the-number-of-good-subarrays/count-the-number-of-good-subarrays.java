class Solution {
    public long countGood(int[] nums, int k) {
        long count =0L ;
    long ans = 0L;
    int end=0;
    Map<Integer,Long> map = new HashMap<>();
    int n= nums.length;
    for(int i=0;i<n;i++){
        count += map.getOrDefault(nums[i],0L);
        map.put(nums[i],map.getOrDefault(nums[i],0L)+1L);


        while(end < i && count >= k){
            ans += n - i;
            // System.out.println(end+" "+map);
            count -= map.get(nums[end]) - 1;
            map.put(nums[end],map.get(nums[end])-1L);
            if(map.get(nums[end]) == 0)
                map.remove(nums[end]);
            end++;
        }
    }
    return ans;
    }
}