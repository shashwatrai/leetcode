class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<sources.length;i++){
            if(s.startsWith(sources[i],indices[i])){
                map.put(indices[i],i);
            }
        }
        StringBuilder stb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(i)){
                stb.append(targets[map.get(i)]);
                i+=sources[map.get(i)].length()-1;
            }else
                stb.append(s.charAt(i));
        }
        return stb.toString();
    }
}