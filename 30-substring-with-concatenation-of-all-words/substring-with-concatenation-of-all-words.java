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
        for(int l=0;l< len;l++){
            count=0;
            map = new HashMap<>();
            int start = l;
            for(int i=l;i<s.length();i+=len){
                if(i+len > s.length())
                    break;
                String curr = s.substring(i,i+len);

                map.put(curr,map.getOrDefault(curr,0)+1);
                if(!allStrings.containsKey(curr)){
                    map = new HashMap<>();
                    count=0;
                    start = i+len;
                    continue;
                }else if(allStrings.get(curr) < map.get(curr)){
                    while(allStrings.get(curr) < map.get(curr)){
                        String del = s.substring(start,start+len);
                        map.put(del,map.get(del) - 1);
                        start += len;
                        count--;
                    }
                    count++;
                }else{
                    count++;
                }

                if(count == words.length){
                    res.add(start);
                    String del = s.substring(start,start+len);
                    map.put(del,map.get(del) - 1);
                    start += len;
                    count--;
                }
            
            }
            
        }
        return res;
    }
}