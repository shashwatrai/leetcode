class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>((a,b)->  nums[a] != nums[b] ? nums[a]-nums[b]: a - b);
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b)->  nums[a] != nums[b] ? nums[b]-nums[a]: a - b);
        long count=0;
        int start = 0;
        for(int i=0;i<nums.length;i++){


            if(nums[i] < minK || nums[i] > maxK){
                while(start <= i){
                    if(!minPQ.isEmpty() && !maxPQ.isEmpty() && nums[minPQ.peek()] == minK && nums[maxPQ.peek()] == maxK){
                        
                        count += (long)(i - Math.max(minPQ.peek(),maxPQ.peek()));
                    }
                    while(!minPQ.isEmpty() && minPQ.peek() <= start){
                        minPQ.poll();
                    }
                    while(!maxPQ.isEmpty() && maxPQ.peek() <= start){
                        maxPQ.poll();
                    }
                    start++;
                }
            }else{
                minPQ.add(i);
                maxPQ.add(i);
            }
        }
        int n  = nums.length;
        while(start < n){
            if(!minPQ.isEmpty() && !maxPQ.isEmpty() && nums[minPQ.peek()] == minK && nums[maxPQ.peek()] == maxK){
                
                count += (long)(n - Math.max(minPQ.peek(),maxPQ.peek()));
            }
            while(!minPQ.isEmpty() && minPQ.peek() <= start){
                minPQ.poll();
            }
            while(!maxPQ.isEmpty() && maxPQ.peek() <= start){
                maxPQ.poll();
            }
            start++;
        }
        return count;
    }
}
