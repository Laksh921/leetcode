class Solution {
    int MAX_WIDTH;
    String findLine(int i , int j, int extraspaces,int eachspacecount, String[] words){
        String line = "";
        for(int k = i; k<j;k++){
            line += words[k];
            if(k == j-1){
                continue;
            }
            for(int z = 1; z<=eachspacecount;z++){
                line +=" ";
            }
            if(extraspaces > 0){
                line += " ";
                extraspaces--;
            }
        }
        while(line.length() < MAX_WIDTH){
            line += " ";
        }
        return line;
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;

        MAX_WIDTH = maxWidth;
        int i = 0;
        while(i<n){
        int lettercount = words[i].length();
        int j = i+1;
        int spaces = 0;
        while(j<n && (words[j].length() + 1 + spaces + lettercount)<=maxWidth){
            lettercount += words[j].length();
            spaces += 1;
            j++;
        }
        int spacesremaning = spaces == 0 ? 0 : maxWidth - lettercount;
        int eachspacecount = spaces == 0 ? 0 : spacesremaning / spaces;
        int extraspaces = spaces == 0 ? 0 : spacesremaning % spaces; 

        if(j == n){
            eachspacecount = 1;
            extraspaces = 0;
        }
        result.add(findLine(i , j, extraspaces, eachspacecount, words));
        i=j;
        }
        return result;

    }
}