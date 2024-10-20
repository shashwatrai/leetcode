class Solution {

    public void helper(int []nums,int indx,Map<Integer,Integer> map){

        if(indx == nums.length){
            return;
        }
        helper(nums,indx+1,map);

        Map<Integer,Integer> map2 = new HashMap<>();
        map2.put(nums[indx],1);
        for(int i:map.keySet()){

            map2.put( nums[indx]|i,map2.getOrDefault( nums[indx]|i,0) + map.get(i));
        }
        map2.forEach((key,value) -> {
            map.merge(key,value, (v1,v2) -> v1+v2);
        });
        return ;
    }

    public int countMaxOrSubsets(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
       
        int max = 0;
        for(int i:nums){
            max |= i;
        }
        helper(nums,0,map);
        return map.getOrDefault(max,0);
    }
}