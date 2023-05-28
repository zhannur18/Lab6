public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacent Vertices; // with weights
    public void add Adjacent Vertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }
}
