package com.interview.microsoft;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MicrosoftOnlineAssessmentTest {

    @Test
    public void test_NumbersWithEqualDigitSum_when_randomArray() {
        int[] inputArray = {51, 71, 17, 42};
        int expectedResult = 93;
        int actualResult = MicrosoftOnlineAssessment.numbersWithEqualDigitSum(inputArray);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_stringWithout_3_consecutiveLetters() {
        String str = "baaaaa";
        int expectedResult = 1;
        int actualResult = MicrosoftOnlineAssessment.stringWithout_3_consecutiveLetters(str);
        assertEquals(expectedResult, actualResult);
    }
}
