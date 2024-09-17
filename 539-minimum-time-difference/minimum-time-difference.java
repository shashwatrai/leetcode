class Solution {
    public int diff(String a, String b){
        String []str1 = a.split(":") ;
        int cnt1 = Integer.parseInt(str1[0]) * 60 + Integer.parseInt(str1[1]);

        String []str2 = b.split(":") ;
        int cnt2 = Integer.parseInt(str2[0]) * 60 + Integer.parseInt(str2[1]);

        return cnt2 - cnt1;
    }
    public int findMinDifference(List<String> timePoints) {

        Collections.sort(timePoints);
        int t = diff(timePoints.get(0),timePoints.get(timePoints.size()-1));
        int maxDiff = Math.min(1440-t,t);
        for(int i = 1;i<timePoints.size();i++){
            maxDiff = Math.min(maxDiff,diff(timePoints.get(i-1),timePoints.get(i)));
        }
        return maxDiff;
    }
}