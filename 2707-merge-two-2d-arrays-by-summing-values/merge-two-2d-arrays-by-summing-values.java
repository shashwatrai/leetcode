class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int []id = new int[1001];

        for(int i[]: nums1){
            id[i[0]] = i[1];
        }
        int cnt=nums1.length;

        for(int i[]:nums2){
            if(id[i[0]] == 0)
                cnt++;
            id[i[0]] += i[1];
        }
        int ans[][] = new int[cnt][];
        int k=0;
        for(int i=0;i<=1000;i++){
            if(id[i]!= 0){
                ans[k++] = new int[]{i,id[i]};
            }
        }
        return ans;
    
    }
}