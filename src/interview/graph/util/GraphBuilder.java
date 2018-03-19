package interview.graph.util;

import java.io.InputStream;
import java.util.Scanner;

public class GraphBuilder {

    public static void build(String fileName) {
        InputStream file = GraphBuilder.class.getResourceAsStream(fileName);
        Scanner scan = new Scanner(file);

        int v = scan.nextInt();
        int e = scan.nextInt();

        for (int i = 0; i < e; i++) {
            System.out.println(scan.next() + " " + scan.nextInt());
        }
    }

    public static void main(String[] args) {
        GraphBuilder.build("testG1");
        System.out.println("========================");
        GraphBuilder.build("testG2");
    }
}
