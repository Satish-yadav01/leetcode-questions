class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int l=0;
        long sum=0, maxSum=0;
        Map<Integer,Integer> freq = new HashMap<>();

        for(int r=0; r<nums.length; r++){

            //shrink
            if(r-l+1 > k ){
                sum = sum - nums[l];
                freq.put(nums[l], freq.getOrDefault(nums[l],0) - 1);
                if(freq.get(nums[l]) == 0) freq.remove(nums[l]);
                l++;
            }

            sum = sum + nums[r];
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);

            if(r-l+1 == k && freq.size() == k) maxSum = Math.max(maxSum,sum);
        }

        return maxSum;
        
    }
}