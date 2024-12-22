class Solution {
   public List<Integer> findSubstring(String s, String[] words) {
       HashMap<String, Integer> wordCount = new HashMap<>();
       HashMap<String, Integer> currentCount = new HashMap<>();
       List<Integer> result = new ArrayList<Integer>();

       for (String word : words) {
           wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
       }

       int c = s.length();
       int wordsLen = words.length;
       int wordLen = words[0].length();

       for (int i = 0; i <= c - wordsLen * wordLen && i < wordLen; i++)
       {
           int start = i;
           int end = i;

           while (end < i + wordsLen * wordLen) {
               String currentWord = s.substring(end, end + wordLen);
               currentCount.put(currentWord, currentCount.getOrDefault(currentWord, 0) + 1);
               end += wordLen;
           }

           if (wordCount.equals(currentCount)) {
               result.add(i);
           }

           while (end + wordLen <= c) {
               String wordToRemove = s.substring(start, start + wordLen);
               int resultingCount = currentCount.get(wordToRemove) - 1;
               if (resultingCount == 0) {
                   currentCount.remove(wordToRemove);
               } else {
                   currentCount.put(wordToRemove, resultingCount);
               }
               start += wordLen;

               String wordToAdd = s.substring(end, end + wordLen);
               currentCount.put(wordToAdd, currentCount.getOrDefault(wordToAdd, 0) + 1);
               end += wordLen;

               if (wordCount.equals(currentCount)) {
                   result.add(start);
               }
           }

           currentCount = new HashMap<String, Integer>();
       }

       return result;
   }
}