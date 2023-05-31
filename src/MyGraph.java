import java.util.ArrayList;
import java.util.HashMap;

public class MyGraph {
    private Map<Vertex<V>, List<Edge<V>>> graph; // Map to store vertices and their associated edges


    public MyGraph() {
        this.graph = new HashMap<>(); // Initializes the map
    }

    public void addVertex(Vertex<V> vertex) {
        graph.put(vertex, new ArrayList<>()); // Adds a vertex to the map with an empty list of edges
    }


    public void addEdge(V sourceKey, V destinationKey, double weight) { // add the edges by entering key
        Vertex<V> source = graph.get(sourceKey);
        Vertex<V> destination = graph.get(destinationKey);
        source.addAdjacentVertex(destination, weight);
        destination.addAdjacentVertex(source, weight);
    }
    public void printGraph() {
        for (Vertex<V> vertex : graph.keySet()) {
            System.out.print(vertex.getData() + " -> ");//Prints the data of the current vertex followed by "->".
            for (Vertex<V> neighbor : graph.get(vertex)) {
                System.out.print(neighbor.getData() + " ");//Prints the data of each adjacent vertex separated by a space.

            }
            System.out.println();
        }
    }
}
