package searching;


/*
Floyd-Warshall Algorithm is a dynamic programming algorithm used to find the shortest paths in a weighted graph with positive or negative edge weights (but with no negative cycles). The algorithm works by iteratively updating a distance matrix that represents the shortest path between pairs of vertices.
The main idea is to consider each vertex as an intermediate point and check if a path through that vertex is shorter than the previously known paths. The algorithm has a time complexity of O(V^3), where V is the number of vertices in the graph.

 */
public class FloydWarshall {
    final static int INF = 99999;

    public static void floydWarshall(int[][] graph) {

        int V = graph.length;

        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Floyd-Warshall Algorithm
        for (int k = 0; k < V; k++) {          // Intermediate vertex
            for (int i = 0; i < V; i++) {      // Source
                for (int j = 0; j < V; j++) {  // Destination

                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist);
    }

    public static void printSolution(int[][] dist) {

        System.out.println("Shortest distances between every pair of vertices:");

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {

                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] graph = {
                {0,   3,   INF, 5},
                {2,   0,   INF, 4},
                {INF, 1,   0,   INF},
                {INF, INF, 2,   0}
        };

        floydWarshall(graph);
    }
}
