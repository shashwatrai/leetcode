class Solution {
    public int reverse(int x) {
        String input = Integer.valueOf(Math.abs(x)).toString();
        StringBuilder stb = new StringBuilder();
        stb.append(input);
        String output  = stb.reverse().toString();

        String upperLimit = Integer.valueOf(Integer.MAX_VALUE).toString();
        String lowerLimit = Integer.valueOf(Integer.MIN_VALUE).toString();

        if(x >= 0){
            if(output.length() < upperLimit.length())
                return Integer.parseInt(output);
            else{
                for(int i=0;i<output.length();i++){
                    if(output.charAt(i) == upperLimit.charAt(i))
                        continue;
                    else if(output.charAt(i) > upperLimit.charAt(i))
                        return 0;
                    else{
                        return Integer.parseInt(output);
                    }
                }
            }
        }else{
            output = "-"+output;
            if(output.length() < lowerLimit.length())
                return  Integer.parseInt(output);
            else{
                for(int i=0;i<output.length();i++){
                    if(output.charAt(i) == lowerLimit.charAt(i))
                        continue;
                    else if(output.charAt(i) > lowerLimit.charAt(i))
                        return 0;
                    else{
                        return  Integer.parseInt(output);
                    }
                }
            }
        }
        return 0;
    }
}