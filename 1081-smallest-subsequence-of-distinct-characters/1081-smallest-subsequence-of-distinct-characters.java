class Solution {
    public String smallestSubsequence(String s) {
        String str = ""; 
        
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (str.indexOf(currentChar) != -1) {
                continue; 
            }
            
            while (str.length() > 0 
                   && str.charAt(str.length() - 1) > currentChar 
                   && lastIndex[str.charAt(str.length() - 1) - 'a'] > i) {
                
                str = str.substring(0, str.length() - 1);
            }
            
            str += currentChar;
        }
        
        return str;
    }
}