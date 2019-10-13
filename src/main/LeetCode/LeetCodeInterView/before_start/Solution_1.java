package before_start;

public class Solution_1 {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i=1; i<nums.length; i++){
            result = result ^nums[i];
        }
        return result;
    }
}
