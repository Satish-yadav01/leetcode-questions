class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        //count of s1
        for(int ch : s1.toCharArray()) freq1[ch - 'a']++;
        int windowSize = s1.length();

        for(int i=0; i<s2.length(); i++){
            freq2[s2.charAt(i) - 'a']++;

            if(i >= windowSize) freq2[s2.charAt(i - windowSize) - 'a']--;
            if(matches(freq1,freq2)) return true;
        }

        return false;
    }

    private boolean matches(int []a, int []b){
        for(int i=0; i<26; i++) if(a[i] != b[i]) return false;
        return true;
    }
}