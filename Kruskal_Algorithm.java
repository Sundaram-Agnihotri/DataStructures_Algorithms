import java.util.Scanner;
import java.util.*;

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int weight;

    Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        // return poitive if firts edge is larger than second edge ; Second edge is the
        // edge which is to pass as an argument
        // first edge is the edge for which the function called;
        return this.weight - o.weight;
    }
}

public class Solution {

public static int findParent(int v1, int[] parent) {

        if (v1 == parent[v1]) {
            return v1;

        }

        return findParent(parent[v1], parent);
    }

    public static Edge[] kruskal(Edge edges[], int n) {

        Arrays.sort(edges);
        Edge mst[] = new Edge[n - 1];
        int parent[] = new int[n];

        // assign the parent of each vertices to the index itself
        for (int j = 0; j < n; j++) {
            parent[j] = j;
        }
        int count = 0, i = 0;

        while (count != n - 1) {
            Edge currEdge = edges[i++];
            int v1Parent = findParent(currEdge.v1, parent); // find parent of v1
            int v2Parent = findParent(currEdge.v2, parent); // find parent of v2

            if (v1Parent != v2Parent) {
                mst[count] = currEdge;
                count++;
                parent[v1Parent] = v2Parent;
                // including that edge

            }
        }

        return mst;

    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();

		Edge[] edges = new Edge[e];

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();

            Edge edge = new Edge(v1, v2, weight); // assigning the values to constructor
            edges[i] = edge;
        }

        Edge mst[] = kruskal(edges, n);

        for (int i = 0; i < mst.length; i++) {
            if (mst[i].v1 < mst[i].v2) {
                System.out.println(mst[i].v1 + " " + mst[i].v2 + ' ' + mst[i].weight);
            } else {
                System.out.println(mst[i].v2 +  " " + mst[i].v1 + ' ' + mst[i].weight);
            }
        }

	}
}
