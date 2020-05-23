package com.interview.microsoft;

import java.util.HashMap;
import java.util.Map;

public class MicrosoftOnlineAssessment {

    private static int sumOfDigits(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static int numbersWithEqualDigitSum(int[] nums) {
        int result = -1;
        Map<Integer, Integer> digitSumToNumberMapping = new HashMap<Integer, Integer>();

        for (int num : nums) {
            int digitSum = sumOfDigits(num);
            if(!digitSumToNumberMapping.containsKey(digitSum)) {
                digitSumToNumberMapping.put(digitSum, num);
            } else {
                result = Math.max(result, digitSumToNumberMapping.get(digitSum) + num);
                digitSumToNumberMapping.put(digitSum, Math.max(digitSumToNumberMapping.get(digitSum), num));
            }
        }
        return result;
    }

    public static int stringWithout_3_consecutiveLetters(String str) {
        int result = 0;
        int consecutiveCount = 0;

        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(i-1)) {
                consecutiveCount++;
            } else {
                result += (consecutiveCount + 1) / 3;
                consecutiveCount = 0;
            }
        }

        if(consecutiveCount > 0) {
            result += (consecutiveCount + 1) / 3;
        }

        return result;
    }
}
