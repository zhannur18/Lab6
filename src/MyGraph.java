public class MyGraph {
    private Map<Vertex<V>, List<Edge<V>>> map; // Map to store vertices and their associated edges
    public MyGraph() {
        this.map = new HashMap<>(); // Initializes the map
    }

    public void addVertex(Vertex<V> vertex) {
        map.put(vertex, new ArrayList<>()); // Adds a vertex to the map with an empty list of edges
    }
}
