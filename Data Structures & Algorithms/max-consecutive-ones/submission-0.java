class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int prevCount = 0;
        for ( int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                maxCount++;
            } else {
                if(prevCount<maxCount) {
                prevCount = maxCount;
                }
                maxCount=0;
            }
        }
        return maxCount>prevCount ? maxCount : prevCount;
    }
}