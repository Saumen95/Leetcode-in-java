class Solution {
    public int maxSubArray(int[] nums) {
    if(nums==null || nums.length==0){
        return 0;
    }
 
    PriorityQueue<Integer> pre= new PriorityQueue<>();
    pre.offer(0);
 
    int sum = 0;
    int result = Integer.MIN_VALUE;
 
    for(int i=0; i<nums.length; i++){  
        sum = sum+nums[i];
        result = Math.max(result, sum-pre.peek());
        pre.offer(sum);
    }
 
    return result;
}

}