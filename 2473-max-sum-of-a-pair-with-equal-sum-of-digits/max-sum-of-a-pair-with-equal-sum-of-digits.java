class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer,TreeSet<Integer>> map = new HashMap<>();

        for(int j=0;j<nums.length;j++){
            int s=0;
            int i = nums[j];
            while(i > 0){
                s += i%10;
                i/=10;
            }
            if(!map.containsKey(s)){
                map.put(s,new TreeSet<>((a,b)->nums[b]!=nums[a] ? nums[b]-nums[a]:b-a));
            }
            map.get(s).add(j);
        }
        // System.out.println(map);
        int max = Integer.MIN_VALUE;
        for(int k:map.keySet()){
            if(map.get(k).size() > 1){
                int a = map.get(k).first();
                map.get(k).remove(a);
                int b = map.get(k).first();
                map.get(k).remove(b);
                max = Math.max(max,nums[a]+nums[b]);
            }
        }
        return max != Integer.MIN_VALUE? max:-1;
    }
}