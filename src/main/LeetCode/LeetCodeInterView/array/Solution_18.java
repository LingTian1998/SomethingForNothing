package array;

import java.util.Arrays;

public class Solution_18 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i+1 < nums.length; i++){
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }
}
