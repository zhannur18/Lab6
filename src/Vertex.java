import java.util.ArrayList;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;
    public Vertex(V data) {
        this.data = data;
        adjacentVertices = new HashMap<>();
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {//Adds an adjacent vertex with the given weight
        adjacentVertices.put(destination, weight);
    }

    public void removeAdjacentVertex(Vertex<V> destination){
        map.remove(destination);//edge removal
    }
    public V getData() {//returns the data associated with this vertex
        return data;
    }
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices; // Returns the map of adjacent vertices and their weights
    }
    public ArrayList<Vertex<V>> getNeighbours(){ // to get all the vertices that are connected to this
        ArrayList<Vertex<V>> neighbours = new ArrayList<>(); // vertices are stores in ArrayList before returning
        for(Vertex<V> vertex: adjacentVertices.keySet()) {
            neighbours.add(vertex);
        }
        return neighbours;
    }

    public boolean hasEdge(Vertex<V> destination){
        if (adjacentVertices.containsKey(destination)) {
            return true;
        } else {
            return false;
        }
    }



    public double getEdgeWeight(Vertex<V> neighbor) {
        return adjacentVertices.get(neighbor);
    }
}