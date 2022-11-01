/*
 * @lc app=leetcode id=1706 lang=java
 *
 * [1706] Where Will the Ball Fall
 */

// @lc code=start
class Solution {
    public int[] findBall(int[][] grid) {
        int result[] = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            result[i] = findBallDropColumn(0, i, grid);
        }
        return result;
    }
    public int findBallDropColumn(int row, int col, int[][] grid) {
        if (row == grid.length)
            return col;
        int nextColumn = col + grid[row][col];
        if (nextColumn < 0 ||
                nextColumn > grid[0].length - 1 ||
                grid[row][col] != grid[row][nextColumn]) {
            return -1;
        }
        return findBallDropColumn(row + 1, nextColumn, grid);
    }
}
// @lc code=end

/*
 * [[1,1,1,-1,-1],
 *  [1,1,1,-1,-1],
 *  [-1,-1,-1,1,1],
 *  [1,1,1,1,-1],
 *  [-1,-1,-1,-1,-1]]
 */