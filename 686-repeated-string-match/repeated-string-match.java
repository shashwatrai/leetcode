class Solution {
    public int[] preprocess(String b){
        int n = b.length();
        int pi[] = new int[n];

        int k =-1;
        pi[0] = -1;

        for(int i = 1;i<n;i++){
            while(k > -1 && b.charAt(i) != b.charAt(k+1))
                k = pi[k];
            if(b.charAt(i) == b.charAt(k+1))
                k++;
            pi[i] = k ;
        }
        return pi;
    }
    public int repeatedStringMatch(String a, String b) {
        int []pi = preprocess(b);

        int n = a.length();
        int k = -1;
        int maxK = -1;
        for(int i=0;;i++){
            while(k > -1 && a.charAt(i%n) != b.charAt(k+1) )
                k  = pi[k];
            if(a.charAt(i%n) == b.charAt(k+1))
                k++;

            // System.out.println(i+" "+k+" "+maxK);
            if(i >2* n && (maxK == -1 || k <= maxK))
                return -1;
            if(i >= n-1)
                maxK = Math.max(k,maxK);
            if( k == b.length()-1)
                return (int)Math.ceil((double)(i+1)/n);
        }
        // return -1;
    }
}