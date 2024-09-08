class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int len=0,start=0,end = 1;
        for(int i=0;i<n;i++) {
            int x=i,y=i;
            while(x >= 0 && y<n){
                if(s.charAt(x) != s.charAt(y)){
                    if(len < y-x-1){
                        len = y-x-1;
                        start = x+1;
                        end = y;
                    }
                    break;
                }
                x--;
                y++;
            }
            if(x == -1 || y == n){
                if(len < y-x-1){
                        len = y-x-1;
                        start = x+1;
                        end = y;
                    }
            }
        }

        for(int i=0;i<n-1;i++) {
            int x=i,y=i+1;
            while(x >= 0 && y<n){
                if(s.charAt(x) != s.charAt(y)){
                    if(len < y-x-1){
                        len = y-x-1;
                        start = x+1;
                        end = y;
                    }
                    break;
                }
                x--;
                y++;
            }
            if(x == -1 || y == n){
                if(len < y-x-1){
                        len = y-x-1;
                        start = x+1;
                        end = y;
                    }
            }
        }

        return s.substring(start,end);
    }
}