public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacent Vertices;
    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }
    public void addAdjacentVertex(Vertex<V> destination, double weight) {//Adds an adjacent vertex with the given weight
        adjacentVertices.put(destination, weight);
    }
    public V getData() {//returns the data associated with this vertex
        return data;
    }
}