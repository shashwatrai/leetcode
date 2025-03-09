class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {

        int n = colors.length;
        int cnt=0;
        int start = 0,end=0;

        while(start < n){
            if(end == start || (end > start && colors[end%n] != colors[(end-1)%n] ))
                end++;
            else{
                start = end;
            }
            if(end- start == k){
                // System.out.println(start+" "+end);
                cnt++;
                start++;
            }
        }   
        return cnt;
    }
}