class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        TreeMap<Character,Integer> map = new TreeMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        // System.out.println(map);
        StringBuilder stb = new StringBuilder();

        while(!map.isEmpty()){
            Character c= map.lastKey();
            for(int i=0;i<Math.min(map.get(c),repeatLimit);i++){
                stb.append(c);
            }
            if(map.get(c) > repeatLimit){
                Character pb = map.floorKey((char)(c-1));
                if(pb == null)
                    break;
                // System.out.println(pb+" "+);
                stb.append(pb);
                map.put(pb,map.get(pb)-1);
                if(map.get(pb) == 0)
                    map.remove(pb);
            }
            map.put(c,map.get(c) - Math.min(map.get(c),repeatLimit) );
            if(map.get(c) == 0)
                map.remove(c);
        }
        return stb.toString();
    }
}