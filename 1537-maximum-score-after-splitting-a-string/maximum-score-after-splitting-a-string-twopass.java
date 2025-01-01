class Solution {
    public int maxScore(String s) {
        int a =0;
        int b =0;

        int n = s.length();

        int max =0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1')
                b++;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == '0')
                a++;
            else
                b--;
            max = Math.max(a+b,max);
        }
        return max;
    }
}
