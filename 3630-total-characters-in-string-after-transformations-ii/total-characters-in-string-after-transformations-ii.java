class Solution {
    public long[][] mul(long a[][],long b[][]){
        long R = (long)1e9+7;
        long c[][] = new long[a.length][b[0].length];
        for(int i=0;i<c.length;i++){
            for(int j=0;j<b[0].length;j++){
                for(int k = 0;k<c.length;k++){
                    c[i][j] = (c[i][j]%R + ((a[i][k]%R) * (b[k][j]%R))%R)%R;
                }
            }
        }
        return c;
    }
    public long[][] power(long arr[][],int t){
        long res[][] = new long[26][26];
        for(int i=0;i<26;i++)
            res[i][i] = 1L;

        while(t > 0){
            if(t%2 == 1){
                res = mul(arr,res);
            }
            t /= 2;
            arr = mul(arr,arr);
        }
        return res;
    }
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long [][]adj = new long[26][26];

        for(int i=0;i<26;i++){
            for(int j= i+1;j<=i+nums.get(i);j++)
                adj[i][j%26] = 1L;
        }

        adj = power(adj,t);
        // for(long i[]:adj)
        //     System.out.println(Arrays.toString(i));
        long identity[][] = new long[26][1];
        for(int i=0;i<26;i++)
            identity[i][0] = 1L;
        long ans[][] =mul(adj,identity);
        // for(long i[]:ans)
        //     System.out.println(Arrays.toString(i));
        long freq[] = new long[26];
        for(int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']++;
        
        long R = (long)1e9+7;
        // for(long i[]:ans)
        //     System.out.println(Arrays.toString(i));
        long res = 0L;
        for(int i=0;i<26;i++)
            res = (res%R + ((freq[i]%R) * (ans[i][0]%R))%R)%R;
        return (int)res;
    }
}