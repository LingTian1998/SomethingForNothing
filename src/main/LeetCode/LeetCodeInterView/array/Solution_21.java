package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_21 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int i=0;
        int j=0;
        while (i< nums1.length && j <nums2.length){
            while (i<nums1.length&&nums1[i]<nums2[j])
                i++;
            if (i<nums1.length&& nums1[i]==nums2[j]) {
                list.add(nums1[i]);
                i++;
            }
            j++;
        }

        int[] result =new int[list.size()];
        for (int k=0; k<result.length; k++)
            result[k] = list.get(k);

        return result;
    }
}
