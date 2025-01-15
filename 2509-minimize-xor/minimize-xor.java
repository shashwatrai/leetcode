class Solution {
    public int minimizeXor(int num1, int num2) {
        
        int n = Integer.bitCount(num2);

        int len = Integer.toBinaryString(num1).length();

        int res =0;
        
        while(len > 0 && n > 0){
            int isSet = num1 & (1 << (len-1));
            System.out.println(isSet);
            if(isSet != 0){
                res |= (1 << (len-1));
                n--;
            }
            len--;
        }
        System.out.println(n +" "+len+" "+res);
        if(n > 0){
            while(n > 0){
                int isSet = res & (1 << (len));
                if(isSet == 0){
                    res |= (1 << (len));
                    n--;
                }
                len++;
            }
        }
        return res;
    }
}