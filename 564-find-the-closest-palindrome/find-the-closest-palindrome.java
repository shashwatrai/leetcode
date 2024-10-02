class Solution {

    public String nearestPalindromic(String n) {
        
        int len = n.length();
        TreeSet<Long> set = new TreeSet<>();

        long smallest = (long)Math.pow(10L,len-1) - 1L;
        long largest = (long)Math.pow(10L,len) + 1L;
        set.add(smallest);
        set.add(largest);

        
        StringBuilder stb = new StringBuilder();

        int diff = len%2 == 0 ? 0:1;

        String lS =  Long.valueOf(Long.valueOf(n.substring(0,(len+1)/2)) - 1L).toString();
        stb.append(lS.substring(0,lS.length()-diff));
        set.add(Long.valueOf(lS+stb.reverse().toString()));
        stb.setLength(0);

        String mS =  Long.valueOf(n.substring(0,(len+1)/2)).toString();
        stb.append(mS.substring(0,mS.length()-diff));
        set.add(Long.valueOf(mS+stb.reverse().toString()));
        stb.setLength(0);
    
        String uS =  Long.valueOf(Long.valueOf(n.substring(0,(len+1)/2)) + 1L).toString();
        stb.append(uS.substring(0,uS.length()-diff));
        set.add(Long.valueOf(uS+stb.reverse().toString()));
        stb.setLength(0);
        
        Long num = Long.valueOf(n);
        if(set.contains(num)){
            set.remove(num);
        }
        Long ceil = set.ceiling(num);
        Long floor = set.floor(num);

        if(ceil - num >= num - floor)
            return floor.toString();
        else
            return ceil.toString();

    }
}