import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class MyGraph<V> {
    private Map<Vertex<V>, List<Edge<V>>> graph; // Map to store vertices and their associated edges


    public MyGraph() {
        this.graph = new HashMap<>(); // Initializes the map
    }

    public void addVertex(Vertex<V> vertex) {
        graph.put(vertex, new ArrayList<>()); // Adds a vertex to the map with an empty list of edges
    }


    public void addEdge(V sourceKey, V destinationKey, double weight) { // add the edges by entering key
        Vertex<V> source = (Vertex<V>) graph.get(sourceKey);
        Vertex<V> destination = (Vertex<V>) graph.get(destinationKey);
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
    public void removeEdge(Vertex<V> source, Vertex<V> destination) {//Removes an edge between two vertices in the graph.

        if (!graph.containsKey(source)) {
            throw new IllegalArgumentException("Vertex not found in the graph.");
        } else if (!graph.containsKey(destination)) {
            throw new IllegalArgumentException("Vertex not found in the graph.");
        }

        source.getAdjacentVertices().remove(destination);// Removes the destination vertex from the adjacent vertices of the source vertex
        destination.getAdjacentVertices().remove(source);// Removes the source vertex from the adjacent vertices of the destination vertex


        graph.get(source).remove(destination);// Removes the destination vertex from the list of neighbors of the source vertex in the graph
        graph.get(destination).remove(source);// Removes the source vertex from the list of neighbors of the destination vertex in the graph

    }
    public boolean hasEdge(Vertex<V> source, Vertex<V> destination) {
        if (!graph.containsKey(source) || !graph.containsKey(destination)) {  // Check if both source and destination vertices exist in the graph
            throw new IllegalArgumentException("Vertex not found in the graph.");  // Throw an exception if any of the vertices is not found
        }

        return graph.get(source).contains(destination);  // Return whether the source vertex's adjacency list contains the destination vertex
    }

    public List<Vertex<V>> getNeighbours(Vertex<V> vertex) {
        if (!graph.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex not found in the graph.");
        }

        return graph.get(vertex);
    }
    public void BFS(Vertex<V> start) {
        if (!graph.getGraph().containsKey(start)) {  // Check if the start vertex exists in the graph
            throw new IllegalArgumentException("Vertex not found in the graph.");
        }

        Set<Vertex<V>> visited = new HashSet<>();  // Create a set to store visited vertices
        Queue<Vertex<V>> queue = new LinkedList<>();  // Create a queue for BFS traversal

        visited.add(start);  // Mark the start vertex as visited
        queue.add(start);  // Add the start vertex to the queue

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();  // Dequeue the vertex at the front of the queue
            System.out.print(current.getData() + " ");  // Process the current vertex

            for (Vertex<V> neighbor : graph.getNeighbours(current)) {  // Iterate over the neighbors of the current vertex
                if (!visited.contains(neighbor)) {  // If the neighbor has not been visited
                    visited.add(neighbor);  // Mark the neighbor as visited
                    queue.add(neighbor);  // Add the neighbor to the queue for further traversal
                }
            }
        }
    }
    public void Dijkstra(int source) {
        if (!graph.getGraph().containsKey(source)) {  // Check if the source vertex exists in the graph
            throw new IllegalArgumentException("Vertex not found in the graph.");  // Throw an exception if the source vertex is not found
        }

        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();  //a map to store previous vertices in the shortest paths
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));  // Create a priority queue based on distances

        for (Vertex<V> vertex : graph.getClass().keySet()) {  // Initialize distances and previous maps
            distances.put(vertex, Double.POSITIVE_INFINITY);
            previous.put(vertex, null);
        }

        distances.put(source, 0.0);  // Set the distance of the source vertex to 0
        queue.add(source);  // Add the source vertex to the priority queue

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();  // Retrieve the vertex with the smallest distance from the priority queue

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {  // Iterate over the adjacent vertices of the current vertex
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double distance = distances.get(current) + weight;  // Calculate the distance to the neighbor through the current vertex

                if (distance < distances.get(neighbor)) {  // If the calculated distance is smaller than the current distance to the neighbor
                    distances.put(neighbor, distance);
                    previous.put(neighbor, current);  // Set the previous vertex in the shortest path to the neighbor
                    queue.remove(neighbor);  // Updateting priority in the queue by removing and re-adding the neighbor
                    queue.add(neighbor);
                }
            }
        }

        for (Vertex<V> vertex : distances.keySet()) {
            System.out.println("Distance from " + source.getData() + " to " + vertex.getData() + ": " + distances.get(vertex));
        }
    }

}
