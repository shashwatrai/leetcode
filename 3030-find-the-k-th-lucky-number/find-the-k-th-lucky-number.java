class Solution {
    public String kthLuckyNumber(int k) {
        k++;
        StringBuilder stb = new StringBuilder();

        while(k>1){
            if((k&1) == 1)
                stb.append("7");
            else
                stb.append("4");
            k >>= 1;
        }
        return stb.reverse().toString();
    }
}
