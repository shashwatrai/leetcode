class MyCalendar {
 List<Integer> start;
    List<Integer> end;
    public MyCalendar() {
                start = new ArrayList<>();
        end = new ArrayList<>();
    }
    public int ceilBound(List<Integer> arr,int target){
        int l = 0,r = arr.size()-1;

        while(l<=r){
            int m = (l+r)/2;
            if(arr.get(m) >= target){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return l;
    }
    public int floorBound(List<Integer> arr,int target){
        int l = 0,r = arr.size()-1;

        while(l<=r){
            int m = (l+r)/2;
            if(arr.get(m) <= target){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return r;
    }
    public boolean book(int s, int e) {
        int indx1 = ceilBound(end,e);
        
        int indx2 = floorBound(end,e);

        int next = -1;
        if(indx1 < end.size())
            next = start.get(indx1);
        
        int prev = -1;
        if(indx2 >= 0)
            prev = end.get(indx2);

        if((prev != -1 && prev > s ) || (next != -1 && e > next ))
            return false;
        start.add(indx1,s);
        end.add(indx1,e);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */