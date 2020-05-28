package com.interview.microsoft;

import java.util.*;

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

    /**
     * @param str
     * @return
     */
    public static String longest_subString_without_3_contiguous_occurancesOfLetter(String str) {

        if(str.length() == 1) {
            return str;
        }

        int contiguousCount = 1;
        int backIndex = 0;
        int frontIndex = 1;
        int x = 0;
        int y = 0;
        int maxWidth = 0;

        while(frontIndex < str.length()) {
            if(str.charAt(frontIndex) == str.charAt(frontIndex - 1)) {
                contiguousCount++;
            } else {
                contiguousCount = 1;
            }

            if(contiguousCount == 3) {
                int width = frontIndex - backIndex;
                if(maxWidth < width) {
                    maxWidth = Math.max(maxWidth, width);
                    x = backIndex;
                    y = frontIndex;
                }
                backIndex = frontIndex - 1;
                contiguousCount -= 1;
            }

            ++frontIndex;
        }

        int width = frontIndex - backIndex;
        if(maxWidth < width) {
            maxWidth = Math.max(maxWidth, width);
            x = backIndex;
            y = frontIndex;
        }

        return str.substring(x, y);
    }

    public static String lexicographically_smallest_string(String str) {
        if(str.length() == 1) {
            return str;
        }

        for (int i = 1; i < str.length(); i++) {
            char previousChar = str.charAt(i - 1);
            char curChar = str.charAt(i);
            int prevAsciiValue = (int) previousChar;
            int curAsciiValue = (int) curChar;
            if(prevAsciiValue > curAsciiValue) {
                return str.substring(0, i - 1) + str.substring(i, str.length());
            }
        }
        return str.substring(0, str.length() - 1);
    }


    public static int min_deletions_to_make_frequency_for_each_letter_unique(String str) {
        Map<Character, Integer> charCounterMapping = new HashMap<>();
        HashSet<Integer> counterSet = new HashSet<>();
        int result = 0;

        for(int i = 0; i < str.length(); i++)  {
            if(charCounterMapping.containsKey(str.charAt(i))) {
                charCounterMapping.put(str.charAt(i), charCounterMapping.get(str.charAt(i)) + 1);
            } else {
                charCounterMapping.put(str.charAt(i), 1);
            }
        }

        for (Integer counter : charCounterMapping.values()) {
            int x = 0;
            while(counter > x && counterSet.contains(counter - x)) {
                x++;
                result += 1;
            }
            if(counter != x) {
                counterSet.add(counter - x);
            }
        }
        return result;
    }


    public static String string_without_3_identical_consecutive_letter(String str) {
        if(str.length() == 1) {
            return str;
        }

        int consecutiveCounter = 1;
        int startIndex = -1;

        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(i - 1)) {
                ++consecutiveCounter;
                if(consecutiveCounter == 3) {
                    startIndex = i;
                }
            } else {
                if(consecutiveCounter >= 3) {
                    str = str.substring(0, startIndex) + str.substring(i, str.length());
                    consecutiveCounter = 1;
                    startIndex = -1;
                }
            }
        }

        if(startIndex != -1) {
            str = str.substring(0, startIndex);
        }

        return str;
    }

}
