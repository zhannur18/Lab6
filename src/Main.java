public class Main {
    public static void main(String[] args) {
        MyGraph<String> graph = new MyGraph<>();

        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");
        Vertex<String> v4 = new Vertex<>("D");
        Vertex<String> v5 = new Vertex<>("E");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        graph.addEdge(v1, v2, 3); // Add an edge from v1 to v2 with weight 3
        graph.addEdge(v1, v3, 2); // Add an edge from v1 to v3 with weight 2
        graph.addEdge(v2, v4, 5); // Add an edge from v2 to v4 with weight 5
        graph.addEdge(v3, v4, 1); // Add an edge from v3 to v4 with weight 1
        graph.addEdge(v3, v5, 4); // Add an edge from v3 to v5 with weight 4
        graph.addEdge(v4, v5, 2); // Add an edge from v4 to v5 with weight 2

        graph.printGraph(); // Print the graph structure
        graph.Dijkstra(0);
    }
}