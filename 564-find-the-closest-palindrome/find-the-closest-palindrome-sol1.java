class Pair{
    String ans;
    Long diff ;
    Pair(String r,Long d){
        ans =r;
        diff =d;
    }
}
class Solution {
    public void helper(String orig,String half,Pair pair){
        if(half.equals("0") && orig.length() > 1)
            half ="";
        String ans = half;
        Long  diff = pair.diff;
        if(half.length()* 2 == orig.length()){
            for(int i=half.length()-1;i>=0;i--){
                ans += half.charAt(i);
            }
            
            if(diff > Math.abs(Long.valueOf(ans)-Long.valueOf(orig))){
                pair.diff =  Math.abs(Long.valueOf(ans)-Long.valueOf(orig));
                pair.ans =  Long.valueOf(ans).toString();
            }else if(diff == Math.abs(Long.valueOf(ans)-Long.valueOf(orig)) && Long.valueOf(ans)<Long.valueOf(orig)){
                pair.ans= Long.valueOf(ans).toString();
            }
        }else if(half.length()* 2 == 1 + orig.length()){
            for(int i=orig.length()-1 - half.length();i>=0;i--){
                ans += half.charAt(i);
            }
           
            if(diff > Math.abs(Long.valueOf(ans)-Long.valueOf(orig))){
                pair.diff =  Math.abs(Long.valueOf(ans)-Long.valueOf(orig));
                pair.ans= Long.valueOf(ans).toString();
            }else if(diff == Math.abs(Long.valueOf(ans)-Long.valueOf(orig)) && Long.valueOf(ans)<Long.valueOf(orig)){
                pair.ans= Long.valueOf(ans).toString();
            }
        }else if(half.length()* 2 == 2 + orig.length() || half.length()* 2 == 3 + orig.length()){
            for(int i=orig.length() - half.length();i>=0;i--){
                ans += half.charAt(i);
            }
            
            if(diff > Math.abs(Long.valueOf(ans)-Long.valueOf(orig))){
                pair.diff =  Math.abs(Long.valueOf(ans)-Long.valueOf(orig));
                pair.ans= Long.valueOf(ans).toString();
            }else if(diff == Math.abs(Long.valueOf(ans)-Long.valueOf(orig)) && Long.valueOf(ans)<Long.valueOf(orig)){
                pair.ans= Long.valueOf(ans).toString();
            }
        }else if(half.length()* 2 + 2 == orig.length()){
            ans += "9";
            for(int i=half.length()-1;i>=0;i--){
                ans += half.charAt(i);
            }
            if(diff > Math.abs(Long.valueOf(ans)-Long.valueOf(orig))){
                pair.diff =  Math.abs(Long.valueOf(ans)-Long.valueOf(orig));
                pair.ans= Long.valueOf(ans).toString();
            }else if(diff == Math.abs(Long.valueOf(ans)-Long.valueOf(orig)) && Long.valueOf(ans)<Long.valueOf(orig)){
                pair.ans= Long.valueOf(ans).toString();
            }
        }else{
            for(int i=half.length()-1;i>=0;i--){
                ans += half.charAt(i);
            }
            if(diff > Math.abs(Long.valueOf(ans)-Long.valueOf(orig))){
                pair.diff =  Math.abs(Long.valueOf(ans)-Long.valueOf(orig));
                pair.ans= Long.valueOf(ans).toString();
            }else if(diff == Math.abs(Long.valueOf(ans)-Long.valueOf(orig)) && Long.valueOf(ans)<Long.valueOf(orig)){
                pair.ans= Long.valueOf(ans).toString();
            }
        }
        
    }
    public String nearestPalindromic(String n) {
        String num = n.substring(0,(n.length()+1)/2);
        Integer pNum = Integer.parseInt(num);

        Pair pair = new Pair("", Long.MAX_VALUE);
        helper(n,Integer.valueOf(pNum).toString(),pair);
        if(pair.diff == 0L){
            pair.diff =  Long.MAX_VALUE;
            pair.ans = "";
        }
        helper(n,Integer.valueOf(pNum-1).toString(),pair);
        // System.out.println(pair.ans+" "+pair.diff);
        helper(n,Integer.valueOf(pNum+1).toString(),pair);
        // System.out.println(pair.ans+" "+pair.diff);
        return pair.ans;
    }
}
