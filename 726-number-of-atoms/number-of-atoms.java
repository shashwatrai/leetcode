class Pair{
    String ele;
    Integer count;

    Pair(String e,Integer c){
        ele =e;
        count =c;
    }
}
class Solution {
    public String countOfAtoms(String formula) {
        Stack<String> stack1 = new Stack<>();

        Stack<Integer> stack2 = new Stack<>();

        int indx =0;
        while(indx<formula.length()){
            if(formula.charAt(indx) == '('){
                stack1.push("(");
                stack2.push(0);
            }else if(formula.charAt(indx) == ')'){
                Stack<String> tempStack1 = new Stack<>();
                Stack<Integer> tempStack2 = new Stack<>();
                StringBuilder stb2 = new StringBuilder();
                while(indx + 1 < formula.length() && formula.charAt(indx+1) >= '0' && formula.charAt(indx+1) <= '9'){
                    stb2.append(formula.charAt(indx+1));
                    indx++;
                }
                if(stb2.isEmpty())
                    stb2.append("1");
                Integer mul = Integer.parseInt(stb2.toString());

                while(stack1.peek().compareTo("(") != 0){
                    tempStack1.push(stack1.pop());
                    tempStack2.push(mul * stack2.pop());
                }
                stack1.pop();
                stack2.pop();
                while(!tempStack1.isEmpty()){
                    stack1.push(tempStack1.pop());
                    stack2.push(tempStack2.pop());
                }
            }else{
                StringBuilder stb = new StringBuilder();
                stb.append(formula.charAt(indx));
                while(indx + 1 < formula.length() && formula.charAt(indx+1) >= 'a' && formula.charAt(indx+1) <= 'z'){
                    stb.append(formula.charAt(indx+1));
                    indx++;
                }

                StringBuilder stb2 = new StringBuilder();
                while(indx + 1 < formula.length() && formula.charAt(indx+1) >= '0' && formula.charAt(indx+1) <= '9'){
                    stb2.append(formula.charAt(indx+1));
                    indx++;
                }
                if(stb2.isEmpty())
                    stb2.append("1");
                
                stack1.push(stb.toString());
                stack2.push(Integer.parseInt(stb2.toString()));
                
            }
            indx++;
            
        }

       
        Map<String,Pair> map  = new HashMap<>();
        System.out.println(stack1);
        while(!stack1.isEmpty()){
            if(map.containsKey(stack1.peek())){
                map.get(stack1.pop()).count += stack2.pop();
            }else{
                map.put(stack1.peek(),new Pair(stack1.pop(),stack2.pop()));
            }
        }
        List<Pair> list = new ArrayList<>(map.values());
        Collections.sort(list, (a,b) -> a.ele.compareTo(b.ele));

        StringBuilder res = new StringBuilder();

        for(Pair p :list){
            res.append(p.ele);
            if(p.count > 1){
                res.append(p.count);
            }
        }
        return res.toString();
    }
}