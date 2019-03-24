class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int rrob = nums[0], rnrob = nums[0];
        for (int i = 2; i < nums.length; i++) {
            int temp = rrob;
            rrob = rnrob + nums[i];
            rnrob = Math.max(temp, rnrob);
        }
        
        int nrob = nums[1], nnrob = 0;
        for (int i = 2; i < nums.length; i++) {
            int temp = nrob;
            nrob = nnrob + nums[i];
            nnrob = Math.max(temp, nnrob);
        }
        return Math.max(rnrob, Math.max(nrob, nnrob));
    }
}
