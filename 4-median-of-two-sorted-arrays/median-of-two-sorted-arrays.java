class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2,nums1);

        int l = 0,r = nums1.length+1;
        while(l<=r){
            int mid = (l+r)/2;
            
            int remainingElements = (nums1.length+nums2.length+1)/2 - mid ;

            int l1 = mid > 0 ? nums1[mid-1]: Integer.MIN_VALUE ;
            int r1 = mid < nums1.length? nums1[mid]:Integer.MAX_VALUE;

            int l2 = remainingElements > 0 ? nums2[remainingElements-1] : Integer.MIN_VALUE;
            int r2 = remainingElements < nums2.length ? nums2[remainingElements]:Integer.MAX_VALUE ;

            if(l1  <= r2 && l2 <= r1){
                if((nums1.length+nums2.length)%2 == 0 ){
                    return (double)(Math.max(l1,l2) + Math.min(r1,r2))/2;
                }else{
                    return Math.max(l1,l2);
                }
            }else if(l1 > r2)
                r = mid - 1;
            else 
                l = mid + 1;

        }
        return -1;
    }
}