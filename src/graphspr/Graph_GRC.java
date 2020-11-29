package graphspr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// To depict the graph in a visible way I've used an adjacency list instead of a matrix
// This is nothing but a linked list and each node in the list represents a vertex
// The Edge and Graph classes are self explanatory
// It is important because it gives us a graphical representation of the nodes and its weights
// so we can visually infer which one has the shortest path to get from source and destination


class Edge {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    static class Node {
        int value, weight;

        Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    // Define the adjacency list

    List<List<Node>> adj_list = new ArrayList<>();

    // Graph constructor

    public Graph(List<Edge> edges) {
        for (int i = 0; i < edges.size(); i++) {
            adj_list.add(i, new ArrayList<>());
        }

        // add edges to the graph

        for (Edge e : edges) {
            adj_list.get(e.src).add(new Node(e.dest, e.weight));
        }
    }

    // Print Graph

    static void printGraph(Graph graph) {
        int src_vertex = 0;
        int list_size = graph.adj_list.size();

        System.out.println("Contents of the Graph: \n");

        while (src_vertex < list_size) {
            for (Node edge : graph.adj_list.get(src_vertex)) {
                System.out.print("Vertex: " + src_vertex + " ==> " + edge.value + " (" + edge.weight + ")\t");
            }
            System.out.println();
            src_vertex++;
        }
    }
}

public class Graph_GRC {
    public static void main(String[] args) {
        // Defining edges
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 2), new Edge(0, 2, 4),
                new Edge(1, 2, 4), new Edge(2, 0, 5),
                new Edge(2, 1, 4), new Edge(3, 2, 3),
                new Edge(4, 5, 1), new Edge(5, 4, 3)
        );
        Graph graph = new Graph(edges); // Calling the graph constructor o build a graph

        Graph.printGraph(graph); //printing the graph

    }
}
