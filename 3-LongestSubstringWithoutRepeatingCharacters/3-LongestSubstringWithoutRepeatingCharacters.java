class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low=0;
        int maxLength=0;
        Set<Character> charSet = new HashSet<>();
        for(int high=0; high<s.length();high++){
            char currentChar = s.charAt(high);
            while(charSet.contains(currentChar)){
                charSet.remove(s.charAt(low));
                low++;
            }
                charSet.add(currentChar);
                maxLength = Math.max(maxLength,charSet.size());
        }

        return maxLength;
    }
}