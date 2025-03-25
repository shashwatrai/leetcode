class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int []> yMap = new ArrayList<>();
        List<int []> xMap = new ArrayList<>();

        for(int rect[]:rectangles){
            xMap.add(new int[] {rect[0],1});
            xMap.add(new int[] {rect[2],-1});
            yMap.add(new int[] {rect[1],1});
            yMap.add(new int[] {rect[3],-1});
        }

        Collections.sort(yMap, (a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Collections.sort(xMap, (a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        int cnt1 = 0,s1=0;
        for(int i[]:yMap){
            // System.out.print("["+i[0]+","+i[1]+"]");
            s1 += i[1];
            if(s1 == 0)
                cnt1++;
        }
        // System.out.println();
        
        int cnt2 = 0,s2=0;
        for(int i[]:xMap){
            // System.out.print("["+i[0]+","+i[1]+"]");
            s2 += i[1];
            if(s2 == 0)
                cnt2++;
        }
        return cnt1 > 2 || cnt2 > 2;

    }
}