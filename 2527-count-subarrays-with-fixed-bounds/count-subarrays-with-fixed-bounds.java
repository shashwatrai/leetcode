class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        Integer minPQ = -1;
        Integer maxPQ = -1;
        long count=0;
        int start = 0;
        for(int i=0;i<nums.length;i++){


            if(nums[i] < minK || nums[i] > maxK){
                while(start <= i){

                    if(minPQ != -1 && maxPQ != -1){
                        count += (long)(i - Math.max(minPQ,maxPQ));
                    }
                    if( minPQ == start){
                        minPQ = -1;
                        int temp = start + 1;
                        while(temp < i){
                            if(nums[temp] == minK){
                                minPQ = temp;
                                break;
                            }
                            temp++;
                        }
                    }
                    if( maxPQ == start){
                        maxPQ = -1;
                        int temp = start + 1;
                        while(temp < i){
                            if(nums[temp] == maxK){
                                maxPQ = temp;
                                break;
                            }
                            temp++;
                        }
                    }
                    if(minPQ == -1 || maxPQ == -1){
                        minPQ = maxPQ = -1;
                        start = i+1;
                    }
                    else
                        start++;
                }
            }else{
                if(nums[i] == minK && minPQ == -1)
                    minPQ = i;
                if(nums[i] == maxK && maxPQ == -1)
                    maxPQ = i;
            }
        }
        int n  = nums.length;
        while(start < n){
            if(minPQ != -1 && maxPQ != -1){
                count += (long)(n - Math.max(minPQ,maxPQ));
            }
            if( minPQ == start){
                minPQ = -1;
                int temp = start + 1;
                while(temp < n){
                    if(nums[temp] == minK){
                        minPQ = temp;
                        break;
                    }
                    temp++;
                }
            }
            if( maxPQ == start){
                maxPQ = -1;
                int temp = start + 1;
                while(temp < n){
                    if(nums[temp] == maxK){
                        maxPQ = temp;
                        break;
                    }
                    temp++;
                }
            }
            if(minPQ == -1 || maxPQ == -1)
                break;
            else
                start++;
        }
        return count;
    }
}