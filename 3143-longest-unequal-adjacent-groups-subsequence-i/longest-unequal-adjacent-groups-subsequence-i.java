class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<groups.length;i++){
            while(!st.isEmpty() && groups[st.peek()] == groups[i]){
                st.pop();
            }
            st.push(i);
        }
        List<String> res = new ArrayList<>();
        while(!st.isEmpty()){
            res.add(words[st.pop()]);
        }
        Collections.reverse(res);
        return res;
    }
}