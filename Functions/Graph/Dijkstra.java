package Functions.Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import Classes.Vertex;
import Functions.Commons.GraphCommon;
import Functions.Commons.PrintData;

public class Dijkstra {

	private int INF = 30000; // Integer.MAX로하면 overflow날 수 있으니 정확히 측정하자. i -> j로가는 초기 최소값은 MAX로 두어서 갱신되도록한다.
	private int[][] graph; // graph를 나타내는 인접행렬이다. i -> j로가는 간선이 존재하지 않는다면 0이다.
	private int[] minDistance; // 시작정점에서 -> idx로 가는데 걸리는 최단거리를 기록한다.
	private boolean[] visits; // 해당 정점을 방문했는지 확인한다. 인접 노드를 방문해가기 때문에, 방문한 경우는 최단거리를 구했다는 의미이다. a -> b로가는 조건을 보게되니깐.
	/*
	 * 다익스트라 알고리즘
	 * startV에서 모든 정점에 도달할 수 있는 최단거리 구하기.
	 * startV : 시작 정점
	 * INF는 문제의 조건에따라 바뀔 수 있다.
	 * 
	 * Return : 
	 * 	정점 starV에서 각 정점으로 가는 최단거리가 담긴 배열을 return
	 */
	public int[] start(int n, int[][] edges, int startV, int inf) {

		minDistance = new int[n + 1];
		visits = new boolean[n + 1];
		graph = new int[n + 1][n + 1];
		INF = inf; 

		for(int i = 1; i <= n; i++) {
			minDistance[i]= INF; // 처음에는 INF로 놓고, 해당 정점을 방문하게 될 때마다 최소 값을 갱신한다.
			Arrays.fill(graph[i],INF);
		}

		graph = GraphCommon.makeAdjArr(graph, edges, true); // 양방향 그래프 생성
		dijkstra(startV, n);

		return minDistance;
	}
	
	private void dijkstra(int startV, int vertexCnt) {
		
		minDistance[startV] = 0; // 시작정점의 최단거리는 0
		
		// 시작, 우선순위 큐에 정점,정점까지의 가중치 값을 기록해서 가중치가 작은 값부터 처리되도록
		PriorityQueue<Vertex> pq = new PriorityQueue<>(new Comparator<Vertex>() {
			@Override
			public int compare(Vertex o1, Vertex o2) {
				return o1.getValue()-o2.getValue();
			}
		});

		pq.add(new Vertex(startV, 0)); // 시작정점의 가중치는 0으로.. 큰의미없음

		while (!pq.isEmpty()) {
			int v = pq.poll().getVertex();

			if(!visits[v]) {
				visits[v] = true;

				for(int i = 1; i <= vertexCnt; i++) {
					if(!visits[i] && minDistance[v] + graph[v][i] < minDistance[i]) {
						minDistance[i] = minDistance[v] + graph[v][i];
						pq.add(new Vertex(i, minDistance[i]));
					}
				}
			}
		}
	}

}
