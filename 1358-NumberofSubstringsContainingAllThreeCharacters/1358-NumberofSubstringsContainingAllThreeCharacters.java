class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int left=0;
        int result=0;
        for(int right = 0; right<n; right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            while(map.size() == 3){
                result += n - right;
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left++;
            }
        }
        return result;
    }
}