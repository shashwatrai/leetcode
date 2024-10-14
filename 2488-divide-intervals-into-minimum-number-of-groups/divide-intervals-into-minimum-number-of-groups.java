class Solution {
    public int minGroups(int[][] intervals) {
        int []arr = new int[(int)1e6+2];
        for(int i=0;i<intervals.length;i++){
            arr[intervals[i][0]] += 1;
            arr[intervals[i][1]+1] -= 1;
        }
        int max =0;
        int curr=0;

        for(int i:arr){
            curr += i;
            max = Math.max(curr,max);
        }
        return max;
    }
}