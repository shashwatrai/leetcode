class Solution {
  Map<Integer,Map<Integer,List<Integer>>> map;
  public  List<Integer>  helper(String exp,int start,int end){
    if(map.containsKey(start) && map.get(start).containsKey(end)){
      return map.get(start).get(end);
    }
    List<Integer> operators  = new ArrayList<>();
    for(int i =start;i<=end;i++){
      if(exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '*'){
        operators.add(i);
      }
    }
    if(operators.size() == 0){
      return Arrays.asList(Integer.parseInt(exp.substring(start,end+1)));
    }
    List<Integer> ans = new ArrayList<>();
    for(int i: operators){
      List<Integer> left = helper(exp,start,i-1);
      List<Integer> right = helper(exp,i+1,end);
      for(int x: left){
        for(int y: right)
          if(exp.charAt(i) == '+')
            ans.add(x+y);
          else if(exp.charAt(i) == '*')
            ans.add(x*y);
          else if(exp.charAt(i) == '-')
            ans.add(x-y);
      }
    }
    map.put(start,new HashMap<>());
    map.get(start).put(end,ans);
    return ans;

  }
  public List<Integer> diffWaysToCompute(String expression) {
      map = new HashMap<>();
      return helper(expression,0,expression.length()-1);
  }
}