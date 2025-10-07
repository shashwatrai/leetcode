class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        Map<Integer,Integer> map = new HashMap<>();

        TreeSet<Integer> tSet = new TreeSet<>();

        int []ans = new int[n];

        Arrays.fill(ans,-1);

        for(int i=0;i<n;i++){
            if(rains[i] == 0){
                tSet.add(i);
            }else{
                if(!map.containsKey(rains[i])){
                    map.put(rains[i],i);
                }else{
                    Integer d = tSet.ceiling(map.get(rains[i]));
                    if(d == null)
                        return new int[0];
                    
                    map.put(rains[i],i);
                    ans[d] = rains[i];
                    tSet.remove(d);
                }
            }
        }
        for(int i:tSet)
            ans[i] = 1;
        return ans;
    }
}