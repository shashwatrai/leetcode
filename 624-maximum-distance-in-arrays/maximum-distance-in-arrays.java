class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int indxL = -1,indxR = 1;
        int minL = Integer.MAX_VALUE,maxR = Integer.MIN_VALUE;

        for(int i=0;i<arrays.size() ; i++){
            if(arrays.get(i).get(0) < minL){
                indxL = i;
                minL = arrays.get(i).get(0);
            }
            if(arrays.get(i).get(arrays.get(i).size()-1) > maxR){
                indxR = i;
                maxR = arrays.get(i).get(arrays.get(i).size()-1);
            }
        }
        if(indxL != indxR)
            return maxR-minL;
        else{
            int maxL2 = -1;
            maxR = Integer.MIN_VALUE;
            int minL2 = -1;
            minL  = Integer.MAX_VALUE;
            for(int i=0;i<arrays.size();i++){

                if(i != indxR &&  maxR < arrays.get(i).get(arrays.get(i).size()-1)){
                    maxR = arrays.get(i).get(arrays.get(i).size()-1);
                    maxL2 = i;
                }

                if(i != indxL &&  minL > arrays.get(i).get(0)){
                    minL = arrays.get(i).get(0);
                    minL2 = i;
                }    
            }
            return Math.max( Math.abs(arrays.get(indxR).get(arrays.get(indxR).size()-1)-arrays.get(minL2).get(0)),
                Math.abs(arrays.get(maxL2).get(arrays.get(maxL2).size()-1)-arrays.get(indxL).get(0)));
        }   
    }
}