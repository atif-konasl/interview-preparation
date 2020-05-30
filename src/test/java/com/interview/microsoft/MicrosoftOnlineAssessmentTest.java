package com.interview.microsoft;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MicrosoftOnlineAssessmentTest {

    @Test
    public void test_NumbersWithEqualDigitSum_when_randomArray() {
        int[] inputArray = {51, 71, 17, 42};
        int expectedResult = 93;
        int actualResult = MicrosoftOnlineAssessment
                .numbersWithEqualDigitSum(inputArray);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_stringWithout_3_consecutiveLetters() {
        String str = "baaaaa";
        int expectedResult = 1;
        int actualResult = MicrosoftOnlineAssessment
                .stringWithout_3_consecutiveLetters(str);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_min_adj_swap_palindrome() {
        String str = "ntiin";
        int expectedResult = 1;
        int actualResult = MicrosoftOnlineAssessment
                .min_adj_swap_palindrome(str);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_longest_subString_without_3_contiguous_occurancesOfLetter() {
        String str = "aaabba";
        String expected = "aabba";
        String actual = MicrosoftOnlineAssessment
                .longest_subString_without_3_contiguous_occurancesOfLetter(str);
        assertEquals(expected, actual);
    }

    @Test
    public void test_lexicographically_smallest_string() {
        String str = "abcc";
        String expected = "abc";
        String actual = MicrosoftOnlineAssessment
                .lexicographically_smallest_string(str);
        assertEquals(expected, actual);
    }

    @Test
    public void test_min_deletions_to_make_frequency_for_each_letter_unique() {
        String str = "eeeeffff";
        int expected = 1;
        int actual = MicrosoftOnlineAssessment
                .min_deletions_to_make_frequency_for_each_letter_unique(str);
        assertEquals(expected, actual);
    }

    @Test
    public void test_string_without_3_identical_consecutive_letter() {
        String str = "a";
        String expected = "a";
        String actual = MicrosoftOnlineAssessment
                .string_without_3_identical_consecutive_letter(str);
        assertEquals(expected, actual);
    }


    @Test
    public void test_min_steps_to_make_piles_equal_heights() {
        Integer[] array = {2, 4, 3, 5};
        Integer[] expected = {5, 4, 3, 2};
        Integer[] actual = MicrosoftOnlineAssessment
                .min_steps_to_make_piles_equal_heights(array);
        assertEquals("Should be same", expected, actual);
    }
}
