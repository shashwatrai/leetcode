class Solution {
    public int helper(int n,int[] count,int k,int d, int start,long prev){
        if(count[0] == k)
            return (int)prev;
        if(prev*10 > n )
            return -1;
        
        for(int i = start;i<10;i++){

            long temp = (long)prev*10L+i;
            if(temp > n)
                return -1;
            int tempCnt = 10 * ((int)(Math.pow(10,Math.max(0,d-1))-1) / 9) ;
            
            int largestNo = (int)((temp+1) * (int)Math.pow(10,Math.max(0,d-1))-1);
            // System.out.println(prev+" "+temp+" "+(count[0] +tempCnt + 1)+" "+tempCnt+" "+largestNo+" "+k);
            if(count[0] +tempCnt + 1 < k  && largestNo < n){
                count[0]+= tempCnt+1; 
            }else if(count[0] +tempCnt + 1 < k  && largestNo > n){
                count[0] += tempCnt - Math.min((int)Math.pow(10,Math.max(0,d-1)), largestNo-n)+1;
            }else{

                count[0]++;
                int ans= helper(n,count,k,d-1,0,temp);
                if(ans != -1)
                    return ans;
                
            }
            
        }
        return -1;
    }
    public int findKthNumber(int n, int k) {
        int d=0;
        int t = n;
        while(t > 0){
            d++;
            t/=10;
        }

        int count[] = new int[1];
        return helper(n,count,k,d,1,0L);
    }
}