class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();

        int j = 0;
        for(int i=0;i<s.length();){
            while(j < s.length() && s.charAt(j) == s.charAt(i))
                j++;
            map.put(s.substring(i,j),map.getOrDefault(s.substring(i,j),0)+1);
            i = j;
        }

        int ans = -1;
        for(String t: map.keySet()){
            if(map.get(t) >= 3){
                ans = Math.max(ans,t.length());
            }else if(t.length() > 1 && (map.get(t) == 2  || map.containsKey(t.substring(0,t.length()-1)) )){
                ans = Math.max(ans,t.length()-1);
            }else if(t.length() > 2 && (map.get(t) == 1 || map.containsKey(t.substring(0,t.length()-2)) )){
                ans = Math.max(ans,t.length()-2);
            }
            
        }
        return ans;
    }
}