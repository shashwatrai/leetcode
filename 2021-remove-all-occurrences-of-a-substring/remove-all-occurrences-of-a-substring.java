class Solution {
    public int[] process(String part){
        int n = part.length();
        int pi[] = new int[n];

        int k = -1;
        pi[0] = -1;
        for(int i=1;i<n;i++){
            while(k!= -1 && part.charAt(i) != part.charAt(k+1)){
                k = pi[k];
            }

            if(part.charAt(i) == part.charAt(k+1))
                k++;
            pi[i] = k;
        }
        return pi;
    }
    public String removeOccurrences(String s, String part) {
        int pi[] = process(part);
        int iArr[] = new int[s.length()];
        char cArr[] = new char[s.length()];

        int l=-1,k=-1;
        for(int i=0;i<cArr.length;i++){
            System.out.println(l+" "+k+" "+i);
            while(k!= -1 && part.charAt(k+1) != s.charAt(i)){
                k = pi[k];
            }

            if(part.charAt(k+1) == s.charAt(i))
                k++;
            cArr[++l] = s.charAt(i);
            iArr[l] = k;
            if(k == part.length()-1){
                l -=k+1;
                if(l!=-1)
                    k = iArr[l];
                else
                    k = -1;
            }
        }
        StringBuilder stb = new StringBuilder();
        for(int i=0;i<=l;i++)
            stb.append(cArr[i]);
        return stb.toString();
    }
}