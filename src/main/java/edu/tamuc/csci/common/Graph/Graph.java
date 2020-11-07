package edu.tamuc.csci.common.Graph;

import java.util.*;
import java.util.LinkedList;

/**
 * Demo: Graph
 * (1) Demo undirected graph
 * (2) Demo directed graph (use integer as example)
 */

public class Graph<E> {

    private GraphNode<E> root; // used for demo (1) graph clone

    private List<Integer>[] graph; // used for demo (2) topology sort
    private int[] in; //in degree

    public Graph(GraphNode<E> root) {
        this.root = root;
    }

    public Graph(int[][] arr) {
        if (arr == null || arr.length < 1 || arr[0].length < 1)
            throw new IllegalArgumentException("Invalid graph constructor input");

        init(arr);
    }

    private void init(int[][] arr) {

        final int n = arr.length;
        final int m = arr[0].length;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            if (graph[i] == null) graph[i] = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 1) continue;
                graph[i].add(j);
            }
        }
    }

    //Initialize with total number of nodes, also keep track of in degrees for topology sort demo purpose
    public Graph(int[][] arr, int V) {
        if (arr == null || arr.length < 1 || arr[0].length < 1)
            throw new IllegalArgumentException("Invalid graph constructor input");

        init(arr, V);
    }

    private void init(int[][] arr, int V) {

        final int n = arr.length;
        final int m = arr[0].length;
        in = new int[V]; //in[i] -> in degrees for node_i
        graph = new ArrayList[V];

        for (int[] edge : arr) {
            if (graph[edge[0]] == null) graph[edge[0]] = new ArrayList<>();
            if (graph[edge[0]].contains(edge[1])) continue;

            graph[edge[0]].add(edge[1]); //add neighbors
            in[edge[1]]++; //keep track of in degrees
        }
    }


    //Demo (2) Topology Sort using BFS
    // 1 -> 3 (2 - 1=> 1), 2 -> 3 (1 - 1=> 0), 4 -> 3
    public List<Integer> topoSort() {

        List<Integer> que = new ArrayList<>();
        final int V = in.length;

        for (int n = 0; n < V; n++) {
            if (in[n] > 0) continue;
            que.add(n);
        }

        int index = 0;
        while (index < que.size()) {
            int cur = que.get(index++);
            if (graph[cur] == null) continue;

            for (int n : graph[cur]) {
                if(--in[n] == 0) que.add(n);
            }
        }

        return que; //topog
    }

    public GraphNode<E> cloneGraphDFS() {
        return root == null ? null : dfs(root, new HashMap<>());
    }

    private GraphNode<E> dfs(GraphNode<E> node, Map<GraphNode, GraphNode> cache) {
        if(cache.containsKey(node)) return cache.get(node);

        GraphNode<E> nodeClone = new GraphNode<>(node.getVal());
        cache.put(node, nodeClone);

        for(GraphNode<E> neighbor : node.getNeighbors()) {
            GraphNode<E> neighborClone = dfs(neighbor, cache);
            nodeClone.getNeighbors().add(neighborClone);
        }

        return nodeClone;
    }

    //Demo (1) Clone graph (BFS)
    public GraphNode<E> cloneGraphBFS() {
        if(root == null) return null;

        GraphNode<E> ret = new GraphNode<>(root.getVal());
        Map<GraphNode, GraphNode> node2Clone = new HashMap<>();

        Queue<GraphNode> que = new LinkedList<>();
        node2Clone.put(root, ret);

        que.offer(root);
        while (!que.isEmpty()) {
            GraphNode<E> cur = que.poll();
            GraphNode<E> clone = node2Clone.get(cur);

            for(GraphNode neighbor : cur.getNeighbors()) {
                GraphNode neighborClone = node2Clone.containsKey(neighbor) ?
                        node2Clone.get(neighbor) :
                        new GraphNode(neighbor.getVal());

                clone.getNeighbors().add(neighborClone);

                if(!node2Clone.containsKey(neighbor)) {
                    que.offer(neighbor);
                    node2Clone.put(neighbor, neighborClone);
                }
            }
        }

        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph: [\n");
        for (int i = 0; i < graph.length; i++) {
            if(graph[i] == null) continue;
            sb.append("\tNode# " + i + " -> (");
            for (int j = 0; j < graph[i].size(); j++) {
                sb.append(graph[i].get(j));
                if (j != graph[i].size() - 1) sb.append(",");
            }
            sb.append(")\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
