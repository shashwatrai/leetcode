class Solution {
    public int precedence(char c){
        if(c == '(')
            return -1;
        else if(c == '-' ||  c == '+')
            return 0;
        else if( c == '*' ||  c == '/')
            return 1;
        return -10;
    }
    public String evaluate(Integer a, Integer b,Character c){
        if(c == '-')
            return Integer.valueOf(a-b).toString();
        else if(c == '+')
            return Integer.valueOf(a+b).toString();
        else if(c == '*')
            return Integer.valueOf(a*b).toString();
        else 
            return Integer.valueOf(a/b).toString(); 
    }
    public int calculate(String s) {
        
        Stack<String> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        StringBuilder stb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            System.out.println(st1+"|"+st2);
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                stb.append(s.charAt(i));
            }else if(s.charAt(i) == '('){
                st1.push(s.substring(i,i+1));
                st2.push(s.charAt(i));
            }else{
                if(stb.length() > 0){
                    st1.push(stb.toString());
                    stb.setLength(0);
                }
                if(s.charAt(i) == ')'){
                    while(!st1.peek().equals("(")){
                        Integer b = Integer.parseInt(st1.pop());
                        if(st1.peek().equals("(")){
                            st1.pop();
                            st2.pop();
                            st1.push(b.toString());
                            break;
                        }
                        Integer a = Integer.parseInt(st1.pop());
                        Character op = st2.pop();
                        
                        st1.push(evaluate(a,b,op));
                    }
                }else{
                    if(st2.isEmpty()){
                        st2.push(s.charAt(i));
                    }else{
                       
                        while(!st2.isEmpty() && precedence(st2.peek()) >= precedence(s.charAt(i)) ){
                           
                            Integer b = Integer.parseInt(st1.pop());
                            Integer a = Integer.parseInt(st1.pop());
                            Character op = st2.pop();
                            st1.push(evaluate(a,b,op));
                        }
                        st2.push(s.charAt(i));
                    }   
                }
            }
        }
        if(stb.length() > 0)
            st1.push(stb.toString());
       
        while(!st2.isEmpty()){
             System.out.println(st1+"|"+st2);
            Integer b = Integer.parseInt(st1.pop());
            Integer a = Integer.parseInt(st1.pop());
            Character op = st2.pop();
            st1.push(evaluate(a,b,op));
        }

        return Integer.parseInt(st1.pop());
    }
}