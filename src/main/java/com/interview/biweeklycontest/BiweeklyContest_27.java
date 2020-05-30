package com.interview.biweeklycontest;

import java.util.*;

public class BiweeklyContest_27 {

    public static boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> counterMapping1 = new HashMap<>();
        Map<Integer, Integer> counterMapping2 = new HashMap<>();

        for(int i = 0; i < target.length; i++) {
            if(!counterMapping1.containsKey(target[i])) {
                counterMapping1.put(target[i], 1);
            } else {
                counterMapping1.put(target[i], counterMapping1.get(target[i]) + 1);
            }

            if(!counterMapping2.containsKey(arr[i])) {
                counterMapping2.put(arr[i], 1);
            } else {
                counterMapping2.put(arr[i], counterMapping2.get(arr[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : counterMapping1.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if(!counterMapping2.containsKey(key) || counterMapping2.get(key).compareTo(value) != 0) {
                return false;
            }
        }

        return true;
    }


    public static boolean hasAllCodes(String s, int k) {
        List<String> list = new ArrayList<String>();
        generateAllBinaryStrings(k, "", 0, list);
        for (String x : list) {
            if(! s.contains(x)) {
                return false;
            }
        }
        return true;
    }

    private static void generateAllBinaryStrings(int n, String cur , int i,  List<String> allCodes) {
        if (i == n) {
            allCodes.add(cur);
            return ;
        }
        generateAllBinaryStrings(n, cur += "0", i + 1, allCodes);
        generateAllBinaryStrings(n, cur.substring(0, cur.length() - 1) + "1", i + 1, allCodes);
    }


    public static List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> prerequisiteMapping = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] x = prerequisites[i];
            if(!prerequisiteMapping.containsKey(x[1])) {
                Set<Integer> prerequisiteSet = new HashSet<>();
                prerequisiteSet.add(x[0]);
                prerequisiteMapping.put(x[1], prerequisiteSet);
            } else {
                Set<Integer> prerequisiteSet = prerequisiteMapping.get(x[1]);
                prerequisiteSet.add(x[0]);
                prerequisiteMapping.put(x[1], prerequisiteSet);
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            result.add(isValidPrerquisite(prerequisiteMapping, queries[i][1], queries[i][0]));
        }
        return result;
    }

    private static Boolean isValidPrerquisite(
            Map<Integer, Set<Integer>> prerequisiteMapping,
            int course, int prerquisiteCourse) {

        Set<Integer> set = prerequisiteMapping.get(course);
        if(set == null) {
            return false;
        }
        if(set.contains(prerquisiteCourse)) {
            return true;
        }

        Iterator it = set.iterator();
        while(it.hasNext()) {
            int x = (int) it.next();
            if(isValidPrerquisite(prerequisiteMapping, x, prerquisiteCourse)) {
                return true;
            }
        }
        return false;
    }
}
