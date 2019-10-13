package array;

import java.util.Arrays;

public class Solution_16 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(0+nums.length)/2];
    }
}
