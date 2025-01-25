class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> bank = new HashSet<>(wordList);
        if(!bank.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                String current = queue.poll();
                char[] wordChars = current.toCharArray();
                for(int j=0; j<wordChars.length; j++){
                    char originalChar = wordChars[j];
                    for(char c = 'a'; c<='z'; c++){
                        if(c == originalChar) continue;
                        wordChars[j] = c;
                        String nextWord = new String(wordChars);
                    
                    if(nextWord.equals(endWord)) return count + 1;
                    if(bank.contains(nextWord) && !visited.contains(nextWord)){
                        queue.add(nextWord);
                        visited.add(nextWord);
                        }
                    }
                    wordChars[j] = originalChar;
                }
            }
            count++;
        }
        return 0;
    }
}