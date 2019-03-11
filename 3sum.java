class Solution {
   public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0){
                break;
            }
            if(nums[i]==0 && i+2<nums.length){
                if(nums[i+2]==0){
                    List<Integer> triplet=new ArrayList<Integer>();
                    Collections.addAll(triplet,0,0,0);
                    result.add(triplet);
                }
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int twoSum=0-nums[i];
            int j=i+1,k=nums.length-1;
            while(j<k){
                if(nums[j]+nums[k]>twoSum){
                    k--;
                }else if(nums[j]+nums[k]<twoSum){
                    j++;
                }else{
                    List<Integer> triplet=new ArrayList<Integer>();
                    Collections.addAll(triplet,nums[i],nums[j],nums[k]);
                    if(!result.contains(triplet)){
                        result.add(triplet);
                    }
                    j++;
                    k--;
                    
                }
            }
        }
        return result;
    }
}