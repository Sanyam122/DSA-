class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] word = s.trim().split(" ");
        if (pattern.length() != word.length) return false;

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String w = word[i];

            if (charToWord.containsKey(ch) && !charToWord.get(ch).equals(w)) return false;
            if (wordToChar.containsKey(w) && wordToChar.get(w) != ch) return false;

            charToWord.put(ch, w);
            wordToChar.put(w, ch);
        }
        return true;
    }
}