package com.company;

import java.util.LinkedList;

public class Node {
    public Node(LinkedList<Node> connections) {
        this.connections = connections;
    }

    public void addConnection(Node n){
        this.connections.add(n);
    }

    public Node(int i){
        this.connections = new LinkedList<>();
        this.val = i;
    }
    private int val;

    @Override
    public String toString() {
        return Integer.toString(val);
    }

    public LinkedList<Node> getConnections() {
        return connections;
    }

    private LinkedList<Node> connections;
}
