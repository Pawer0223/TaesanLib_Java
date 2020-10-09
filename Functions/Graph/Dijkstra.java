package Functions.Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import Classes.Vertex;
import Functions.Commons.PrintData;

public class Dijkstra {

	Graph g = new Graph();
	
	static int INF = 30000;
	int[][] graph;
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

		int[] minDistance = new int[n + 1]; // 정점 startV에서 다른정점으로 가는 최단거리를 기록하기위한 배열
		boolean[] visits = new boolean[n + 1];
		INF = inf; // Integer.MAX 할 때, 아래 조건에서 overflow나면 올바르게 처리되지 않으니깐 max값설정에 반드시 주의할 것.. 

		graph = new int[n + 1][n + 1];

		for(int i = 1; i <= n; i++) {
			minDistance[i]= INF; // 처음에는 INF로 놓고, 해당 정점을 방문하게 될 때마다 최소 값을 갱신한다.
			Arrays.fill(graph[i],INF);
		}

		minDistance[startV] = 0; // 시작정점의 최단거리는 0
		graph = g.makeAdjArr(graph, edges, true); // 양방향 그래프 생성
		
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

				for(int i = 1; i <= n; i++) {
					if(!visits[i] && minDistance[v] + graph[v][i] < minDistance[i]) {
						minDistance[i] = minDistance[v] + graph[v][i];
						pq.add(new Vertex(i, minDistance[i]));
					}
				}
			}
		}
		return minDistance;
	}

}
