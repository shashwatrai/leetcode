class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int len = s.length()+1;
        int count=0;
        int start = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1')
                count++;

            while(count == k){
                len = Math.min(len, i-start+1);
                if(s.charAt(start) == '1')
                    count--;
                start++;
            }
        }
        if(len == s.length()+1)
            return "";
        char []temp = new char[len];
        Arrays.fill(temp,'1');

        String ans = new String(temp);

        for(int i=0;i<=s.length()-len;i++){
            String tempStr = s.substring(i,i+len);
            int count1 =0 ;
            for(int j=0;j<len;j++){
                if(tempStr.charAt(j) == '1')
                    count1++;
            }
            
            if(count1 != k)
                continue;
            // System.out.println(count1+" "+ans+" "+tempStr);
            if(ans.compareTo(tempStr) > 0)
                ans = tempStr;
        }
        return ans;
    }
}