class Solution {
       public boolean canMeasureWater(int x, int y, int z) {
    // corner cases
    if (x < 0 && y < 0) {
        return false;
    }
    if (z > (x + y)) {
        return false;
    }
    
    if (x == z || y == z || x + y == z || z == 0) {
        return true;
    }
    
    // initialize conditions. We fill the bigger bucket full first and leave smaller one empty
    int bigger = Math.max(x, y);
    int smaller = Math.min(x, y);
    int biggerBucket = bigger;
    int smallerBucket = 0;
    // when smaller bucket is full we have tried every sum combinations
    while (smallerBucket != smaller) {
        int gap = smaller - smallerBucket;
        int leftOver = biggerBucket - gap;
        if (leftOver == z || leftOver + smaller == z) {
            return true;
        }
        if (leftOver <= smaller) {
            if (leftOver + bigger == z) {
                return true;
            }
            smallerBucket = leftOver;
            biggerBucket = bigger;
        } else {
            smallerBucket = 0;
            biggerBucket = leftOver;
        }
    }
    
    return false;
}
}