class Solution {
    Map<String,Boolean> map;
    public boolean solve(String s, List<String> wordDict) {
        if(s.length() == 0)
            return true;
        if(map.containsKey(s))
            return map.get(s);
        for(String i:wordDict){
            if(i.length() <= s.length() && s.startsWith(i) && solve(s.substring(i.length(),s.length()),wordDict)){
                map.put(s,true);
                return true;
            }
        }
        map.put(s,false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0)
            return true;
        map = new HashMap<>();
        solve(s,wordDict);
        return map.get(s);
    }
}