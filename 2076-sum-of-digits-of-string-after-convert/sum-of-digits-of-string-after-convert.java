class Solution {
    String transform(String num){
        int res =0;
        for(int c:num.toCharArray()){
            res += (c-'0');
        }
        return Integer.valueOf(res).toString();
    }
    public int getLucky(String s, int k) {
        String num = "";

        for(char c: s.toCharArray()){
            int res = c-'a'+1;

            num += res;
        }
        String finalAns  = num;
        System.out.println(num);
        while(k-- > 0){
            finalAns =  transform(finalAns);
            
        }
        return Integer.parseInt(finalAns);
    }
}