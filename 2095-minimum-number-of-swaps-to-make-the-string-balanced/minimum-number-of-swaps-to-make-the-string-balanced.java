class Solution {
    public int minSwaps(String s) {
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(cnt > 0 && s.charAt(i) == ']')
                cnt--;
            else if(s.charAt(i) == '[')
                cnt++;
        }
        return (cnt+1)/2;
    }
}