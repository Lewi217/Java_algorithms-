package searching;

import java.util.*;

/*
  Bellman–Ford is a shortest path algorithm used to find the shortest distance from a starting node to all other nodes in a graph.

It is similar to Dijkstra, BUT:

Bellman–Ford can work with negative weights.

That is the biggest difference.

if distance [u] + weight < distance[v]
update distance [v]
start  = A
distance [A] = 0
distance [B] = infinity
distance [C] = infinity
A --4- B
1|\
C \
    5\
      D
      a graph can have most V-1 edges ....
 for i  = 1 to V - 1
  check all edges
   Usd -> Kes -> euro -> rand
   Usd -> kes  = +10
   kes -> euro = +5
   euro -> rand =+2
   total gain= 17  this is called a negative cycle in graph (profit loop)
    A higher mbps ....result to a higher pay ...due to the shortest distance traveled ...

   A -> D (a -> b -> c -> d)
   A -> B =4
   A -> C =5
   B -> C = -6
   C -> D = 2
   4+5+(-6)+2 = 5...

    A -> B = 2
    B -> C =-4
    C -> A = 1

    2 + (-4) + 1 = -1 (negative cycle)

    Time Complexity = 0(V  X  E)
    V = Vertices
    E = Edges


*\
 */
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

    /*
      1. Start from source A
      2. Set all distances to infinity
      3. Relax all edges V-1 times
      4. Update shorter paths
      5. Check negative cycle
      6. Print the shortest path
     */

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
