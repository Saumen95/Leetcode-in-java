import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // Deal with corner cases
        if (k <= 0 || nums.length < 2) {
            return false;
        }
        
        TreeSet<Long> set = new TreeSet<>();
        // Scan using sliding window
        int i = 0;
        while (i < nums.length) {
            Long floor = set.floor((long) nums[i]);
            Long ceiling = set.ceiling((long) nums[i]);
            
            if (floor != null && nums[i] - floor <= t ||
                ceiling != null && ceiling - nums[i] <= t)
                    return true;
            
            if (i >= k) {
                set.remove((long) nums[i-k]);
            }
            set.add((long) nums[i++]);
        }
        return false;
    }
}