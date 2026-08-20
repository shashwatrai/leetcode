class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

        for(int i[]:reservedSeats){
            if(!map.containsKey(i[0]))
                map.put(i[0], new TreeSet<>());
            map.get(i[0]).add(i[1]);
        }

        int last = 0;
        int ans  = 0;
        for(int curr : map.keySet()){
            ans += 2 * (curr - last - 1);
            TreeSet<Integer> temp = map.get(curr);
            boolean look = true;
            if(!temp.contains(2) && !temp.contains(3) && !temp.contains(4) && !temp.contains(5)) {
                ans += 1;
                look = false;
            }
            boolean nextLook = true;
            if(look && !temp.contains(4) && !temp.contains(5) && !temp.contains(6) && !temp.contains(7)) {
                ans += 1;
                nextLook = false;
            }

            if(nextLook && !temp.contains(6) && !temp.contains(7) && !temp.contains(8) && !temp.contains(9)) {
                ans += 1;
            }
            last = curr;
        }
        ans += (n - last) * 2;
        return ans;
    }
}