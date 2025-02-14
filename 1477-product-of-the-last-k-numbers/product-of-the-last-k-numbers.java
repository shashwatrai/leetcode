class ProductOfNumbers {

    int arr[];
    int indx;
    List<Integer> lastZero;
    public ProductOfNumbers() {
        arr = new int[100000];
        indx = 0;
        lastZero = new ArrayList<>();
    }
    
    public void add(int num) {
        indx++;

        if(arr[indx-1]!=0)
            arr[indx] =num * arr[indx-1];
        else
            arr[indx] = num;
        
        if(num == 0)
            lastZero.add(indx);
    }
    
    public int getProduct(int k) {
        if(lastZero.size() > 0 && lastZero.get(lastZero.size()-1) > indx - k)
            return 0;
        else{
            int d = arr[indx-k] == 0 ? 1:arr[indx-k];
            return arr[indx]/d;
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */