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
            }else if(min + limit < nums[i]){
                int prevMin = minPQ.peek();
                while(!minPQ.isEmpty() && (minPQ.peek() <= prevMin || nums[minPQ.peek()] + limit < nums[i])){
                    prevMin = Math.max(prevMin,minPQ.poll());
                }
                while(!maxPQ.isEmpty() && (maxPQ.peek() <= prevMin || nums[maxPQ.peek()] - limit > nums[i])){
                    prevMin = Math.max(prevMin,maxPQ.poll());
                }
                
                len = i - prevMin;
            }else{
                int prevMax = maxPQ.peek();
                while(!maxPQ.isEmpty() && (maxPQ.peek() <= prevMax || nums[maxPQ.peek()] - limit > nums[i])){
                    
                    prevMax = Math.max(prevMax,maxPQ.poll());
                }
                while(!minPQ.isEmpty() && (minPQ.peek() <= prevMax || nums[minPQ.peek()] + limit < nums[i])){
                    prevMax = Math.max(prevMax,minPQ.poll());
                }
                len = i - prevMax;
            }
             minPQ.add(i);
             maxPQ.add(i);
            //  System.out.println(len+" "+i);
        }
        maxLen = Math.max(len,maxLen);
        return maxLen;
    }
}