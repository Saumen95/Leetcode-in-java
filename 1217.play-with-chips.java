import sun.awt.X11.MotifDnDConstants.Swapper;

/*
 * @lc app=leetcode id=1217 lang=java
 *
 * [1217] Play with Chips
 */

// @lc code=start
class Solution {
    public int minCostToMoveChips(int[] chips) {
        int odd = 0;
        int even = 0;
        for(int a:chips){

            if (a%2 == 0) {
                ++even;
            }

            else ++odd;
            

        }

        return Math.min(odd, even);
    }
}
// @lc code=end

