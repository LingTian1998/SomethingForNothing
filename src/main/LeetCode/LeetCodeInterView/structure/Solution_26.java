package structure;

import java.util.Arrays;

public class Solution_26 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length-k];
    }
}
