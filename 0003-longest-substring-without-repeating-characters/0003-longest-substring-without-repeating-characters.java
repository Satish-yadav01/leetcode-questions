class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0, r=0, maxlen=0;
        int []dp = new int[256];
        Arrays.fill(dp , -1);

        while(r < s.length()){
            if(l <= dp[s.charAt(r)]){
                l = 1 + dp[s.charAt(r)];
            }
            dp[s.charAt(r)] = r;
            maxlen = Math.max(maxlen,r-l+1);
            r++;
        }

        return maxlen;
    }
}