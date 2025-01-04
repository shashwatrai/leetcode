class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2,nums1);

        int l =0,r= nums1.length;
        int mid = (nums1.length + nums2.length + 1) /2;

        while(l<=r){
            int m = (l+r)/2;

            int l1 = m > 0 ? nums1[m-1] : Integer.MIN_VALUE;
            int r1 = m  < nums1.length ? nums1[m] : Integer.MAX_VALUE;

            int l2 = mid - m  >  0 ? nums2[mid - m - 1]:Integer.MIN_VALUE;
            
            int r2 = mid - m < nums2.length ? nums2[mid - m] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                if((nums1.length + nums2.length)%2 == 0){
                    return (double)(Math.max(l1,l2) + Math.min(r1,r2))/2;
                }else{
                    return Math.max(l1,l2);
                }
            }else if(l1 > r2){
                r = m-1;
            }else
                l = m+1;
        }
        return -1;
    }
}