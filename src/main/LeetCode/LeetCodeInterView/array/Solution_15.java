package array;

public class Solution_15 {
    public int maxProduct(int[] nums) {
        int temp_max = 1;
        int temp_min = 1;

        int max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            if (nums[i]<0){
                int temp = temp_max;
                temp_max =temp_min;
                temp_min = temp;
            }
            temp_max = Math.max(nums[i]*temp_max,nums[i]);
            temp_min = Math.min(nums[i]*temp_min,nums[i]);

            if (max < temp_max)
                max = temp_max;
        }
        return max;
    }
}
