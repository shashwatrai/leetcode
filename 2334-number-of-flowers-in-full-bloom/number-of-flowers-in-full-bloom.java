
class Solution {
    public int bSearch1(int []arr,int t){
        int l =0, r= arr.length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(arr[m] > t)
                r = m-1;
            else
                l = m+1;
        }
        return l;
    }
    public int bSearch2(int []arr,int t){
        int l =0, r= arr.length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(arr[m] >= t)
                r = m-1;
            else
                l = m+1;
        }
        return l;
    }
    public int[] fullBloomFlowers(int[][] intervals, int[] queries) {
       int arr1[] = new int[intervals.length];
       int arr2[] = new int[intervals.length];

       for(int i=0;i<intervals.length;i++){
            arr1[i] = intervals[i][0];
            arr2[i] = intervals[i][1];

       }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int [] ans = new int[queries.length];
       for(int i=0;i<queries.length;i++){
            ans[i] = bSearch1(arr1,queries[i]) - bSearch2(arr2,queries[i]);
       }
       return ans;
    }
}

