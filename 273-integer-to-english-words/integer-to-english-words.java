class Solution {
   
    public String getHundreds(int num,Map<Integer,String> mapUnit,Map<Integer,String> mapTenth,Map<Integer,String> mapOneTenth){
        String ans = "";

        if(num%100 >= 10 && num%100 < 20){
            ans  = mapOneTenth.get(num%100);
            num/=100;
        }else{
            ans  = mapTenth.getOrDefault((num/10)%10,"") + (mapUnit.containsKey(num%10)?" " + mapUnit.get(num%10):"");
            num/=100;
        }
        if(num > 0){
            ans = mapUnit.get(num) +" Hundred" + (ans.isEmpty()?"":" "+ans.trim());
        }
        return ans.trim();
    }
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        Map<Integer,String> mapUnit = new HashMap<>();
        mapUnit.put(1,"One"); 
        mapUnit.put(2,"Two"); 
        mapUnit.put(3,"Three"); 
        mapUnit.put(4,"Four"); 
        mapUnit.put(5,"Five"); 
        mapUnit.put(6,"Six"); 
        mapUnit.put(7,"Seven"); 
        mapUnit.put(8,"Eight"); 
        mapUnit.put(9,"Nine"); 
        Map<Integer,String> mapTenth = new HashMap<>();  
        mapTenth.put(2,"Twenty"); 
        mapTenth.put(3,"Thirty"); 
        mapTenth.put(4,"Forty"); 
        mapTenth.put(5,"Fifty"); 
        mapTenth.put(6,"Sixty"); 
        mapTenth.put(7,"Seventy"); 
        mapTenth.put(8,"Eighty"); 
        mapTenth.put(9,"Ninety"); 

        Map<Integer,String> mapOneTenth = new HashMap<>();  
        mapOneTenth.put(10,"Ten"); 
        mapOneTenth.put(11,"Eleven"); 
        mapOneTenth.put(12,"Twelve"); 
        mapOneTenth.put(13,"Thirteen"); 
        mapOneTenth.put(14,"Fourteen"); 
        mapOneTenth.put(15,"Fifteen"); 
        mapOneTenth.put(16,"Sixteen"); 
        mapOneTenth.put(17,"Seventeen"); 
        mapOneTenth.put(18,"Eighteen"); 
        mapOneTenth.put(19,"Nineteen"); 

        List<String> arr = Arrays.asList("","Thousand","Million","Billion");
        int indx=0;
        
        String ans = "";
        while(num > 0){
            String temp = getHundreds(num%1000,mapUnit,mapTenth,mapOneTenth);
            String temp2 = (temp.isEmpty()?"":(arr.get(indx).isEmpty()?temp:temp + " "+arr.get(indx)) );
            ans = temp2.isEmpty()?ans:(ans.isEmpty()?temp2:temp2+" "+ans);
            num/= 1000;
            indx++; 
        }
        return ans;
    }
}