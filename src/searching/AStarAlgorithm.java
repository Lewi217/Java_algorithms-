package searching;

import java.util.*;


/*
    this is an implementation of A* (A star) algorithm in java
    A* is a popular pathfinding and graph traversal algorithm used in computer science and artificial intelligence
    it finds the shortest path from a start node to a goal node in a weighted graph
    A* uses a heuristic function to estimate the cost of reaching the goal from a given node
    it combines the actual cost from the start node to the current node (g(n)) and the estimated cost from the current node to the goal (h(n))
    the total cost function is defined as f(n) = g(n) + h(n)
    A* maintains two lists:
    1. open list: contains nodes that need to be evaluated
    2. closed list: contains nodes that have already been evaluated
  */
public class AStarAlgorithm {
    // Node class
    static class Node implements Comparable<Node> {
        String name;
        Node parent;
        double g; // distance from start
        double h; // heuristic (estimated to goal)
        double f; // total cost

        Node(String name) {
            this.name = name;
        }

        void calculateF() {
            this.f = g + h;
        }

        @Override
        public int compareTo(Node other) {
            return Double.compare(this.f, other.f);
        }
    }
    // A -> B cost =

    // Edge class
    static class Edge {
        String target;
        double cost;

        Edge(String target, double cost) {
            this.target = target;
            this.cost = cost;
        }
    }

    // A -> B (cost = 1)
    // A -> G estimated = 7
    // B -> G estimated = 6
    // G -> G  estimated  = 0
    // Graph
    static Map<String, List<Edge>> graph = new HashMap<>();

    // Heuristic values (estimated distance to goal)
    static Map<String, Double> heuristic = new HashMap<>();

    // A* Algorithm
    public static List<String> aStar(String start, String goal) {

        PriorityQueue<Node> openList = new PriorityQueue<>();
        Set<String> closedList = new HashSet<>();
        Map<String, Node> allNodes = new HashMap<>();
// start  = A ,,,, goal = G
        Node startNode = new Node(start);
        startNode.g = 0;
        startNode.h = heuristic.get(start);
        startNode.calculateF();
        // g= 0,,,h=7,,,f = 7

        openList.add(startNode);
        allNodes.put(start, startNode);

        while (!openList.isEmpty()) {
            Node current = openList.poll();

            // Goal reached
            if (current.name.equals(goal)) {
                return reconstructPath(current);
            }

            closedList.add(current.name);

            for (Edge edge : graph.getOrDefault(current.name, new ArrayList<>())) {

                if (closedList.contains(edge.target))
                    continue;

                double newG = current.g + edge.cost;

                Node neighbor = allNodes.getOrDefault(edge.target, new Node(edge.target));

                if (!allNodes.containsKey(edge.target) || newG < neighbor.g) {

                    neighbor.g = newG;
                    neighbor.h = heuristic.get(edge.target);
                    neighbor.calculateF();
                    neighbor.parent = current;

                    openList.add(neighbor);
                    allNodes.put(edge.target, neighbor);
                }
            }
        }

        return new ArrayList<>(); // No path found
    }

    // Reconstruct path from goal to start
    private static List<String> reconstructPath(Node goal) {
        List<String> path = new ArrayList<>();
        Node current = goal;

        while (current != null) {
            path.add(current.name);
            current = current.parent;
        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {

        /*
         Graph structure

              A
            /   \
           B     C
         /  \     \
        D    E     F
         \  / \   /
           G   ----

        Goal = G
        */

        //  joined part the 2 roads ....intersection
        //  from A to F ....possible ...A-> C -> D -> F
        //  A -> E -> F
        // A -> B (F(n) = g(n) + h(n))   4, 6 , 10
        // A -> C 3 , 4 , 7
        // A -> E 6, 2, 8
        // A* picks (a->c)


        // Graph connections
        graph.put("A", Arrays.asList(new Edge("B", 1), new Edge("C", 3)));
        graph.put("B", Arrays.asList(new Edge("D", 1), new Edge("E", 5)));
        graph.put("C", Arrays.asList(new Edge("F", 2)));
        graph.put("D", Arrays.asList(new Edge("G", 1)));
        graph.put("E", Arrays.asList(new Edge("G", 2)));
        graph.put("F", Arrays.asList(new Edge("G", 1)));

        // Heuristic values to goal G
        heuristic.put("A", 7.0);
        heuristic.put("B", 6.0);
        heuristic.put("C", 4.0);
        heuristic.put("D", 2.0);
        heuristic.put("E", 1.0);
        heuristic.put("F", 1.0);
        heuristic.put("G", 0.0);

        // Run A*
        List<String> path = aStar("A", "G");

        System.out.println("Shortest path using A*: " + path);
    }
}
