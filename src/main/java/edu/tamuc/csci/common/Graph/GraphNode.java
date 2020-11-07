package edu.tamuc.csci.common.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo: graph
 */

public class GraphNode<E> {
    private E val;
    private List<GraphNode> neighbors;

    public GraphNode() {
        this(null);
    }

    public GraphNode(E val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public E getVal() {
        return val;
    }

    public void setVal(E val) {
        this.val = val;
    }

    public List<GraphNode> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node# " + val + "-> (");
        for(int i = 0; i < neighbors.size(); i++) {
            sb.append(neighbors.get(i).getVal());
            if(i != neighbors.size() - 1) sb.append(",");
        }
        sb.append(")");
        return sb.toString();
    }
}
