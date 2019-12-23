package com.company;

import java.util.LinkedList;


public class Main {

    public static int c = 2;

    public static void main(String[] args) {

        LinkedList<Node> nodes = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nodes.add(new Node(c++));
        }
        int[][] m = new int[][]{
                {0, 1, 8, 8, 5},
                {1, 0, 2, 8, 8},
                {8, 2, 0, 3, 8},
                {8, 8, 3, 0, 4},
                {5, 8, 8, 4, 0}
        };
        System.out.println("Crascal:");
        printNodes(crascal(nodes, m));
        System.out.println();

        c = 0;
        LinkedList<Node> level = new LinkedList<>();
        LinkedList<Node> nextLevel = new LinkedList<>();
        Node node = new Node(c++);//добавила это
        level.add(node);
        int depth = 3;
        for (int i = 0; i < depth; i++) {
            for (Node t : level
            ) {
                Node next = new Node(c++);
                Node next1 = new Node(c++);
                t.addConnection(next);
                t.addConnection(next1);
                nextLevel.add(next);
                nextLevel.add(next1);
            }
            level.clear();
            level.addAll(nextLevel);
            nextLevel.clear();
        }
        System.out.println("DFS");
        bfs(node);
        c = 0;
        dfs(node);
    }


    public static void dfs(Node root) {
        LinkedList<Node> path = new LinkedList<>();
        path.add(root);
        for (Node t : root.getConnections()
        ) {
            visit(t, path);
        }
    }

    private static void visit(Node root, LinkedList<Node> path) {
        path.add(root);
        printNodes(path);
        for (Node t : root.getConnections()
        ) {
            if (!path.contains(t)) {
                visit(t, path);
            }
        }
        path.removeLast();
    }

    public static void bfs(Node root) {
        LinkedList<Node> level = new LinkedList<>();
        LinkedList<Node> nextLevel = new LinkedList<>();
        LinkedList<Node> visited = new LinkedList<>();
        level.add(root);
        visited.add(root);
        visit2(level, nextLevel, visited);
    }

    private static void visit2(LinkedList<Node> level, LinkedList<Node> nextLevel, LinkedList<Node> visited) {
        for (Node t : level
        ) {
            for (Node t1 : t.getConnections()
            ) {
                // printNodes(nextLevel);///////
                if (!visited.contains(t1))
                    nextLevel.add(t1);

            }
        }
        printNodes(nextLevel);///////
        if (nextLevel.size() != 0) {
            level.clear();
            level.addAll(nextLevel);
            nextLevel.clear();
            visit2(level, nextLevel, visited);
        }
    }

    public static LinkedList<Node> crascal(LinkedList<Node> nodes, int[][] adjacencyMatrix) {
        LinkedList<Node> path = new LinkedList<>();
        int t = findMin(nodes, adjacencyMatrix);
        while (path.size() != nodes.size() - 1) {
            t = findMin(nodes, adjacencyMatrix);
            if (!path.contains(nodes.get(t))) {
                path.add(nodes.get(findMin(nodes, adjacencyMatrix)));
            }
            removeNode(adjacencyMatrix, t);
        }
        return path;
    }

    private static int findMin(LinkedList<Node> nodes, int[][] m) {
        int min = 10;
        int minI = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] < min && m[i][j] != 0) {
                    min = m[i][j];
                    minI = i;
                }
            }
        }
        return minI;
    }


    private static void printNodes(LinkedList<Node> list) {
        for (Node t : list
        ) {
            System.out.print(t.toString() + " ");
        }
        System.out.println();
    }

    private static void removeNode(int[][] adjacencyMatrix, int n) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                if (i == n || j == n) {
                    adjacencyMatrix[i][j] = 0;
                }
            }
        }
    }

    /*public int[] insertion_binary(int[] data){
        for
i in

range(len(data)):
key =data[i]
lo,hi =0,i -1
        while lo<hi:
mid =lo +(hi -lo) // 2
        if key<data[mid]:
hi =mid
        else:
lo =mid +1
        for
j in

range(i, lo +1, -1):
data[j]=data[j -1]
data[lo]=key
return data;
}*/
}
