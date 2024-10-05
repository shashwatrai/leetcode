class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int freqS1[] = new int[26];
        int freqS2[] = new int[26];

        for(int i=0;i<s1.length();i++){
            freqS1[s1.charAt(i) - 'a']++;
            freqS2[s2.charAt(i) - 'a']++;
        }
        int count=0;
        for(int i=0;i<freqS1.length;i++){
            if(freqS1[i] == freqS2[i]){
                count++;
            }
        }

        for(int i=0;i<s2.length()-s1.length();i++){
            // System.out.println(Arrays.toString(freqS1) + "\n"+ Arrays.toString(freqS2) +"\n" + count +"\n"); 
            if(count == 26)
                return true;

            freqS2[s2.charAt(i+s1.length()) - 'a']++;
            

            if(freqS1[s2.charAt(i+s1.length()) - 'a'] == freqS2[s2.charAt(i+s1.length()) - 'a'])
                count++;
            else if(freqS1[s2.charAt(i+s1.length()) - 'a'] + 1 == freqS2[s2.charAt(i+s1.length()) - 'a'])
                count--;

            freqS2[s2.charAt(i) - 'a']--;

            if(freqS1[s2.charAt(i) - 'a']  - 1 == freqS2[s2.charAt(i) - 'a'])
                count--;
            else if(freqS1[s2.charAt(i) - 'a']  == freqS2[s2.charAt(i) - 'a'])
                count++;

        }
        if(count == 26)
            return true;
        return false;
    }
}