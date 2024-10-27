class Solution {
    // public int find(int []arr,int target){
    //     int l =0 ,r = arr.length-1;

    //     while(l<=r){
    //         int m = (l+r)/2;

    //         if(arr[m] >= target)
    //             r = m-1;
    //         else
    //             l = m+1;
    //     }
    //     return l;
    // }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2,nums1);


        int l=0,r = nums1.length;
        int median  = (nums1.length+nums2.length+1)/2;
        while(l<=r){
            int m = (l+r) /2;
            int indx = median - m;
           
            int l1 = m > 0 ? nums1[m-1]:Integer.MIN_VALUE;
            int r1 = m < nums1.length  ? nums1[m]:Integer.MAX_VALUE;
            int l2 = indx <= nums2.length && indx > 0? nums2[indx-1]:indx <= 0?Integer.MIN_VALUE:Integer.MAX_VALUE;
            int r2 = indx < nums2.length?nums2[indx]:Integer.MAX_VALUE;
            // System.out.println(m+" "+indx+" "+l1+" "+r1+" "+l2+" "+r2);
            if(l1 <= r2 && l2 <= r1){
                if((nums1.length+nums2.length)%2 == 0)
                    return (double)(Math.max(l1,l2) + Math.min(r1,r2))/2;
                else 
                    return Math.max(l1,l2);
            }else if(l2 > r1){
                l = m+1;
            } else{
                r = m-1;  
            }
                
        }
        
        return -1;
    }
}