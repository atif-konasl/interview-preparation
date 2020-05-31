package com.interview.practice.graph;

import java.util.*;

public class TopologicalSort {

    /**
     * Leetcode
     * 210. Course Schedule II
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> directedGraph = new ArrayList<>();
        createDirectedGraph(directedGraph, numCourses, prerequisites);

        List<Integer> topologicalSortedList = new ArrayList<>();
        int[] output = new int[numCourses];

        if(topologicalSort(directedGraph, numCourses, topologicalSortedList)) {
            return output;
        }

        for(int i = 0; i < topologicalSortedList.size(); i++) {
            output[i] = topologicalSortedList.get(i);
        }
        return output;
    }


    /**
     *  this method creates a directed graph given by number of
     *  vertices and list of edges
     *
     * @param directedGraph
     * @param numVertices
     * @param edges
     */
    private static void createDirectedGraph(
            List<List<Integer>> directedGraph,
            int numVertices, int[][] edges) {

        for (int i = 0; i < numVertices; i++) {
            directedGraph.add(new LinkedList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            directedGraph.get(edges[i][0]).add(edges[i][1]);
        }
    }

    /**
     * The function to do Topological Sort.
     * It uses recursive topologicalSortUtil()
     * @param directedGraph
     * @param numVertices
     */
    private static boolean topologicalSort(
            List<List<Integer>> directedGraph,
            int numVertices, List<Integer> stack) {

        boolean visited[] = new boolean[numVertices];
        boolean[] recStack = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && topologicalSortUtil(directedGraph, i, visited, recStack, stack)) {
                return true;
            }
        }

        return false;
    }


    /**
     *
     * @param directedGraph
     * @param v
     * @param visited
     * @param stack
     */
    private static boolean topologicalSortUtil(
            List<List<Integer>> directedGraph, int v,
            boolean visited[], boolean recStack[], List<Integer> stack) {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[v]) {
            return true;
        }
        if (visited[v]) {
            return false;
        }

        recStack[v] = true;
        visited[v] = true;
        List<Integer> children = directedGraph.get(v);

        for (Integer c: children) {
            if (!visited[c] && topologicalSortUtil(directedGraph, c, visited, recStack, stack))
                return true;
        }
        stack.add(v);
        recStack[v] = false;
        return false;
    }
}
