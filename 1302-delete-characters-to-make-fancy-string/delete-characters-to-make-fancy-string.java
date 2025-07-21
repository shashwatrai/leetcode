class Solution {
    public String makeFancyString(String s) {
        StringBuilder stb = new StringBuilder();

        char prev = '-';
        int prevCount =0 ;
        for(int i=0;i<s.length();i++){
            if(prev == s.charAt(i)){
                prevCount++;
                if(prevCount < 3){
                    // System.out.println(prev+" "+s.charAt(i)+" "+prevCount);
                    stb.append(s.charAt(i));
                }
            }else{
                
                stb.append(s.charAt(i));
                prev = s.charAt(i);
                prevCount = 1; 
            }
        }
        return stb.toString();
    }
}