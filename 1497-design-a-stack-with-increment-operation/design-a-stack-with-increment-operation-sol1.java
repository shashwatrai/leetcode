class CustomStack {


    int []arr;
    int cnt;
    int maxSize;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        cnt = -1;
    }
    
    public void push(int x) {
        if(cnt ==  maxSize-1)
            return ;
        arr[++cnt] = x;
        
    }
    
    public int pop() {
        if(cnt == -1){
            return -1;
        }
        
        
        
        return arr[cnt--];
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<=cnt && i <k;i++){
            arr[i] += val;
        }
    }
    
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
