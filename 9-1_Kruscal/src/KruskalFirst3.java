import java.util.*;

class Edge implements Comparable<Edge> {
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}

public class KruskalFirst3 {

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }

    public static void main(String[] args) {

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(3, 5, 1));
        edges.add(new Edge(3, 1, 3));
        edges.add(new Edge(0, 4, 4));
        edges.add(new Edge(5, 6, 5));
        edges.add(new Edge(1, 6, 6));
        edges.add(new Edge(0, 2, 7));
        edges.add(new Edge(3, 6, 7));
        edges.add(new Edge(4, 3, 8));
        edges.add(new Edge(0, 3, 9));
        edges.add(new Edge(2, 1, 10));
        edges.add(new Edge(5, 4, 13));
        edges.add(new Edge(0, 1, 15));

        int n = 7; // 정점 0~6

        Collections.sort(edges);

        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        int count = 0;
        int sum = 0;

        for (Edge e : edges) {
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                sum += e.w;
                count++;
                System.out.println("선택된 간선: (" + e.u + ", " + e.v + ") = " + e.w);

                if (count == 3)
                    break;
            }
        }

        System.out.println("\nKruskal 처음 3개의 가중치 합 = " + sum);
    }
}