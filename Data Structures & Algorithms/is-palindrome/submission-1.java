class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (l < r && !charGood(s.charAt(l))) {
                l++;
            }

            while (r > l && !charGood(s.charAt(r))) {
                r--;
            }

            
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean charGood(char x) {
        return (x >= 'A' && x <= 'Z' ||
                x >= 'a' && x <= 'z' ||
                x >= '0' && x <= '9');
    }
}
