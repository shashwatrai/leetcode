class Solution {
    public String kthLuckyNumber(int k) {

        int n = (int)Math.floor(Math.log(k+1)/Math.log(2));
        

        
        k  =  k  + 1 - (int) Math.pow(2,n);


        System.out.println(n+" "+k+" "+(Math.log(k+2)/Math.log(2)));
        StringBuilder stb = new StringBuilder();

        for(int i=0;i<n;i++){
            if((k&1) == 1)
                stb.append("7");
            else
                stb.append("4");
            k >>=1;
        }
        return stb.reverse().toString();
    }
}

