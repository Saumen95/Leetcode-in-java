class Solution {
    
public static boolean isPerfectSquare(int num){
	long left = 1;
        long right = num / 2;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid > num) {
                right = mid;                    
            } else if (mid * mid == num) {
                return true;
            } else {
                left = mid;
            }         
        }
        
        if (left * left == num) {
            return true;
        }
        if (right * right == num) {
            return true;
        }
        
        return false;  
	}
}
