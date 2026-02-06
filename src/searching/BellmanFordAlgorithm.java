package searching;

import java.util.*;

public class BellmanFordAlgorithm {

    // Edge class
    static class Edge {
        String source;
        String destination;
        int weight;

        Edge(String source, String destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Bellman-Ford method
    public static void bellmanFord(List<Edge> edges, Set<String> vertices, String source) {

        Map<String, Integer> distance = new HashMap<>();

        // Initialize distances
        for (String v : vertices) {
            distance.put(v, Integer.MAX_VALUE);
        }

        distance.put(source, 0);
        int V = vertices.size();

        // Relax edges V-1 times
        for (int i = 1; i <= V - 1; i++) {
            for (Edge edge : edges) {

                if (distance.get(edge.source) != Integer.MAX_VALUE) {

                    int newDist = distance.get(edge.source) + edge.weight;

                    if (newDist < distance.get(edge.destination)) {
                        distance.put(edge.destination, newDist);
                    }
                }
            }
        }

        // Check negative cycle
        for (Edge edge : edges) {
            if (distance.get(edge.source) != Integer.MAX_VALUE) {

                int newDist = distance.get(edge.source) + edge.weight;

                if (newDist < distance.get(edge.destination)) {
                    System.out.println("⚠ Negative cycle detected!");
                    return;
                }
            }
        }

        // Print result
        System.out.println("Shortest distances from source " + source + ":");
        for (String v : vertices) {
            System.out.println(source + " → " + v + " = " + distance.get(v));
        }
    }


    public static void main(String[] args) {

        List<Edge> edges = new ArrayList<>();
        Set<String> vertices = new HashSet<>();

        // Add edges
        edges.add(new Edge("A", "B", 4));
        edges.add(new Edge("A", "C", 5));
        edges.add(new Edge("B", "C", -3));
        edges.add(new Edge("C", "D", 4));
        edges.add(new Edge("D", "B", 2));

        // Add vertices
        vertices.add("A");
        vertices.add("B");
        vertices.add("C");
        vertices.add("D");

        // Run algorithm
        bellmanFord(edges, vertices, "A");
    }
}
