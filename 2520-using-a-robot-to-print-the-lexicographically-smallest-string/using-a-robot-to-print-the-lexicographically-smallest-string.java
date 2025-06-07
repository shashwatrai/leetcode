class Solution {
    public String robotWithString(String s) {
        StringBuilder stb = new StringBuilder();
        int n = s.length();
        int []freq = new int[26];
        int nextSmaller[] = new int[n];
        char smaller = (char)('z'+1);
        int smallerIndx = n+1 ;
        for(int i=n-1;i>=0;i--){
            nextSmaller[i] = smallerIndx;

            if(smaller >= s.charAt(i)){
                smaller = s.charAt(i);
                smallerIndx = i;
            }
            freq[s.charAt(i) - 'a']++;
        }
         
        Stack<Integer> st = new Stack<>();
        int indx = smaller - 'a';
        for(int i=0;i<n;i++){
            st.push(i);
            
            while(!st.isEmpty() && s.charAt(st.peek()) <= (char)(indx + 'a')){
                // System.out.println((char)(indx + 'a'));
                stb.append(s.charAt(st.peek()));
                freq[s.charAt(st.peek())-'a']--;
                
                if(indx < 26){
                   
                
                    int t= st.peek();
                    // System.out.print(t+" "+(char)(indx + 'a')+"--->");
                    do{
                        t = nextSmaller[t];
                    }while(t < n && freq[s.charAt(t) - 'a'] == 0);
                    indx = Math.max(indx,t < n ? s.charAt(t) -'a':26);
                    // System.out.println(t+" " +(char)(indx + 'a'));
                }
                st.pop();
            }

        }
        while(!st.isEmpty())
            stb.append(s.charAt(st.pop()));
        
        return stb.toString();
    }
}