package com.interview.practice.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CycleDetectionTest {

    @Test
    public void test_canFinish() {
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 0}};
        boolean expected = false;
        boolean actual = CycleDetection
                .canFinish(3, prerequisites);
        assertEquals(expected, actual);
    }
}
