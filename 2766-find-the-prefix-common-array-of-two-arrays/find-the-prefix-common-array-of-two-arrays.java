class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int C[] = new int[n];
        int D[] = new int[n+1];
        for(int i=0;i<n;i++){
            D[A[i]]++;
            D[B[i]]++;

            if(D[A[i]]%2 == 0)
                C[i]++;
            if(D[B[i]]%2 == 0)
                C[i]++;
            
            if(A[i] == B[i])
                C[i]--;
            if(i > 0)
                C[i] += C[i-1];
        }
        return C;
    }
}