public class Solution {
    public int[] countBits(int num) {
     

        int[] bitCounts = new int[num+1];

        for(int i = 0; i <= num; i++){
            int bitCount = Integer.bitCount(i);
            bitCounts[i] = bitCount;
        }

        return bitCounts;
    }
}
