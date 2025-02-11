class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder ans = new StringBuilder(s);
        while(ans.indexOf(part) != -1){
            int index = ans.indexOf(part);
            ans.delete(index, index + part.length());
        }
        return ans.toString();
    }
}