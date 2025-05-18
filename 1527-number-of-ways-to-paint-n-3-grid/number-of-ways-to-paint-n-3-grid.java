class Solution {
    public int numOfWays(int n) {
        int states[][] = new int[12][];
        
        states[0] = new int[]{1,2,3};
        states[1] = new int[]{1,2,1};
        states[2] = new int[]{1,3,2};
        states[3] = new int[]{1,3,1};

        states[4] = new int[]{2,1,3};
        states[5] = new int[]{2,3,1};
        states[6] = new int[]{2,1,2};
        states[7] = new int[]{2,3,2};

        states[8] = new int[]{3,1,2};
        states[9] = new int[]{3,2,1};
        states[10] = new int[]{3,1,3};
        states[11] = new int[]{3,2,3};

        long R = (int)1e9+7;
        
        long prev[] = new long[12];
        for(int i=0;i<12;i++)
            prev[i] = 1;
        
        for(int i=1;i<n;i++){
            long curr[] = new long[12];
            for(int j=0;j<12;j++){
                for(int k = 0;k<12;k++){
                    // System.out.println(Arrays.toString(states[j])+" "+Arrays.toString(states[k]));

                    if(states[j][0] == states[k][0] ||
                         states[j][1] == states[k][1] ||
                             states[j][2] == states[k][2])
                                continue;
                    curr[j] = (curr[j]%R + prev[k]%R)%R;
                }
            }
            prev = curr;
        }
        long ans=0;
        for(int i=0;i<12;i++){
            ans = (prev[i]%R + ans%R)%R;
        }
        return (int)ans;
    }
}