package interview.graph.util;

import interview.graph.Graph;

import java.io.InputStream;
import java.util.Scanner;

public class GraphBuilder {

    public static void build(Graph graph, String fileName) {
        InputStream file = GraphBuilder.class.getResourceAsStream(fileName);
        Scanner scan = new Scanner(file);

        int v = scan.nextInt();
        int e = scan.nextInt();
        // build graph.
        for (int i = 0; i < e; i++) {
            graph.addEdge(scan.nextInt(),scan.nextInt());
        }
    }

    /*public static void main(String[] args) {
        GraphBuilder.build("testG1.txt");
        System.out.println("========================");
        GraphBuilder.build("testG2.txt");
    }*/
}
