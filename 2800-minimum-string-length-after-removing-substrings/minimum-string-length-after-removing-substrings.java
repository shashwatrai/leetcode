class Solution {
    public int minLength(String s) {
        
        String prev="";
        while(prev.length() != s.length()){
            prev = s;
            s  = s.replaceAll("AB","");
            s = s.replaceAll("CD","");

        }
        return prev.length();
    }
}