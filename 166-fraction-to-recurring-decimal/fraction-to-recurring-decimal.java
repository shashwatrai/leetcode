class Solution {
    public String fractionToDecimal(int n, int d) {
        if(n == 0)
            return "0";

        Long numerator = (long)n;
        Long denominator = (long)d;
        List<Long> arr = new ArrayList<>();

        int sign = (int)Math.signum(numerator) * (int)Math.signum(denominator);
        
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        Long leading = (numerator/denominator);

        numerator %= denominator;

        if(numerator == 0)
            return (sign == -1   ? "-":"")+leading.toString();

        System.out.println(sign);
        Map<Long,Integer> map = new HashMap<>();

        while(numerator != 0 && !map.containsKey(numerator)){
            // System.out.println(numerator+" "+map);
            map.put(numerator,arr.size());
            numerator *= 10L;
            arr.add( numerator/denominator);
            numerator %= denominator;
        }

        StringBuilder stb = new StringBuilder();

        if(sign == -1)
            stb.append("-");
        stb.append(leading.toString()+".");

        for(int i=0;i<map.getOrDefault(numerator,arr.size());i++){
            stb.append(arr.get(i).toString());
        }
        if(numerator != 0){
            stb.append("(");
            for(int i=map.get(numerator);i<arr.size();i++){
                stb.append(arr.get(i).toString());
            }
            stb.append(")");
        }
        return stb.toString();
    }
}