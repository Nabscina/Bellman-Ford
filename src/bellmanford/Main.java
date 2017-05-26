package bellmanford;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        ArrayList<Edge> edges = new ArrayList<>();

        Edge e1 = new Edge("a", "b", 8);
        Edge e2 = new Edge("a", "c", 17);
        Edge e3 = new Edge("a", "e", 23);
        Edge e4 = new Edge("b", "c", 4);
        Edge e5 = new Edge("b", "d", 15);
        Edge e6 = new Edge("b", "f", 7);
        Edge e7 = new Edge("c", "a", 17);
        Edge e8 = new Edge("d", "c", 16);
        Edge e9 = new Edge("d", "g", 15);
        Edge e10 = new Edge("d", "h", 10);
        Edge e11 = new Edge("e", "f", 6);
        Edge e12 = new Edge("f", "e", 6);
        Edge e13 = new Edge("f", "g", 13);
        Edge e14 = new Edge("h", "d", 10);
        Edge e15 = new Edge("h", "g", 1);

        Collections.addAll(edges, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15);
        Graph G = new Graph(edges);
        BellmanFord BF = new BellmanFord(G);

//        No path from node x to y --> distance is 999999999
//        "Negative cycle" if your graph has one
        BF.shortestDistanceToAllFrom("g");
    }

}
