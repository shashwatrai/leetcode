class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        int len = words[0].length();
        Map<String,Integer>  map ;
        Map<String,Integer> allStrings = new HashMap<>();

        for(String i: words){
            allStrings.put(i,allStrings.getOrDefault(i,0)+1);
        }
        StringBuilder stb = new StringBuilder();
        int count=0;
        List<Integer> res = new ArrayList<>();
        if(s.length() < len*words.length)
            return res;
        boolean  vis[] = new boolean[s.length()- len*words.length + 1];
        for(int l=0;l<= s.length()- len*words.length;l++){
            if(vis[l])
                continue;
            stb.setLength(0);
            count=0;
            map = new HashMap<>();
            int start = l;
            for(int i=l;i<s.length();i++){
                stb.append(s.charAt(i));
                if(stb.length() == len){
                    map.put(stb.toString(),map.getOrDefault(stb.toString(),0)+1);
                    if(!allStrings.containsKey(stb.toString()) ||  allStrings.get(stb.toString()) < map.get(stb.toString()))
                        break;
                    count++;
                    stb.setLength(0);
                }

                if(count == words.length &&  stb.length() == 0){
                    res.add(start);
                    String del = s.substring(start,start+len);
                    map.put(del,map.get(del) - 1);
                    vis[start] = true;
                    start += len;
                    count--;
                }
            
            }
            
        }
        return res;
    }
}
