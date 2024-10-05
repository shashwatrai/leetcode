class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int []freq = new int[26];

        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i) - 'a']++;
        }

        int []temp = Arrays.copyOf(freq,freq.length);
        
        int start = 0,end=0;
        while(end < s2.length()){
            if(temp[s2.charAt(end) -'a'] == 0 ){
                boolean isFound = true;
                for(int j=0;j<26;j++){
                    if(temp[j] != 0){
                        isFound = false;
                        break;
                    }
                }
                if(isFound)
                    return true;
                // if(freq[s2.charAt(end) - 'a'] != 0){
                    while(start <= end && temp[s2.charAt(end) - 'a'] == 0){
                        if(freq[s2.charAt(start) - 'a'] > 0)
                            temp[s2.charAt(start) - 'a']++;
                        start++;
                    }
                    if(start<=end){
                        temp[s2.charAt(end) -'a']--;
                    }
                // }
                // else{
                //     temp = Arrays.copyOf()
                //     start = end+1;
                // }
            }else{
                temp[s2.charAt(end) -'a']--;
            }
            end++;
        }

        for(int j=0;j<26;j++){
            if(temp[j] != 0){
                return false;
            }
        }
        return true;
    }
}
