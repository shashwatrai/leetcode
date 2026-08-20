class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i[]: reservedSeats){
            map.put(i[0], map.getOrDefault(i[0],0) | ( 1 << i[1]));
        }
        
        int ans = 2 * (n - map.size());
        int comb1 = (1<<2) | (1<<3) | (1<<4) | (1<<5);
        int comb2 = (1<<4) | (1<<5) | (1<<6) | (1<<7);
        int comb3 = (1<<6) | (1<<7) | (1<<8) | (1<<9);
        int comb4 = comb1 | comb3;
        for(int i : map.keySet()){
            int reserved = map.get(i);
            // System.out.println(Integer.toBinaryString(reserved));
            if((reserved & comb4 ) == 0)
                ans += 2;
            else if((reserved & comb1 ) == 0)
                ans += 1;
            else if((reserved & comb2 ) == 0)
                ans += 1;
            else if((reserved & comb3 ) == 0)
                ans += 1;
        }
        return ans;
    }
}