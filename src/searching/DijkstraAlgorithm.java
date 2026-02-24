package searching;

import java.util.*;

class DijkstraAlgorithm {

    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static void dijkstra(List<List<Edge>> graph, int source) {

        int n = graph.size();
        int[] distance = new int[n];

        // Step 1: Set all distances to infinity
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Distance to source is 0
        distance[source] = 0;

        // PriorityQueue stores (distance, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.add(new int[]{0, source});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();
            int currentDist = current[0];
            int node = current[1];

            // Ignore outdated distances
            if (currentDist > distance[node])
                continue;

            // Step 2: Explore neighbors
            for (Edge edge : graph.get(node)) {

                int neighbor = edge.target;
                int weight = edge.weight;

                // Step 3: Relaxation
                if (distance[node] + weight < distance[neighbor]) {

                    distance[neighbor] = distance[node] + weight;

                    pq.add(new int[]{distance[neighbor], neighbor});
                }
            }
        }  
        // O(n log n) due to priority queue operations



        // Print shortest distances
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + " -> Distance: " + distance[i]);
        }
    }

    public static void main(String[] args) {

        int nodes = 4;
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < nodes; i++)
            graph.add(new ArrayList<>());

        // Add edges (u -> v, weight)
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 1));

        graph.get(2).add(new Edge(1, 2));
        graph.get(1).add(new Edge(3, 5));

        graph.get(2).add(new Edge(3, 3));

        dijkstra(graph, 0);
    }
}
