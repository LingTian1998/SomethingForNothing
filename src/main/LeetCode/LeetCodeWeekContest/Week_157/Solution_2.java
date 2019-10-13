package Week_157;

import java.util.*;

/**
 * 给你一个整数数组 arr 和一个整数 difference，请你找出 arr 中所有相邻元素之间的差等于给定 difference 的等差子序列，并返回其中最长的等差子序列的长度。
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 *
 * 示例 2：
 *
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 *
 * 示例 3：
 *
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 */

public class Solution_2 {
    public static int longestSubsequence(int[] arr, int difference) {
        if (arr.length == 1)
            return 1;

        Map<Integer, List<Integer>> value_to_index = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            List<Integer> indexList = value_to_index.get(arr[i]);
            if (indexList == null){
                indexList = new ArrayList<>();
                indexList.add(i);
                value_to_index.put(arr[i],indexList);
            }else {
                indexList.add(i);
            }
        }

        int max = Integer.MIN_VALUE;
        int[] flag = new int[arr.length];
        Set<Integer>  set = new HashSet<>();
        for (int i=0; i<arr.length; i++){
            if (flag[i] == 1)
                continue;
            if(set.contains(i))
                continue;
            else {
                set.add(i);
            }

            flag[i] =1;

            int cur_val = arr[i];
            int cur_index = i;
            int next_val = cur_val + difference;
            List<Integer> next_index = value_to_index.get(next_val);
            int count = 1;

            while (next_index != null) {
                int last_index = cur_index;
                for (Integer integer : next_index) {  //这一步 待优化
                    if (integer > cur_index) {
                        flag[integer] = 1;
                        cur_val = arr[integer];
                        cur_index = integer;
                        next_val = cur_val + difference;
                        count++;
                        break;
                    }
                }
                if (cur_index == last_index)
                    break;
                next_index = value_to_index.get(next_val);
            }

            if (count > max)
                max = count;
        }

        return max;
    }


    public int longestSubsequence_1(int[] arr, int difference) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 1;
        for(int data : arr){
            Integer val = map.get(data - difference);
            if(val != null){
                val++;
                ans = Math.max(ans,val);
            }else
                val = 1;
            map.put(data,val);

        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1
        },-2));
    }
}
