class Solution {
    public int reverse(int x) {
        int res =0;
    
        while(x != 0){
            int lastDigit = x%10;

            if(res > Integer.MAX_VALUE/10 || ( Integer.MAX_VALUE/10  == res && lastDigit > 7 ))
                return 0;
            if(Integer.MIN_VALUE/10 > res  || Integer.MIN_VALUE/10 == res && lastDigit < -8)
                return 0;

            res = res  * 10 + lastDigit;
            x/=10;
        }
        return res;
    }
}