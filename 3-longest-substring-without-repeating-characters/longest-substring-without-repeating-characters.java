class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character , Integer> map = new HashMap<>();

        int start = -1;
        int ans =0;
        for(int i=0;i<s.length();i++){
            if(map.getOrDefault(s.charAt(i),-2) >= start){
                ans = Math.max(ans,i-start-1);
                start = map.get(s.charAt(i));
            }
            map.put(s.charAt(i),i);
        }
        ans = Math.max(ans,s.length()-start-1);
        return ans;
    }
}