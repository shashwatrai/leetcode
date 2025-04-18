class Solution {
    public String countAndSay(int n) {

        String curr = "1";
        for(int i=1;i<n;i++){
            StringBuilder temp = new StringBuilder();
            int cnt =0 ;
            char c='-';
            for(int j =0 ;j<curr.length();j++){
                if(cnt == 0){
                    cnt++;
                    c = curr.charAt(j);
                }else if(c == curr.charAt(j))
                    cnt++;
                else{
                    temp.append(Integer.valueOf(cnt).toString());
                    temp.append(c);
                    cnt = 1;
                    c = curr.charAt(j);
                }
            }
            temp.append(Integer.valueOf(cnt).toString());
            temp.append(c);
            curr = temp.toString();
        }
        return curr;
    }
}