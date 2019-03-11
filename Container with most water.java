class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int volume = 0;
        for ( ; start < end ; ) {
            if (height[start] > height[end]) {
                volume = Math.max(volume, height[end]*(end-start));
                end = end - 1;
            } else {
                volume = Math.max(volume, height[start]*(end-start));
                start = start + 1;    
            }           
        } 
        return volume;
    }
}