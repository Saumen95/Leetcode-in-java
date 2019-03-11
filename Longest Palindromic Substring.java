class Solution {

    public String longestPalindrome(String s) {
        if(isPalindromic(s)) return s;

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i).length() < result.length()) {
                continue;
            }
            for (int j = i + result.length(); j < s.length(); j++) {
                String sub = s.substring(i ,j + 1);
                if(isPalindromic(sub)){
                    if(sub.length() > result.length()){
                        result = sub;
                    }
                }
            }    
        }
        return result;
    }

    private boolean isPalindromic(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}