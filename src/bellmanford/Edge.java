
package bellmanford;


public class Edge {
    
    private String n1;
    private String n2;
    private int weight;

    
    public Edge(String n1, String n2, int w) {
        
        this.n1 = n1;
        this.n2 = n2;
        this.weight = w;
    }
    
    public String getFirstNode() {
        
        return this.n1;
    }
    
    public String getSecondNode() {
        
        return this.n2;
    }
    
    public int getWeight() {
        
        return this.weight;
    }

}
