class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        TreeMap<Integer,Integer> map = new TreeMap<>();

        boolean dp[][] = new boolean[n][2];
        dp[n-1][0] = dp[n-1][1] = true;

        map.put(arr[n-1],n-1);
        
        for(int i=n-2;i>=0;i--){
            if(map.ceilingKey(arr[i]) != null)
                dp[i][0] = dp[map.get(map.ceilingKey(arr[i]))][1];
            if(map.floorKey(arr[i]) != null)
                dp[i][1] = dp[map.get(map.floorKey(arr[i]))][0];
            map.put(arr[i],i);
        }
        System.out.println(Arrays.toString(dp));
        int ans=0;
        for(int i=0;i<n;i++){
            if(dp[i][0])
                ans++;
        }
        return ans;
    }
}