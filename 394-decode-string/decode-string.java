class Solution {
    public String decodeString(String s) {
        StringBuilder stb = new StringBuilder();
        Stack<Integer> st2 = new Stack<>();
        Stack<String> st1 = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                int num = 0;
                while(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    // System.out.println(i);
                    num = num*10 + (s.charAt(i)-'0');
                    i++;
                }
                // System.out.println(num);
                st2.push(num);
                i--;
            }else{
                if(s.charAt(i) == ']'){
                    
                    
                    
                    while(!st1.peek().equals("[")){
                        stb.append(st1.pop());
                    }
                    st1.pop();
                    String temp = stb.reverse().toString();
                    stb.setLength(0);
                    int num = st2.pop();
                    while(num-- > 0){
                        stb.append(temp);
                    }
                    st1.push(stb.reverse().toString());
                    stb.setLength(0);
                }else{
                    st1.push(s.substring(i,i+1));
                }
            }
        }

        while(!st1.isEmpty()){
            stb.append(st1.pop());
        }
        return stb.reverse().toString();
    }
}
