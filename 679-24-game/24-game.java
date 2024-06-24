class Solution {
    public void addOther(List<Double> arr,List<Double> temp,int i,int j){
        for(int x=0;x<arr.size();x++){
            if(x != i && x!= j) 
                temp.add(arr.get(x));
        }
    }
    public List<List<Double>> helper(List<Double> arr){
        List<List<Double>> ans =  new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            for(int j=0;j<arr.size();j++){
                if(i == j)
                    continue;
                List<Double> t1 = new ArrayList();
                t1.add(arr.get(i)+arr.get(j));
                addOther(arr,t1,i,j);

                List<Double> t2 = new ArrayList();
                t2.add(arr.get(i)-arr.get(j));
                addOther(arr,t2,i,j);

                List<Double> t3 = new ArrayList();
                t3.add(arr.get(i)*arr.get(j));
                addOther(arr,t3,i,j);

                List<Double> t4 = new ArrayList();
                t4.add(arr.get(i)/arr.get(j));
                addOther(arr,t4,i,j);

                ans.add(t1);
                ans.add(t2);
                ans.add(t3);
                ans.add(t4);

            }
        }
        return ans;
    }
    public boolean judgePoint24(int[] cards) {

        List<List<Double>> intermediate  = new ArrayList<>();
        intermediate.add(Arrays.asList(Double.valueOf(cards[0]),Double.valueOf(cards[1]),Double.valueOf(cards[2]),Double.valueOf(cards[3])));
        for(int i=0;i<3;i++){
            List<List<Double>> temp = new ArrayList<>();
            for(List<Double> j : intermediate){
                temp.addAll(helper(j));
            }
            intermediate = temp;
        }

        for(List<Double> i:intermediate){
            if(Math.abs(i.get(0)-24) < 0.1f)
                return true;
        }
        return false;
    }
}