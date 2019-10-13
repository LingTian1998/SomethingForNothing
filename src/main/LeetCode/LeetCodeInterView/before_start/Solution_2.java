package before_start;

import java.util.Arrays;

public class Solution_2 {
    public int majorityElement(int[] nums) {
        // TODO: 2019/8/15 排完序后，中间的那个数一定是众数 
        Arrays.sort(nums);
        return nums[(0+nums.length)/2];
    }
}
