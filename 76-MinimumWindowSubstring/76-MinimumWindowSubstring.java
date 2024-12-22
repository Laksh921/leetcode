class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()){
            return "";
        }
        HashMap<Character,Integer> letterCount = new HashMap<>();
        for(char letter : t.toCharArray()){
            letterCount.put(letter, letterCount.getOrDefault(letter,0)+1);
        }
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, start = 0;
        int required = letterCount.size();
        int formed = 0;
        HashMap<Character, Integer> currentCount = new HashMap<>();
        for(right = 0; right < s.length(); right++){
            char rightChar = s.charAt(right);
            currentCount.put(rightChar, currentCount.getOrDefault(rightChar,0) + 1);
            if(letterCount.containsKey(rightChar) && currentCount.get(rightChar).intValue() == letterCount.get(rightChar).intValue()){
                formed++;
            }
        while(formed == required){
            if(right - left + 1< minLen){
                minLen = right-left+1;
                start = left;
            }
            char leftChar = s.charAt(left);
            currentCount.put(leftChar,currentCount.get(leftChar)-1);
            if(letterCount.containsKey(leftChar) && currentCount.get(leftChar).intValue() < letterCount.get(leftChar).intValue()){
                formed--;
            }
            left++;
        }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}