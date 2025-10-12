class Solution {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        System.out.println(Arrays.toString(power));
        int n = power.length;

        long ans[] = new long[n];

        ans[0] = power[0];
        int prev=-1;
        long max1 = power[0];
        long max2 = 0L;
        for(int i=1;i<n;i++){
            if(power[i] == power[i-1]){
                ans[i] = ans[i-1] + (long)power[i];
                
            }else{
                while(power[i] - power[prev+1] > 2)
                    max2 = Math.max(max2,ans[++prev]);
                ans[i] = max2 + (long)power[i];
            }
            max1 = Math.max(max1,ans[i]);
            // System.out.println(max1+" "+max2+" "+" "+Arrays.toString(ans));
        }
        return max1;
    }
}