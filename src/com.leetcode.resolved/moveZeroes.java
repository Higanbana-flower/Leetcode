package com.leetcode.resolved;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes/
 */
public class moveZeroes {
    // 1. 双指针 时间复杂度 O(n) 空间复杂度 O(1)
    public void moveZeroes(int[] nums) {
        int zeroLastPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroLastPosition] = nums[i];
                if (i != zeroLastPosition++) {
                    nums[i] = 0;
                }
            }
        }
    }
}
