class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        HashMap<Character, String> chart = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<pattern.length(); i++){
            char ch=pattern.charAt(i);
            String word = words[i];
            if(chart.containsKey(ch)){
                if(!chart.get(ch).equals(word)){
                    return false;
                }
            }
            else{
                if(set.contains(word)){
                    return false;
                }
                chart.put(ch, word);
                set.add(word);
            }
        }
        return true;
    }
}