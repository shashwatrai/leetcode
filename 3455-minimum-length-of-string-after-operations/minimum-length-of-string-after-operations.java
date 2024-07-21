class Solution {
    public int minimumLength(String s) {
        int []cnt = new int[26];
        for(int i=0;i<s.length();i++){
            cnt[s.charAt(i)-'a']++;
        }
        
        int length =0 ;
        for(int i:cnt){
            if(i>0){
                if(i < 3)
                    length+=i;
                else{
                    length += (i%2 ==0 ? 2:1);
                }
            }

        }
        return length;
    }
}