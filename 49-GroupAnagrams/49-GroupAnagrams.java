class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length==0){
            return new ArrayList<>();
        }
        HashMap<String, List<String>> freqStringMap = new HashMap<>();
        for(String str: strs){
            String freqString = getfreqString(str);

            if(freqStringMap.containsKey(freqString)){
                freqStringMap.get(freqString).add(str);
            }
            else{
                List<String> strList = new ArrayList<>();
                strList.add(str);
                freqStringMap.put(freqString, strList);
            }
        } return new ArrayList<>(freqStringMap.values());
    } 
    private String getfreqString(String strs){
        int[] freq = new int[26];
        for(char ch:strs.toCharArray()){
            freq[ch-'a']++;
        }
        StringBuilder freqString = new StringBuilder("");
        char ch='a';
        for(int i:freq){
            freqString.append(ch);
            freqString.append(i);
            ch++;
        }
        return freqString.toString();
    }
}