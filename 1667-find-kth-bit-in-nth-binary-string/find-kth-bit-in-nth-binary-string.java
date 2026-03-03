class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1)
            return '0';
        int middle = (int)Math.pow(2,n-1);
        if(middle == k){
            return '1';
        }

        char lastBit = findKthBit(n-1,k < middle?k:2*middle-k);
        return k < middle ? lastBit : (char)('0' + '1' - lastBit);
    }
}