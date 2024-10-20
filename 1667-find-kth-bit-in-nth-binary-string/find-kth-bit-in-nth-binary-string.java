class Solution {
    public char findKthBit(int n, int k) {
        
        int l = (int)Math.pow(2,n)-1;
        
        if(l == 1){
            return '0';
        }else if((l+1)/2  == k){
            return '1';
        }else if( k > (l+1)/2){
            char res = findKthBit(n,l+1-k);
            return res =='0' ? '1':'0';
        }else {
            int newN = (int)Math.ceil(Math.log(k+1)/Math.log(2));
            return findKthBit(newN,k);
        }
    }
}