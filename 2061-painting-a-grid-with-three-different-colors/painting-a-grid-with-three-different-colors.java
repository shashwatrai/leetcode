class Solution {
    public void generateState(int m,int indx,int prevColor,List<int[]> states,int []curr){
        if(indx == m){
            states.add(Arrays.copyOf(curr,m));
            return;
        }

        for(int i=1;i<=3;i++){
            if(prevColor == i)
                continue;
            curr[indx] = i;
            generateState(m,indx+1,i,states,curr);
            curr[indx] = 0;
        }
    }
    public int colorTheGrid(int m, int n) {
        
        List<int[]> states = new ArrayList<>();
        generateState(m,0,-1,states,new int[m]);

        // for(int i[]:states)
        //     System.out.println(Arrays.toString(i));
        int l = states.size();

        long []prev = new long[l];
        long R = 1_000_000_007;
        Arrays.fill(prev,1L);
        for(int i=1;i<n;i++){
            long []curr = new long[l];
            for(int j = 0;j<l;j++){
                for(int k=0;k<l;k++){
                    boolean isValid = true;
                    for(int t = 0;t<m;t++){
                        if(states.get(j)[t] == states.get(k)[t] ){
                            isValid = false;
                            break;
                        }
                    }
                    if(!isValid)
                        continue;
                    curr[j] = (curr[j]%R+ prev[k]%R)%R;
                }
            }
            // System.out.println(Arrays.toString(curr));
            prev = curr;
        }

        long ans = 0L;
        for(int i=0;i<l;i++)
            ans = (ans%R + prev[i]%R)%R;
        
        return (int)ans;
    }
}