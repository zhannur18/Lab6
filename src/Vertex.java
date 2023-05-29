public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacent Vertices;
    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public V getData() {//returns the data associated with this vertex
        return data;
    }}
