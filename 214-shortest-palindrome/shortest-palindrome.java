class Solution {
    public String shortestPalindrome(String s) {
        if(s.isEmpty())
            return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String newString  = s+"+"+sb.reverse().toString();

        int n = newString.length();
        int []arr = new int[n];
        int k=-1;
        arr[0] = -1;
        for(int i=1;i<n;i++){
            while(k> -1 && newString.charAt(k+1) != newString.charAt(i)){
                k  = arr[k];
            }
            if(newString.charAt(i) == newString.charAt(k+1)){
                k = k+1;
            }
            arr[i] = k;
        }
        sb.setLength(0);
        return sb.append(s.substring(arr[n-1]+1)).reverse().toString()+s;
    }
}