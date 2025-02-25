class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int evenTN , oddTN, totalOdd;
        int dp[][] = new int[n][3];
        int R = (int)1e9 + 7;
        if(arr[0]%2 == 0){
            evenTN = 1;
            oddTN = 0;
            totalOdd = 0;
        }else{
            evenTN = 0;
            oddTN = 1;
            totalOdd = 1;
        }
        for(int i=1;i<n;i++){
            if(arr[i]%2 == 0){
                evenTN = (evenTN + 1)%R;
                oddTN = oddTN;
                totalOdd = (totalOdd%R + oddTN%R)%R;
            }else{
                int temp = evenTN;
                evenTN = oddTN;
                oddTN = (temp + 1)%R;
                totalOdd = (totalOdd%R + oddTN%R)%R;
            }
        }
        return totalOdd;
    }
}