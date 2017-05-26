package bellmanford;

import java.util.ArrayList;
import java.util.HashSet;

public class Graph {

    private HashSet<String> nodes;
    private ArrayList<Edge> edges;

    public Graph(ArrayList<Edge> edges) {

        this.nodes = new HashSet<>();
        this.edges = edges;

        for (Edge edge : edges) {
            nodes.add(edge.getFirstNode());
            nodes.add(edge.getSecondNode());
        }
    }

    public HashSet<String> getNodes() {

        return nodes;
    }

    public ArrayList<Edge> getEdges() {

        return edges;
    }
}
