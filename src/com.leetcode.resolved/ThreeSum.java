package com.leetcode.resolved;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class ThreeSum {
    // 1. 直接暴力法求解 时间复杂度 O(n^3) 空间复杂度 O(n)
    public List<List<Integer>> threeSum1(int[] nums) {
        // 因为答案中不可以包含重复的三元组 故需要排序并使用set去重
        Set<List<Integer>> result = new LinkedHashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    // 2. 双指针法
    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> result = new LinkedHashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int k = i + 1, j = nums.length - 1; k < j;) {
                if (nums[i] + nums[j] + nums[k] > 0){
                    j--;
                } else if (nums[i] + nums[j] + nums[k] < 0){
                    k++;
                } else if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(Arrays.asList(nums[i], nums[k++], nums[j]));
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        threeSum2(new int[]{-1,0,1,2,6,7,1,-7,1,-4});
    }
}
