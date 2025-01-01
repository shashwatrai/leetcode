class Solution {
    public int maxScore(String s) {
        int a =0;
        int b =0;
        int n = s.length();
        int max =Integer.MIN_VALUE;

        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == '0')
                a++;
            else
                b++;
            max = Math.max(2*a-i-1,max);
        }
        if(s.charAt(n-1) == '1')
                b++;

        return max+b;
    }
}