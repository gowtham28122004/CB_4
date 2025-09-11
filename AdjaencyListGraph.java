import java.util.*;

class AdjaencyListGraph {
    private Map<Integer, List<Integer>> adjencyList;
    
    public AdjaencyListGraph() {
        this.adjencyList = new HashMap<>();
    }
    
    public void addVertex(int vertex) {
        adjencyList.put(vertex, new LinkedList<>());
    }
    
    public void removeVertex(int vertex) {
        adjencyList.remove(vertex);
        
        for(List<Integer> neighbors : adjencyList.values()) {
            neighbors.remove((Integer) vertex);
        }
    }
    public void addEdge(int source,int destination) {
        adjencyList.get(source).add(destination);
        adjencyList.get(destination).add(source);
    }
    
    public void removeEdge(int source,int destination) {
        adjencyList.get(source).remove(destination);
        adjencyList.get(destination).remove(source);
    }
    
    public static void manin(String[] args) {
        AdjaencyListGraph graph = new AdjaencyListGraph();
        
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 3);
        
        graph.removeVertex(4);
        
        
    }
}
