class Solution {
    public List<Integer> partitionLabels(String s) {
        int []beg = new int[26];
        Arrays.fill(beg,Integer.MAX_VALUE);
        int []end = new int[26];
        Arrays.fill(end, Integer.MIN_VALUE);
        for(int i=0;i<s.length();i++){
            int indx = s.charAt(i)-'a';
            beg[indx] = Math.min(i,beg[indx]);
            end[indx] = Math.max(i,end[indx]);
        }
        int arr[] = new int[s.length()];
        for(int i =0;i<26;i++){
            if(beg[i] !=Integer.MAX_VALUE){
            arr[beg[i]]++;
            arr[end[i]]--;
            }
        }
        List<Integer> ans= new ArrayList<>();
        int start=-1;
        for(int i=0;i<arr.length;i++){
            arr[i] += (i>0?arr[i-1]:0);
            if(arr[i]==0){
                ans.add(i-start);
                start=i;
            }
        }
        return ans;
    }
}