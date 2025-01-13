class Solution {
    public int minimumLength(String s) {
        int []arr = new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i) - 'a']++;
        }

        int len = 0;

        for(int i=0;i<26;i++){
            if(arr[i] > 0){
                if(arr[i]%2 == 0)
                    len+=2;
                else
                    len++;
            }
        }
        return len;
    }
}