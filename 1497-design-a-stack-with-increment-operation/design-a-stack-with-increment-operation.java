class CustomStack {


    int []arr1;
    int []arr2;
    int cnt;
    int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        arr1 = new int[maxSize];
        arr2 = new int[maxSize];
        cnt = -1;
    }
    
    public void push(int x) {
        if(cnt ==  maxSize-1)
            return ;
        arr1[++cnt] = x;
        
    }
    
    public int pop() {
        if(cnt == -1){
            return -1;
        }
        
        int res = arr1[cnt] + arr2[cnt];
        if(cnt > 0)
            arr2[cnt - 1] += arr2[cnt];
        arr2[cnt]=0;
        cnt--;
        return res;
    }
    
    public void increment(int k, int val) {
        int indx = Math.min(k-1,cnt);
        if(indx >= 0)
            arr2[indx] += val;
    }
    
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */