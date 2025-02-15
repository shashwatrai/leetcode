class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int arr[] =  new int[100001];

        Arrays.fill(arr,-1);
        for(int i=0;i<elements.length;i++){
            if(arr[elements[i]] == -1){
                for(int j=elements[i];j<arr.length;j+=elements[i]){
                    if(arr[j] == -1)
                        arr[j] = i;
                }
            }
        }
        int ans [] = new int[groups.length];
        for(int i=0;i<ans.length;i++){
            ans[i] = arr[groups[i]];
        }
        return ans;
    }
}