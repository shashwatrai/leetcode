class Solution {
    public int minimizeXor(int num1, int num2) {
        int n = Integer.bitCount(num2);

        
        char []arr = new char[32];
        Arrays.fill(arr,'0');
        char num1BS[] = Integer.toBinaryString(num1).toCharArray();
        for(int i =0;i < num1BS.length;i++){
            arr[31-i] = num1BS[num1BS.length - i - 1];
        }
        // System.out.println(n+" "+ Arrays.toString(num1BS) +" "+Arrays.toString(arr));
        int indx=32 - Math.max(num1BS.length,Integer.toBinaryString(num2).length());
        for(;indx<arr.length && n>0;indx++){
            if(arr[indx] == '1')
                n--;
        }
        // System.out.println(indx+" "+ Arrays.toString(num1BS) +" "+Arrays.toString(arr));
        if(n == 0){
            while(indx < arr.length){
                arr[indx++] ='0';
            }
        }else{
            for(indx = arr.length-1;indx > 0 && n > 0;indx--){
                if(arr[indx] == '0'){
                    arr[indx] = '1';
                    n--;
                }
            }
        }
        // System.out.println(n+" "+ Arrays.toString(num1BS) +" "+Arrays.toString(arr));
        return Integer.parseInt(new String(arr),2);
    }
}