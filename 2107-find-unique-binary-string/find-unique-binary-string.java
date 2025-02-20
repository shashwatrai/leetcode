class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set = new HashSet<>();

        for(String i: nums){
            set.add(Integer.parseInt(i,2));
        }
        int k =  0;
        while(set.contains(k++));
        k--;
        StringBuilder stb = new StringBuilder();
        while(k > 0){
            stb.append((char)('0'+k%2));
            k/=2;
        }
        while(stb.length() < nums.length)
            stb.append('0');
        return stb.reverse().toString();
    }
}