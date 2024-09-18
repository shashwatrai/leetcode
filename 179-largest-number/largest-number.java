class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String []res = new String[n];

        for(int i=0;i<n;i++){
            res[i] = Integer.valueOf(nums[i]).toString();
        }
        Arrays.sort(res,(a,b)-> {
            String c = a+b;
            String d = b+a;
            // System.out.println(c+" "+d+" "+c.compareTo(d));
            return  c.compareTo(d) ;
    });
    // System.out.println(Arrays.toString(res));
        StringBuilder stb = new StringBuilder();
        // boolean leadingZero = true;
        for(int i=n-1;i>=0;i--){
            while(!res[i].isEmpty() && res[i].startsWith("0")){
                res[i] = res[i].replaceFirst("0","");
                // System.out.println(res[i]+" "+res[i].replaceFirst("0",""));
            }
            if(res[i].length() == 0)
                res[i] = "0";
            stb.append(res[i]);
        }
        
        String ans = stb.toString();
         while(!ans.isEmpty() && ans.startsWith("0")){
                ans = ans.replaceFirst("0","");
                // System.out.println(res[i]+" "+res[i].replaceFirst("0",""));
            }
        if(ans.isEmpty())
            ans = "0";
        return ans;
    }
}
// 31 312
// 31231
// 31312