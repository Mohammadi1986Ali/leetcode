package com.ai4everyone.tutorial.leetcode.medium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class IntegerToRomanTest {
    private final IntegerToRoman intToRoman = new IntegerToRoman();

    @Test
    void givenNumbers_whenConvertingToRoman_thenResultShouldBeCorrect() {
        log.info("IntegerToRomanTest#givenNumbers_whenConvertingToRoman_thenResultShouldBeCorrect");
        assertAll(
                () -> assertEquals("MMMDCCXLIX", intToRoman.intToRoman(3749)),
                () -> assertEquals("LVIII", intToRoman.intToRoman(58)),
                () -> assertEquals("MCMXCIV", intToRoman.intToRoman(1994))
        );
    }
}
