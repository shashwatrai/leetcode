class Solution {

    public int findIndx(int arr[],int t){
        int l = 0,r = arr.length-1;

        while(l<=r){
            int m = (l+r)/2;

            if(arr[m] <= t)
                l = m+1;
            else
                r = m-1;
        }
        return r;

    }
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int curr = -1;
        boolean isFilled = false;
        for(int i=0;i<buses.length;i++){
            int indx = findIndx(passengers,buses[i]);

            int l = Math.min(capacity,indx-curr);

            curr += l;
            if(i == buses.length-1 && l == capacity){
                isFilled = true;
            }
        }
        if(!isFilled && (curr == -1 || passengers[curr] != buses[buses.length-1])){
            return buses[buses.length-1];
        }
        while(curr > 0 && passengers[curr] == passengers[curr-1] + 1){
            curr--;
        }
        return passengers[curr]-1;
    }
}