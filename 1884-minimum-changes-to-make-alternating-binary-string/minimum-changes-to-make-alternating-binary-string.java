class Solution {
    public int findAnswer(String s, int start){
        int count =0 ;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != (char)('0'+start))
                count++;
            start = 1 - start;
        }
        return count;
    }
    public int minOperations(String s) {
        return Math.min(findAnswer(s,0) , findAnswer(s,1));
    }
}