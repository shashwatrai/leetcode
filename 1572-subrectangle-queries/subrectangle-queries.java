class SubrectangleQueries {

    List<int []> ops;
    int [][]rect;
    public SubrectangleQueries(int[][] rectangle) {
        rect = rectangle;
        ops = new ArrayList<>();
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        ops.add(new int[]{row1,col1,row2,col2,newValue});
    }
    
    public int getValue(int row, int col) {
        int ans = rect[row][col];
        for(int i=ops.size()-1;i>=0;i--){
            int arr[] = ops.get(i);
            // System.out.println(row+" "+col+" "+Arrays.toString(arr));
            if(arr[0] <= row && arr[2] >= row && arr[1] <= col && arr[3] >= col){
                // System.out.println(row+" "+col+" ");
                ans = arr[4];
                break;
            }
        }
        return ans;
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */