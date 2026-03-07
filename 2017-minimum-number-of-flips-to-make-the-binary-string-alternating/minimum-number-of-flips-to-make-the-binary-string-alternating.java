class Solution {
    public int minFlips(String s) {
        
        int stat[][] = new int[2][2];

        for(int i=0;i<s.length();i++){
            stat[i%2][s.charAt(i) - '0']++;
        }

        int ans = s.length();

        int n = s.length();
        int indx = 0;
        for(int i =0;i<s.length();i++){
            // int prev = ans;
            ans = Math.min(ans,
                    Math.min(stat[indx][1]+stat[(indx+1)%2][0] , 
                             stat[indx][0]+stat[(indx+1)%2][1]));
            
            // if(prev > ans){
            //     System.out.println(prev+" "+ans +" "+i);
            // }
            int j = s.charAt(i) - '0';

            if(n%2 == 1){
                stat[indx][j]--;
                stat[(indx+1)%2][j]++;
            }
        
            indx = (indx+1)%2;
        }
        return ans;
    }
}