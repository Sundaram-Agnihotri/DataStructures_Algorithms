import java.util.Scanner;
import java.util.*;

public class Prims_Algortihm {

    public static int findMinVertex(boolean[] visited, int[] weight) {

        int minVertex = -1;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void prims(int adjMatrix[][]) {
        int n = adjMatrix.length;
        boolean visited[] = new boolean[n];
        int parent[] = new int[n];
        int weight[] = new int[n];

        // source -> vertex = 0
        parent[0] = -1;
        weight[0] = 0;

        for (int i = 1; i < n; i++) {
            weight[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            int minVertex = findMinVertex(visited, weight);
            if (adjMatrix[minVertex][i] != 0 && !visited[i]) { // add the weight corresponds to minvertex
                if (weight[i] > adjMatrix[minVertex][i]) {
                    // update the weight
                    weight[i] = adjMatrix[minVertex][i];
                    parent[i] = minVertex;
                }

            }
        }

        // print the mst
        for (int i = 1; i < n; i++) {
            if (i < parent[i])
                System.out.println(i + " " + parent[i] + " " + weight[i]);

            else
                System.out.println(parent[i] + " " + i + " " + weight[i]);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        int adjMatrix[][] = new int[n][n];

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();

            adjMatrix[v1][v2] = weight;
            adjMatrix[v2][v1] = weight;
        }
        prims(adjMatrix);
    }
}
