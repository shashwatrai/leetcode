class MyCalendar {
 List<Integer> start;
    List<Integer> end;
    public MyCalendar() {
                start = new ArrayList<>();
        end = new ArrayList<>();
    }
    public int lowerBound(List<Integer> arr,int target){
        int l = 0,r = arr.size()-1;

        while(l<=r){
            int m = (l+r)/2;
            if(arr.get(m) > target){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return l;
    }
    public boolean book(int s, int e) {
        int indx = lowerBound(end,s);
        // System.out.println(start+"\n"+end+"\n"+indx);

        for(int i= indx;i <start.size();i++){
            if(start.get(i) < e)
                return false;
        }

        start.add(indx,s);
        end.add(indx,e);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */