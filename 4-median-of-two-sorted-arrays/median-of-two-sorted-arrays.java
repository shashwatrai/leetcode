class Solution {
    int findIndx(int []arr, int target){
        int l = 0, r = arr.length -1;
        while(l<=r){
            int m = (l+r)/2;

            if(arr[m] < target)
                l = m+1;
            else
                r = m-1;
        }
        return l;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       if(nums1.length == 0){
            if(nums2.length % 2 == 0){
                return (double)(nums2[(nums2.length-1)/2]+nums2[(nums2.length)/2])/2;
            }else{
                return nums2[(nums2.length)/2];
            }
       }else if(nums2.length == 0){
            if(nums1.length % 2 == 0){
                return (double)(nums1[(nums1.length-1)/2]+nums1[(nums1.length)/2])/2;
            }else{
                return nums1[(nums1.length)/2];
            }
       }
        int l = 0, r = nums1.length-1;
        boolean found = false;
        int m = -1,m2 = -1;
        while(l<=r){
            m = (l+r)/2;
            m2 = findIndx(nums2,nums1[m]);
            System.out.println(m+" "+m2+" ");
            if(m + m2 == (nums1.length + nums2.length-1)/2 || m + m2 == (nums1.length + nums2.length)/2){
                if((nums1.length+nums2.length)%2 != 0)
                    return nums1[m];
                if(m + m2 == (nums1.length + nums2.length-1)/2 )
                    return (double)(nums1[m] + Math.min(m+1 == nums1.length? Integer.MAX_VALUE:nums1[m+1],m2 < nums2.length ? nums2[m2]:Integer.MAX_VALUE))/2;
                else if(m + m2 == (nums1.length + nums2.length)/2 )
                    return (double)(nums1[m] + Math.max(m > 0 ? nums1[m-1]:Integer.MIN_VALUE,m2 > 0 ? nums2[m2-1]:Integer.MIN_VALUE))/2;
            }else if (m + m2 < (nums1.length + nums2.length-1)/2){
                l = m+1;
            }else
                r = m-1;

        }
        return findMedianSortedArrays(nums2,nums1);
    }
}