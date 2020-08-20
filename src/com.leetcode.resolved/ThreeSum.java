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
    // 1. 直接暴力法求解 时间复杂度 O(n^3) 空间复杂度 O(n) 忽略排序时间复杂度
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

    // 2. 双指针法 个人第一版方案 时间复杂度 O(n^2) 空间复杂度 O(n) 忽略排序时间复杂度
    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> result = new LinkedHashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 1; k++) {
            for (int i = k + 1, j = nums.length - 1; i < j;) {
                if (nums[k] + nums[j] + nums[i] > 0){
                    j--;
                } else if (nums[k] + nums[j] + nums[i] < 0){
                    i++;
                } else if (nums[k] + nums[j] + nums[i] == 0) {
                    result.add(Arrays.asList(nums[k], nums[i++], nums[j--]));
                }
            }
        }
        return new ArrayList<>(result);
    }

    // 3. 双指针法 查看解答后优化方案 时间复杂度 O(n^2) 空间复杂度 O(n) 忽略排序时间复杂度
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            // 当num[k]>0时,最后肯定没有，直接跳出循环
            if(nums[k] > 0) break;
            // nums[k] == nums[k - 1]时，所选结果已存在跳出本次循环
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            for (int i = k + 1, j = nums.length - 1; i < j;) {
                if (nums[k] + nums[j] + nums[i] > 0){
                    j--;
                } else if (nums[k] + nums[j] + nums[i] < 0){
                    i++;
                } else if (nums[k] + nums[j] + nums[i] == 0) {
                    // 缩减运行时间使用两次while，减小范围
                    while (i < j && nums[i] == nums[i+1]) i++;
                    while (i < j && nums[j] == nums[j-1]) j--;
                    result.add(Arrays.asList(nums[k], nums[i++], nums[j--]));
                }
            }
        }
        return result;
    }
}
