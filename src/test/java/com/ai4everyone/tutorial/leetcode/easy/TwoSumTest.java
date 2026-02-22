package com.ai4everyone.tutorial.leetcode.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class TwoSumTest {
    private final TwoSum twoSum = new TwoSum();

    @Test
    void givenNumsAndTarget_whenCallingTwoSum_thenResultShouldBeCorrect() {
        log.info("TwoSumTest#givenNumsAndTarget_whenCallingTwoSum_thenResultShouldBeCorrect");
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        var result = twoSum.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }
}