import java.util.*;

class Edge2 implements Comparable<Edge2> {
    int u, v, w;

    Edge2(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public int compareTo(Edge2 o) {
        return this.w - o.w;
    }
}

public class PrimFirst3 {

    public static void main(String[] args) {

        int n = 7;
        List<List<Edge2>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        // 간선 추가
        add(graph, 3, 5, 1);
        add(graph, 3, 1, 3);
        add(graph, 0, 4, 4);
        add(graph, 5, 6, 5);
        add(graph, 1, 6, 6);
        add(graph, 0, 2, 7);
        add(graph, 3, 6, 7);
        add(graph, 4, 3, 8);
        add(graph, 0, 3, 9);
        add(graph, 2, 1, 10);
        add(graph, 5, 4, 13);
        add(graph, 0, 1, 15);

        boolean[] visited = new boolean[n];
        PriorityQueue<Edge2> pq = new PriorityQueue<>();

        int start = 0;
        visited[start] = true;
        pq.addAll(graph.get(start));

        int count = 0;
        int sum = 0;

        while (!pq.isEmpty()) {
            Edge2 e = pq.poll();

            if (visited[e.v])
                continue;

            visited[e.v] = true;
            sum += e.w;
            count++;

            System.out.println("선택된 간선: (" + e.u + ", " + e.v + ") = " + e.w);

            if (count == 3)
                break;

            pq.addAll(graph.get(e.v));
        }

        System.out.println("\nPrim 처음 3개의 가중치 합 = " + sum);
    }

    static void add(List<List<Edge2>> g, int a, int b, int w) {
        g.get(a).add(new Edge2(a, b, w));
        g.get(b).add(new Edge2(b, a, w));
    }
}