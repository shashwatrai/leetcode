class Solution {
    public boolean stoneGameIX(int[] stones) {
        int rem[] = new int[3];
        int n = stones.length;
        for(int i: stones)
            rem[i%3]++;
        
        if(rem[1] > 0){
            rem[1]--;
            if(rem[0]%2 == 0){
                // System.out.println(rem[1]+" "+rem[2]+" "+( 1 <= rem[1] - rem[2]));
                if( 1 <= rem[2] - rem[1])
                    return true;
            }else{
                if( rem[1] - rem[2] >= 2)
                    return true;
            }
            rem[1]++;
        }

        if(rem[2] > 0){
            rem[2]--;
            if(rem[0]%2 == 0){
                if( 1 <= rem[1] - rem[2])
                    return true;
            }else{
                if( rem[2] - rem[1] >= 2)
                    return true;
            }
            rem[2]++;
        }
        return false;
    }
}