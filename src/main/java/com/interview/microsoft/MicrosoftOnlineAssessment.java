package com.interview.microsoft;

import java.util.HashMap;
import java.util.Map;

public class MicrosoftOnlineAssessment {

    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
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
            if (!digitSumToNumberMapping.containsKey(digitSum)) {
                digitSumToNumberMapping.put(digitSum, num);
            }
            else {
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
            if (str.charAt(i) == str.charAt(i - 1)) {
                consecutiveCount++;
            }
            else {
                result += (consecutiveCount + 1) / 3;
                consecutiveCount = 0;
            }
        }

        if (consecutiveCount > 0) {
            result += (consecutiveCount + 1) / 3;
        }

        return result;
    }


    public static int min_adj_swap_palindrome(String str) {

        if (isPalindrome(str)) {
            int left = 0;
            int swapCount = 0;
            int right = str.length() - 1;

            while (left < right) {
                if (str.charAt(left) == str.charAt(right)) {
                    left++;
                    right--;
                    continue;
                }

                int matchIndex = right;
                while (matchIndex > left && str.charAt(left) != str.charAt(--matchIndex)) ;

                if (left == matchIndex) {
                    str = swap(str, left, left + 1);
                    swapCount++;
                    continue;
                }

                while (matchIndex < right) {
                    str = swap(str, matchIndex, matchIndex + 1);
                    matchIndex++;
                    swapCount++;
                }
                left++;
                right--;
            }
            return swapCount;
        }

        return -1;
    }

    private static String swap(String str, int i, int j) {
        if (j == str.length() - 1)
            return str.substring(0, i) + str.charAt(j)
                    + str.substring(i + 1, j) + str.charAt(i);

        return str.substring(0, i) + str.charAt(j)
                + str.substring(i + 1, j) + str.charAt(i)
                + str.substring(j + 1, str.length());
    }


    private static boolean isPalindrome(String str) {
        int oddCounter = 0;
        Map<Character, Integer> charCounterMapping = new HashMap<Character, Integer>();

        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            if (charCounterMapping.get(str.charAt(i)) != null) {
                count = charCounterMapping.get(str.charAt(i));
            }
            charCounterMapping.put(str.charAt(i), ++count);
        }

        for (Integer counter : charCounterMapping.values()) {
            if (counter % 2 != 0) {
                oddCounter++;
            }
            if (oddCounter > 1) {
                return false;
            }
        }
        return true;
    }
}
