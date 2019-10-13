package before_start;

public class Solution_4 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0)
            return;
        if (m==0){
            for (int i=0; i<n; i++)
                nums1[i] = nums2[i];
        }
        int end = m+n -1;
        int nums1_end = m-1;
        int nums2_end = n-1;
        for (;end>=0;){
            if (nums1_end == -1){
                nums1[end--] = nums2[nums2_end];
                nums2_end--;
                continue;
            }
            if (nums2_end == -1){
                nums1[end--] = nums1[nums1_end];
                nums1_end --;
                continue;
            }

            if (nums1[nums1_end]>= nums2[nums2_end])
                nums1[end--]=nums1[nums1_end--];
            else if (nums1[nums1_end]<nums2[nums2_end])
                nums1[end--]=nums2[nums2_end--];
        }
    }
}
