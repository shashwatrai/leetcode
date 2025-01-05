class Pair{
    String s;
    double val;

    Pair(String s,double v){
        this.s = s;
        val = v;
    }
}

class Solution {

    public Pair findParent(String a, Map<String,String> parent ,Map<String,Double> value ){
        if(a.equals(parent.get(a))){
            return new Pair(a,1f);
        }
        Pair obj = findParent(parent.get(a),parent,value);
        obj.val *= value.get(a);
        value.put(a, obj.val);
        parent.put(a,obj.s);
        return obj;
    }

    public void merge(String a, String b, double val,Map<String,String> parent ,Map<String,Double> value ){
        Pair objA = findParent(a,parent,value);
        Pair objB = findParent(b,parent,value);

        a = objA.s;
        b = objB.s;
        
        if(!a.equals(b)){
            parent.put(b,a);
            value.put(b,(objA.val * val)/objB.val);
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String,String> parent  = new HashMap<>();
        Map<String,Double> value  = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            parent.put(equations.get(i).get(0),equations.get(i).get(0));
            parent.put(equations.get(i).get(1),equations.get(i).get(1));
            value.put(equations.get(i).get(0),1.0);
            value.put(equations.get(i).get(1),1.0);
        }

        for(int i=0;i<equations.size();i++){
           merge(equations.get(i).get(0),equations.get(i).get(1),values[i],parent,value);
        }

        for(String s: parent.keySet()){
            findParent(s,parent,value);
        }

        double [] ans = new double[queries.size()];
        // System.out.println(parent +" \n" + value);
        for(int i=0;i<ans.length;i++){
            
            if(!parent.containsKey(queries.get(i).get(0)) || 
                !parent.containsKey(queries.get(i).get(1)) ||
                !parent.get(queries.get(i).get(0)).equals(parent.get(queries.get(i).get(1))))
                ans[i] = -1.0;
            else
                ans[i] =  value.get(queries.get(i).get(1))/value.get(queries.get(i).get(0));

        }
        return ans;


    }
}