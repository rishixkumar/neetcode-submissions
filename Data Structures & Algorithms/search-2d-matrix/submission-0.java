class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0, bottom = ROWS - 1;
        while (top <= bottom) {
            int row = (top + bottom) / 2;
            if (target > matrix[row][COLS - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bottom = row - 1;
            } else {
                break;
            }
        }

        if (!(top <= bottom)) {
            return false;
        }

        int row = (top + bottom) / 2;
        int l = 0, r = COLS - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target > matrix[row][m]) {
                l = m + 1;
            } else if (target < matrix[row][m]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
