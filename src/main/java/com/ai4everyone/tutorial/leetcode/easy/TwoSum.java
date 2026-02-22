package com.ai4everyone.tutorial.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();
        for (int counter = 0; counter < nums.length; counter++) {
            int complement = target - nums[counter];
            if (complementMap.containsKey(complement)) {
                return new int[]{complementMap.get(complement), counter};
            }
            complementMap.put(nums[counter], counter);
        }
        return null;
    }
}