class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        int maxLen = 1;
        int len = 1;
        PriorityQueue<Integer> minPQ  = new PriorityQueue<>((a,b)-> nums[a] != nums[b] ?nums[a] - nums[b]:b-a);
        PriorityQueue<Integer> maxPQ  = new PriorityQueue<>((a,b) ->nums[a] != nums[b] ? nums[b] - nums[a]:b-a);
        minPQ.add(0);
        maxPQ.add(0);
        for(int i=1;i<nums.length;i++){
            int min = nums[minPQ.peek()];
            int max = nums[maxPQ.peek()];
            maxLen = Math.max(len,maxLen);
            if(min + limit >= nums[i] && max - limit <= nums[i]){
                len++;
            }else {
                int prev = min + limit < nums[i] ? minPQ.peek() : maxPQ.peek();
                while(!minPQ.isEmpty() && (minPQ.peek() <= prev || nums[minPQ.peek()] + limit < nums[i])){
                    prev = Math.max(prev,minPQ.poll());
                }
                while(!maxPQ.isEmpty() && (maxPQ.peek() <= prev || nums[maxPQ.peek()] - limit > nums[i])){
                    prev = Math.max(prev,maxPQ.poll());
                }
                
                len = i - prev;
            }
            minPQ.add(i);
            maxPQ.add(i);
            //  System.out.println(len+" "+i);
        }
        maxLen = Math.max(len,maxLen);
        return maxLen;
    }
}