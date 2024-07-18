/*
1) `implements Comparable<Edge>`

=> This line declares that the `Edge` class implements the `Comparable` interface, specifically for
   comparing `Edge` objects. The `Comparable` interface is part of Java's core libraries and is used
   to define a natural ordering for a class.

2) `@Override public int compareTo(Edge other) { return this.weight - other.weight; }`

=> This is the implementation of the `compareTo` method required by the `Comparable` interface.
   Let's examine it in more detail :-
- `@Override`: This annotation indicates that the method is intended to override a method in a superclass or implement a method from an interface.
- `public int compareTo(Edge other)`: This is the method signature. It takes another `Edge` object as a parameter and returns an integer.
- `return this.weight - other.weight;`: This is the comparison logic.

The `compareTo` method should return:
- A negative integer if this object is considered less than the other object
- Zero if they are considered equal
- A positive integer if this object is considered greater than the other object

In this case, it's comparing the weights of the edges. If `this.weight` is less than `other.weight`,
it will return a negative number, indicating that `this` edge should be considered "smaller"
(or come before) the `other` edge.

The purpose of implementing `Comparable` and defining `compareTo` in this way is to allow the `Edge` objects
to be sorted based on their weights. This is crucial for Kruskal's algorithm, which needs to consider
edges in order from lowest weight to highest weight.

When you use `Collections.sort(edges)` in the `spanningTree` method, it uses this `compareTo` method to
determine the order of the edges. This ensures that the algorithm considers the edges in ascending order
of their weights, which is essential for finding the minimum spanning tree.
 */

package _11_Graphs;
import java.util.*;

// Kruskal's Algorithm : 1) Greedy Algo + 2) No Cycle => Not same subset
public class Kruskal {

    // means class 'Edge' is only comparable/compared-to other 'Edge' objects => To sort edges wrt to edgeWt
    static class Edge implements Comparable<Edge> {
        int u, v, wt;
        public Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
        // Function Definition which implements the comparasion b/w edges
        @Override
        public int compareTo(Edge other) {
            return this.wt - other.wt;
        }
    }

    // Create Disjoint Set data structure
    static class DisjointSet {
        int[] par, rank;
        public DisjointSet(int V) { // 0-based indexing
            par = new int[V];
            rank = new int[V];
            for (int i = 0; i < V; i++) {
                par[i] = i; // each parent of itself at first
                rank[i] = 0;
            }
        }

        public int findPar(int x) {
            if (par[x] != x) {
                par[x] = findPar(par[x]); // Path Compression
            }
            return par[x];
        }
        // Union by Rank
        public void union(int x, int y) {
            int px = findPar(x);
            int py = findPar(y);

            if (px != py) { // different subset
                if (rank[px] < rank[py]) {
                    par[px] = py;
                }
                else if (rank[py] < rank[px]) {
                    par[py] = px;
                }
                else {
                    par[py] = px;
                    rank[px]++;
                }
            }
        }

        public boolean isConnected(int x, int y) {
            return findPar(x) == findPar(y);
        }
    }

    // GFG funtion
    // adj -> 0 : [1, 5]  =>  u : [v, wt]
    static class Solution {
        static int spanningTree(int V, int E, List<List<int[]>> adj) {
            // convert adjList to edgeList
            List<Edge> edgeList = new ArrayList<>();
            for (int u = 0; u < V; u++) {
                for (int[] edge : adj.get(u)) {
                    int v = edge[0], wt = edge[1];
                    edgeList.add(new Edge(u, v, wt));
                }
            }
            Collections.sort(edgeList); // sort wrt to 'wt's => Build tree with min paths

            DisjointSet ds = new DisjointSet(V); // initialise the DS data structure

            List<Edge> MST = new ArrayList<>(); // Store all MST Edges
            int MSTwt = 0;

            for (Edge edge : edgeList) {
                int u = edge.u, v = edge.v, wt = edge.wt;

                if (!ds.isConnected(u, v)) {
                    MSTwt += wt;
                    MST.add(new Edge(u, v, wt));
                    ds.union(u, v); // build the MST
                }
            }

            return MSTwt;
        }
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        int E = 5; // Number of edges

        // Create adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges: [v, weight]
        adj.get(0).add(new int[]{1, 5});
        adj.get(0).add(new int[]{2, 1});
        adj.get(1).add(new int[]{2, 3});
//        adj.get(0).add(new int[]{1, 10});
//        adj.get(0).add(new int[]{2, 6});
//        adj.get(0).add(new int[]{3, 5});
//        adj.get(1).add(new int[]{3, 15});
//        adj.get(2).add(new int[]{3, 4});

        // Create Solution object
        Solution soln = new Solution();

        // Call spanningTree method
        int mstWeight = soln.spanningTree(V, E, adj);

        // Print the result
        System.out.println("Weight of the Minimum Spanning Tree: " + mstWeight);
    }
}
