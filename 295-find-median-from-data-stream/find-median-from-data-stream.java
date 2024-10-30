class MedianFinder {

    PriorityQueue<Integer> minPQ;
    PriorityQueue<Integer> maxPQ;


    public MedianFinder() {
        maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        minPQ = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        
        if(maxPQ.isEmpty() || maxPQ.peek() >= num)
            maxPQ.add(num);
        else
            minPQ.add(num);
        
        if(maxPQ.size() >= 2 + minPQ.size()){
            minPQ.add(maxPQ.poll());
        }else if(minPQ.size() >= 2+ maxPQ.size()){
            maxPQ.add(minPQ.poll());
        } 
    }
    
    public double findMedian() {
        if(maxPQ.size() == minPQ.size()){
            return (double)(minPQ.peek()+maxPQ.peek())/2;
        }else if(maxPQ.size() > minPQ.size())
            return maxPQ.peek();
        else
            return minPQ.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */