class Solution {
    public boolean findSum(int t,int x,int sum,StringBuilder stb){
        // System.out.println(t+" "+x+" "+sum+" "+stb.reverse().toString());
        if(x == 0){
            int r =0 ;
            if(stb.length() != 0){
                StringBuilder test = new StringBuilder(stb.toString());
                r = Integer.parseInt(test.reverse().toString());
            }
            // System.out.println("["+t+" "+r+" "+sum+" " + stb.reverse().toString()+"]");
            if(sum + r == t)
                return true;
            return false;
        }

        stb.append(x%10);
        boolean ans1 = findSum(t,x/10,sum,stb);
        stb.setLength(stb.length()-1);

        if(ans1)
            return true;
        if(stb.length() != 0){
             StringBuilder test = new StringBuilder(stb.toString());
            int r = Integer.parseInt(test.reverse().toString());
            return findSum(t,x,sum+r,new StringBuilder());
        }
            
        return false;
    }
    public int punishmentNumber(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            
            if(findSum(i,i*i,0,new StringBuilder())){
                // System.out.println(i);
                ans += i*i;
            }
        }
        return ans;
    }
}