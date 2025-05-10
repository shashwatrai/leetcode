class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long s1,c1,s2,c2;
        s1=c1 =s2=c2=0L;

        for(int i=0;i<nums1.length;i++){
            s1+= (long)nums1[i];
            c1 += (nums1[i] == 0)  ? 1L:0L;
        }

        for(int i=0;i<nums2.length;i++){
            s2+=(long)nums2[i];
            c2 += (nums2[i] == 0?1L:0L);
        }

        s1 += (long)c1;
        s2 += (long)c2;

        if(s1 < s2){
            if(c1 == 0L)
                return -1L;
            else
                return s2;
        }else if(s1 > s2){
            if(c2 == 0L)
                return -1L;
            else
                return s1;
        }else
            return s1;
    }
}