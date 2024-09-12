class Solution {
    public int maximumLength(String s) {
        int max = -1;
        for(char c= 'a';c<='z';c++){
            String temp = "";

            for(int i=1;i<=s.length()-2;i++){
                temp+= c;
                int cnt=0;
                for(int j= 0;j<=s.length()-i;j++){
                    if(s.charAt(j) == temp.charAt(0)){
                        boolean isMatch = true;
                        for(int k = 1;k<i;k++){
                            if(s.charAt(j+k) != temp.charAt(k)){
                                isMatch = false;
                                break;
                            }  
                        }
                        if(isMatch)
                            cnt++;
                    }
                }
                 System.out.println(temp+" "+cnt);
                if(cnt >= 3){
                    System.out.println(temp);
                    max = Math.max(temp.length(),max);
                }
            }
        }
        return max;
    }
}
