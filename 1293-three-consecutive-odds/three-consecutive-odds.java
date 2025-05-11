class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int len  = 0;

        for(int i=0;i<arr.length;i++){
            if(len == 3)
                return true;
            if(arr[i]%2 == 0)
                len = 0;
            else
                len++;
        }
        return len==3;
    }
}