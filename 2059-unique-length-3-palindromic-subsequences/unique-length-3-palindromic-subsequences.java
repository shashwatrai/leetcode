class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();

        int start[] = new int[26];
        int end[] = new int[26];
        Arrays.fill(start,Integer.MAX_VALUE);
        Arrays.fill(end,Integer.MIN_VALUE);
        for(int i=0;i<n;i++){
            start[s.charAt(i) - 'a'] = Math.min(start[s.charAt(i) - 'a'],i);
            end[s.charAt(i) - 'a'] = Math.max(end[s.charAt(i) - 'a'],i);
        }
        int ans=0;
        for(int i=0;i<26;i++){

            if(start[i] < end[i]){
                Set<Character> set = new HashSet<>();
                for(int j=start[i]+1;j<end[i];j++){
                    set.add(s.charAt(j));
                }
                ans += set.size();
            }
        }
        return ans;
    }
}