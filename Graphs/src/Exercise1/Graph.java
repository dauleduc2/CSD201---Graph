
import java.util.*;

public class Graph {

    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // breadthFirstTraverse algorithm
    void breadthFirstTraverse(int s) {

        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    void depthFirstTraverse(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    static void printGraph(int[][] adj, String[] label, int n) {
        System.out.print("   ");
        for (int i = 0; i < n; i++) {
            System.out.print(label[i] + "  ");
        }
        System.out.println("");

        for (int i = 0; i < n; i++) {
            System.out.print(label[i] + "  ");
            for (int j = 0; j < n; j++) {
                System.out.print(adj[i][j] + "  ");
            }
            System.out.println();
        }
    }

    static void addEdge(int[][] adj,
            int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    public static void main(String args[]) {
        int n = 9;
        Graph g = new Graph(n);

        int[][] a = new int[n][n];
        addEdge(a, 0, 1);
        addEdge(a, 0, 2);
        addEdge(a, 0, 3);
        addEdge(a, 1, 2);
        addEdge(a, 1, 3);
        addEdge(a, 2, 3);
        addEdge(a, 3, 5);
        addEdge(a, 4, 5);
        addEdge(a, 6, 7);
        addEdge(a, 6, 8);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = a[i][j];
                if (k == 1) {
                    g.addEdge(i, j);
                }
            }

        }
        String[] label = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 0)");
        g.breadthFirstTraverse(0);
        System.out.println("");
        System.out.println(
                "Following is Depth First Traversal "
                + "(starting from vertex 0)");

        g.depthFirstTraverse(0);
        System.out.println();
        printGraph(a, label, n);
    }
}
