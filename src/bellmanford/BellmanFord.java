package bellmanford;

import java.util.HashMap;

public class BellmanFord {

    private Graph G;
    private HashMap<String, Integer> distance;
    private HashMap<String, String> path;

    public BellmanFord(Graph G) {

        this.G = G;
        distance = new HashMap<>();
        path = new HashMap<>();
    }

    private void initializeSingleSource(String start) {

        for (String n : G.getNodes()) {
            distance.put(n, 999999999);
            path.put(n, null);
        }
        distance.put(start, 0);
    }

    public void shortestDistanceBetween(String a, String b) {

        if (!validArgument(a)) {
            printInvalid(a);
        } else if (!validArgument(b)) {
            printInvalid(b);
        } else if (runAlgorithm(a)) {
            printDistance(a, b);
        } else {
            System.out.println("Negative cycle");
        }
    }

    public void shortestDistanceToAllFrom(String a) {

        if (!validArgument(a)) {
            printInvalid(a);
        } else if (runAlgorithm(a)) {
            for (String s : distance.keySet()) {
                printDistance(a, s);
            }
        } else {
            System.out.println("Negative cycle");
        }
    }

    private boolean runAlgorithm(String start) {

        initializeSingleSource(start);
        for (int i = 1; i < G.getNodes().size(); i++) {
            for (Edge e : G.getEdges()) {
                relax(e.getFirstNode(), e.getSecondNode(), e.getWeight());
            }
        }
        for (Edge e : G.getEdges()) {
            if (distance.get(e.getSecondNode()) > distance.get(e.getFirstNode()) + e.getWeight()) {
                return false;
            }
        }
        return true;
    }

    private void relax(String u, String v, int w) {

        if (distance.get(v) > distance.get(u) + w) {
            distance.put(v, distance.get(u) + w);
            path.put(v, u);
        }
    }

    private boolean validArgument(String s) {

        return G.getNodes().contains(s);
    }

    private void printInvalid(String s) {

        System.out.println("Node \"" + s + "\" does not exist!");
    }

    private void printDistance(String s, String t) {

        System.out.println("Shortest distance between " + s + " and " + t + ": " + distance.get(t));
    }
}
