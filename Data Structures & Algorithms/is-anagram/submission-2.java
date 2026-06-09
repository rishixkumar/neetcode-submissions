class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!countMap.containsKey(c)) {
                return false;
            }
            countMap.put(c, countMap.get(c) - 1);
            if(countMap.get(c) < 0) {
                return false;
            }
        }

        return true;
    }
}
