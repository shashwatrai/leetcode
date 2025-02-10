class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        boolean []arr = new boolean[n];

        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(Character.isDigit(s.charAt(i))){
                int indx = st.pop();
                arr[indx] = true;
                arr[i] = true;
            }else{
                st.push(i);
            }
        }
        StringBuilder stb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(!arr[i])
                stb.append(s.charAt(i));
        }
        return stb.toString();
    }
}