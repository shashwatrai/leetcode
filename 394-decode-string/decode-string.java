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
                    
                    String temp ="";
                    while(!st1.peek().equals("[")){
                        temp = st1.pop()+temp;
                    }
                    st1.pop();
                    
                    int num = st2.pop();
                    // System.out.println(st1+"|"+st2+"|"+temp+"|"+num);
                    while(num-- > 0){
                        stb.append(temp);
                    }
                    st1.push(stb.toString());
                    stb.setLength(0);
                }else{
                    st1.push(s.substring(i,i+1));
                    // System.out.println("test"+st1+"|"+s.substring(i,i+1));
                }
            }
        }
        String ans="";
        while(!st1.isEmpty()){
            ans = st1.pop() + ans;
        }
        return ans;
    }
}
