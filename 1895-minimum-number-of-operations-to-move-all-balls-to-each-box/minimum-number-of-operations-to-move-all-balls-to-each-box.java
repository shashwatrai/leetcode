class Solution {
    int findIndx(List<Integer> arr, int t){
        int l = 0,r = arr.size()-1;

        while(l<=r){
            int m = (l+r)/2;

            if(arr.get(m) > t)
                r = m-1;
            else
                l = m+1;
        }
        return r;
    }

    public int[] minOperations(String boxes) {
        List<Integer> setBits = new ArrayList<>();
        List<Integer> prefixSum = new ArrayList<>();      
        int n = boxes.length();

        for(int i=0;i<n;i++){
            if(boxes.charAt(i) == '1'){
                setBits.add(i);
                prefixSum.add(i + (prefixSum.isEmpty()?0:prefixSum.get(prefixSum.size()-1)));
            }
        }

        int []ans = new int[n];
        if(setBits.size() == 0)
            return ans;
        for(int i=0;i<n;i++){
            int indx = findIndx(setBits,i-1);

            ans[i] = (indx >= 0 ? (indx+1)*i - prefixSum.get(indx):0) + 
                    prefixSum.get(prefixSum.size()-1) - (indx >=0 ? prefixSum.get(indx) : 0) - i * (prefixSum.size() - indx - 1);
        }
        return ans;
    }   
}