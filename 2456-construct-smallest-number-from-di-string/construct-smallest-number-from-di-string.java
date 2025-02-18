class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> stack = new Stack<>();

        char arr[] = new char[pattern.length()+1];
        int curr=1;

        for(int i=0;i<pattern.length();i++){
            if(pattern.charAt(i) == 'I'){
                arr[i] = (char)('0' + curr++);
                while(!stack.isEmpty()){
                    arr[stack.pop()] =  (char)('0' + curr++);
                }
            }else
                stack.push(i);
        }
        arr[pattern.length()] =  (char)('0' + curr++);
        while(!stack.isEmpty()){
            arr[stack.pop()] =  (char)('0' + curr++);
        }
        return new String(arr);
    }
}