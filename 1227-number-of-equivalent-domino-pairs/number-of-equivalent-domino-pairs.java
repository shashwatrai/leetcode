
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();

        for(int i[]:dominoes){
            Arrays.sort(i);
            map.put(Arrays.toString(i),map.getOrDefault(Arrays.toString(i),0)+1);
        }
        int ans=0;
        for(String s: map.keySet()){
            ans += (map.get(s) * (map.get(s)-1))/2;
        }
        return ans;
    }
}