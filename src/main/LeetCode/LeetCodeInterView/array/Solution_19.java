package array;

public class Solution_19 {
    public void moveZeroes(int[] nums) {
        int count_zero = 0;
        int length = nums.length;
        for (int i=0; i<length; i++){
            while (nums[i] == 0&&i<length){
                count_zero++;
                for (int k=i+1; k< length; k++){
                    nums[k-1] = nums[k];
                }
                length--;
            }
        }
        for (int i=length; i<nums.length; i++)
            nums[i]=0;
    }
}
