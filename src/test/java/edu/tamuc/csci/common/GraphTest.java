package edu.tamuc.csci.common;

import edu.tamuc.csci.common.Graph.Graph;
import org.junit.jupiter.api.Test;

import java.util.List;

class GraphTest {

    @Test
    void testUndirectedGraph() {

        int[][] adj = {
                {0, 1, 0, 0, 1}, // 0 -> (1, 4)
                {1, 0, 1, 1, 1}, // 1 -> (0, 2, 3, 4)
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
        };

        Graph<Integer> g = new Graph(adj);
        System.out.println(g.toString());
    }

    @Test
    void testDG() {
        int numV = 10; //10 vertices
        int[][] edges = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}}; //edges <from> ==> <to>
        // [0, 1, 2, 3, 4, 5, ... 9]
        // {5, 8} node_5 -> node_8

        Graph<Integer> g = new Graph(edges, numV);
        System.out.println(g.toString());

        List<Integer> sorted = g.topoSort();
        System.out.println(sorted);
    }
}