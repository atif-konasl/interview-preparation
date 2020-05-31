package com.interview.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CycleDetection {

    /**
     * Leetcode
     * 207. Course Schedule
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> directedGraph = new ArrayList<>();
        createDirectedGraph(directedGraph, numCourses, prerequisites);
        if(isCyclic(directedGraph, numCourses)) {
            return false;
        }
        return true;
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
     *  this method finds weather any cycle exists in the directed graph
     *  or not.
     *
     * @param directedGraph
     * @param numVertices
     * @return
     */
    private static boolean isCyclic(
            List<List<Integer>> directedGraph,
            int numVertices) {

        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[numVertices];
        boolean[] recStack = new boolean[numVertices];


        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < numVertices; i++)
            if (isCyclicUtil(directedGraph, i, visited, recStack))
                return true;

        return false;
    }


    /**
     *
     * @param directedGraph
     * @param i
     * @param visited
     * @param recStack
     * @return
     */
    private static boolean isCyclicUtil(
            List<List<Integer>> directedGraph, int i,
            boolean[] visited, boolean[] recStack) {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }

        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = directedGraph.get(i);

        for (Integer c: children) {
            if (isCyclicUtil(directedGraph, c, visited, recStack)) {
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }
}
