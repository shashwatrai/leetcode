class Solution {
    public int maxTwoEvents(int[][] events) {
        List<int []> arr = new ArrayList<>();

        for(int i[]:events){
            arr.add(new int[]{i[0],0,i[2]});
            arr.add(new int[]{i[1]+1,1,i[2]});
        }

        Collections.sort(arr,(a,b)-> a[0] != b[0] ?a[0]-b[0]:b[1]- a[1]);

        int ans=0;
        int maxTillNow = 0;

        for(int i[]:arr){
            if(i[1] == 0){
                ans = Math.max(ans,maxTillNow + i[2]);
            }else{
                maxTillNow = Math.max(maxTillNow,i[2]);
            }
        }
        return ans;
    }
}