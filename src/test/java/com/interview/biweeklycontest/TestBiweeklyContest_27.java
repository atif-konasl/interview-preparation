package com.interview.biweeklycontest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestBiweeklyContest_27 {

    @Test
    public void test_canBeEqual() {
        int[] target = {1,2,3,4};
        int[] arr = {3, 3, 1, 2};
        boolean expected = false;
        boolean actual = BiweeklyContest_27.canBeEqual(target, arr);
        assertEquals(expected, actual);
    }

    @Test
    public void test_hasAllCodes() {
        boolean expected = true;
        boolean actual = BiweeklyContest_27.hasAllCodes("00110110", 2);
        assertEquals(expected, actual);
    }

//    n = 5, prerequisites = [[0,1],[1,2],[2,3],[3,4]], queries = [[0,4],[4,0],[1,3],[3,0]]
//    Output: [true,false,true,false]



    @Test
    public void test_checkIfPrerequisite() {
        int[][] prerequisites = {{2,3},{2,1},{2,0},{3,4},{3,6},{5,1},{5,0},{1,4},{1,0},{4,0},{0,6}};
        int[][] quries = {{3,0},{6,4},{5,6},{2,6},{2,3},{5,6},{4,0},{2,6},{3,5},{5,3},{1,6},{1,0},{3,5},{6,5},{2,3},{3,0},{3,4},{3,4},{2,5},{0,3},{4,0},{6,4},{5,0},{6,5},{5,6},{6,5},{1,0},{3,4},{1,5},{1,4},{3,6},{0,1},{1,2},{5,1},{5,3},{5,3},{3,4},{5,4},{5,4},{5,3}};
        List<Boolean> expected = new ArrayList<>(Arrays.asList(true,false,true,true,true,true,true,true,false,false,true,true,false,false,true,true,true,true,false,false,true,false,true,false,true,false,true,true,false,true,true,false,false,true,false,false,true,true,true,false));
        List<Boolean> actual = BiweeklyContest_27
                .checkIfPrerequisite(3, prerequisites, quries);
        assertEquals(expected, actual);
    }
}
