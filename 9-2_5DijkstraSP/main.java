import java.util.*;

public class main {
	public static void main(String[] args) {
		int[][] weight = { // 그림의 입력 그래프
				// 0 1 2 3 4
				{ 0, 10, 0, 5, 0 }, // 0 →
				{ 0, 0, 1, 2, 0 }, // 1 →
				{ 0, 0, 0, 0, 6 }, // 2 →
				{ 0, 0, 9, 0, 2 }, // 3 →
				{ 7, 0, 6, 0, 0 } // 4 →
		};
		int N = weight.length;
		List<Edge>[] adjList = new List[N];
		for (int i = 0; i < N; i++) { // 인접리스트 만들기
			adjList[i] = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				if (weight[i][j] != 0) {
					Edge e = new Edge(i, j, weight[i][j]);
					adjList[i].add(e);
				}
			}
		}
		DijkstraSP d = new DijkstraSP(adjList);

		System.out.println("정점 0으로부터의 최단거리(D)");
		int[] distance = d.shortestPath(0);

		for (int i = 0; i < distance.length; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				System.out.println("0과 " + i + " 사이에 경로 없음.");
			else
				System.out.println("[0, " + i + "] = " + distance[i]);
		}

		System.out.printf("\n정점 0으로부터의 최단경로(P)\n");
		for (int i = 1; i < d.N; i++) {
			int back = i;
			System.out.print(back);
			while (back != 0) {
				System.out.print("<-" + d.previous[back]);
				back = d.previous[back];
			}
			System.out.println();
		}
	}
}
