class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int dp[][] = new int[m][n];
        int dir[][] = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int up = i > 0 ? dp[i-1][j] : 0;
                int left = j > 0 ? dp[i][j-1]: 0;
                
                if(up > left){
                    dp[i][j] = up;
                    dir[i][j] = 1;
                }else{
                    dp[i][j] = left;
                    dir[i][j] = 2;
                }
                if(str1.charAt(i) == str2.charAt(j)){
                    int res = 0;
                    if(i > 0 && j > 0 )
                        res = dp[i-1][j-1];
                    if(dp[i][j] < 1 + res){
                        dir[i][j] = 0;
                        dp[i][j] = 1 + res;
                    }
                }
            }
        }
        int x = m-1,y = n-1, a = m-1,b = n-1;
        // System.out.println(dp[x][y]+" "+Arrays.deepToString(dir));
        StringBuilder stb = new StringBuilder();
        while(x >=0 && y >=0 ){
            if(dir[x][y] == 0){
                // System.out.print(x+" "+y+" "+a+" "+ b+" ");
                for(;x < a;a--){
                    stb.append(str1.charAt(a));
                }
                for(;y < b;b--)
                    stb.append(str2.charAt(b));
                stb.append(str1.charAt(x));
                a--;
                b--;
                x--;
                y--;
                // System.out.println(stb.toString());
            }else if(dir[x][y]  == 1){
                x--;
            }else
                y--;
        }
        for(;0 <= a;a--){
            stb.append(str1.charAt(a));
        }
        for(;0 <= b;b--)
            stb.append(str2.charAt(b));
        return stb.reverse().toString();
    }
}
