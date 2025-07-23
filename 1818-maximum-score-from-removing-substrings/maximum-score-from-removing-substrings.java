class Solution {

    public char getOther(char c){
        if(c == 'a')
            return 'b';
        else
            return 'a';
    }

    public int getScore(char c,int x,int y){
        if(c == 'a')
            return y;
        else
            return x;
    }

    public Map<String,Integer> getAnswer(String s, char c,int x,int y){
        Stack<Character> st = new Stack<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && s.charAt(i) == c && st.peek() == getOther(c)){
                st.pop();
                ans+= getScore(c,x,y);
            }else
                st.push(s.charAt(i));
        }
        StringBuilder stb = new StringBuilder();
        while(!st.isEmpty()){
            stb.append(st.pop());
        }
        Map<String, Integer> resp = new HashMap<>();
        resp.put(stb.reverse().toString(),ans);
        return resp;
    }
    public int maximumGain(String s, int x, int y) {
       
        Character c = 'b';
        
        if(y > x)
            c = 'a';

        Map<String,Integer> resp= getAnswer(s,c,x,y);
        
        int ans = 0;
        c = getOther(c);
        for(String t: resp.keySet()){
            ans += resp.get(t);
            Map<String,Integer> resp2 = getAnswer(t,c,x,y);
            for(String l : resp2.keySet())
                ans += resp2.get(l);
        }
        
        return ans;
    }
}
