class Solution {
    public int[] minOperations(String boxes) {
        int left = 0,leftCount=0;
        int right=0,rightCount=0;
        for(int i=0;i<boxes.length() ;i++)
            if(boxes.charAt(i) == '1'){
                right+=i;
                rightCount++;
            }

        int []ans = new int[boxes.length()];

        for(int i=0;i<ans.length;i++){
            ans[i] = (leftCount > 0 ? i*leftCount - left : 0) +
                    (rightCount > 0 ? right - i*rightCount : 0);
            
            if(boxes.charAt(i) == '1'){
                leftCount++;
                left +=i;
                rightCount--;
                right-=i;
            }
        }
        return ans;

    }
}