class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int req = skill[0]+skill[skill.length-1];
        for(int i=0;i<skill.length/2;i++){
            if(skill[i] + skill[skill.length - 1- i] != req){
                return -1;
            }
        }
        long ans = 0L;
        for(int i=0;i<skill.length/2;i++){
            ans += (long)((long)skill[i] * (long)skill[skill.length-1-i]);
        }
        return ans;
    }
}