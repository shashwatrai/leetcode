class Solution {
    public char kthCharacter(long k, int[] operations) {
        int indx = (int)Math.ceil(Math.log(k)/Math.log(2));
        long p = (long)Math.pow(2L,(long)indx);
        int ans =0;
        while(indx > 0){
            long h = (p/2L);
            // System.out.println(k+" "+p+" "+h+" "+indx);
            if(k > h){
                if( operations[indx-1] == 1)
                    ans++;
                k -= h;
            }
            
            p = h;
           
            indx--;
        }
        return (char)('a'+ans%26);
    }
}