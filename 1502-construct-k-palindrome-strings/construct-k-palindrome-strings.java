class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k)
            return false;

        int []arr = new int[26];

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i) - 'a']++;
        }

        int cnt=0;
        for(int i:arr){
            if(i%2 == 1)
                cnt++;
        }

        if(cnt > k)
            return false;

        return true;
    }
}