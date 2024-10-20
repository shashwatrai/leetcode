class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st1 = new Stack<>();

        Stack<Character> st2 = new Stack<>();

        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i) == ',')
                continue;
            else if(expression.charAt(i) == '!' || expression.charAt(i) == '|' 
            || expression.charAt(i) == '&'){
                st2.push(expression.charAt(i));
            }else if(expression.charAt(i) == ')'){
                List<Character> operands = new ArrayList<>();
                Character operators = null;
                while(st1.peek() != '('){
                    operands.add(st1.pop());
                }
                st1.pop();
                if(!st2.isEmpty() ){
                    operators = st2.pop();
                }

                    
                if(operators == '!'){
                    st1.push(operands.get(0) == 't' ?'f':'t');
                }else if(operators == '|'){
                    char res = 'f';
                    for(char c:operands){
                        if(c == 't'){
                            res = 't';
                            break;
                        }
                    }
                    st1.push(res);
                }else{
                    char res = 't';
                    for(char c:operands){
                        if(c == 'f'){
                            res = 'f';
                            break;
                        }
                    }
                    st1.push(res);
                }  
            }else{
                    st1.push(expression.charAt(i));
            }
        }
        
        return st1.peek() == 't'?true:false;
    }
}