class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];

        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(memo[i], -1); //O(n) -> not calculated in computation
        }

        return lcs(text1, text2, 0, 0, memo);
    }


    private int lcs(String s1, String s2, int i, int j, int[][] memo) {
        if (i == s1.length() || j == s2.length()) return 0;
        if(memo[i][j] > -1) return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + lcs(s1, s2, i+1, j+1, memo);
        } else {
            memo[i][j] = Math.max(
                lcs(s1, s2, i, j+1, memo),
                lcs(s1, s2, i+1, j, memo)
            );
        }

        return memo[i][j];
    }
}
