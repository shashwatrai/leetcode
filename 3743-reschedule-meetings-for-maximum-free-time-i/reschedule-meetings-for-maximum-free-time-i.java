class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        List<Integer> wt = new ArrayList<>();


        int end = 1;
        int start = 0;
        while(end < startTime.length){
            if(endTime[end-1] != startTime[end]){
                starts.add(startTime[start]);
                ends.add(endTime[end-1]);
                wt.add(end-start);
                start = end;
            }
            end++;
        }   
        starts.add(startTime[start]);
        ends.add(endTime[end-1]);
        wt.add(end-start);
        int ans = Math.max(starts.get(0) - 0, eventTime - ends.get(ends.size()-1));
        int cnt=0;
        start=0;
        int totalDuration = 0;
        int l =0 ;
        for(int i=0;i<starts.size();i++){
            while(cnt >= k){
                if(start - totalDuration < starts.get(l))
                    cnt -= wt.get(l);
                totalDuration -= ends.get(l) - starts.get(l);
                start = ends.get(l) + totalDuration;
                System.out.println("--->"+start + " "+ totalDuration+" "+cnt);
                l++;
                if(cnt <= k)
                    ans = Math.max(ans,starts.get(i) - start);
            }
            if(start < starts.get(i)){
                cnt += wt.get(i);
            }
            start += ends.get(i) - starts.get(i);
            totalDuration += ends.get(i) - starts.get(i);
            System.out.println(start + " "+ totalDuration+" "+cnt);
            if(cnt <= k)
                ans = Math.max(ans,(i < starts.size()- 1 ? starts.get(i+1) : eventTime) - start);
        }
        while(l < starts.size() && cnt >= 0 ){
                if(start - totalDuration < starts.get(l))
                    cnt -= wt.get(l);
                totalDuration -= ends.get(l) - starts.get(l);
                start = ends.get(l) + totalDuration;
                System.out.println("--->"+start + " "+ totalDuration+" "+cnt);
                l++;
                if(cnt <= k)
                    ans = Math.max(ans,eventTime - start);
        }
        return ans;
    }
}