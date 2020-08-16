package com.leetcode.resolved;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 */
public class MaxArea {
    // 1. 直接暴力法求解 时间复杂度 O(n^2) 空间复杂度 O(1)
    public int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, getCurrentArea(height, i, j));
            }
        }
        return maxArea;
    }

    private int getCurrentArea(int[] height, int i, int j) {
        return Math.min(height[i], height[j]) * (j - i);
    }

    // 2.双指针法简化操作 时间复杂度 O(n) 空间复杂度 O(1)
    public int maxArea2(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            maxArea = Math.max(maxArea, minHeight * (j - i + 1));
        }
        return maxArea;
    }
}
