package com.interview.practice.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class TopologicalSortTest {

    @Test
    public void test_findOrder() {
        int[][] prerequisites = {{1,0},{2,0},{3,1},{0,2}};
        int[] expected = {};
        int[] actual = TopologicalSort.findOrder(4, prerequisites);
        assertArrayEquals(expected, actual);
    }
}
