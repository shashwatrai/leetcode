class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int max = 0;
        for(int i:nums)
            max = Math.max(i,max);

        int freq[] = new int[max+1];
        for(int i:nums)
            freq[i]++;
        
        Integer arr[] = new Integer[max+1];
        for(int i=0;i<=max;i++)
            arr[i] = i;
        
        Arrays.sort(arr,(a,b)-> freq[b]-freq[a]);

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<freq[arr[0]];i++){
            res.add(new ArrayList<>());
        }
        for(int i=0;i<=max;i++){
            for(int j=0;j<freq[arr[i]];j++)
                res.get(j).add(arr[i]);
        }
        return res;

    }
}