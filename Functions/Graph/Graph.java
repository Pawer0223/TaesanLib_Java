package Functions.Graph;

import java.util.List;

public class Graph {

	/*
	 * adjArr, adjList: edges정보를 기록 후 return 하기위한 배열 및 list
	 * 					, dijkstra와같이 INF로 초기화작업이 선행되어야하는 경우가 있어 단순히 egde정보만 기록하도록 의도 함
	 * edges: 연결 된 두 정점의 정보
	 * isBoth : true => 양방향 그래프 만들기
	 * 			false => 단반향 그래프 만들기	
	 */

	/*
	 * 인접 행렬
	 */
	public int[][] makeAdjArr(int[][] adjArr, int[][] edges, boolean isBoth) {

		for (int[] edge : edges) {

			int v1 = edge[0];
			int v2 = edge[1];

			adjArr[v1][v2] = 1;
			if (isBoth)
				adjArr[v2][v1] = 1;
		}
		return adjArr;
	}
	/*
	 * 인접 리스트
	 */
	public List<Integer>[] makeAdjList(List<Integer>[] adjList, int[][] edges, boolean isBoth) {

		/*
		 * dijkstra적용할 때, INF초기화해주고 들어와야해서 호출 전에 할당하도록..
		for (int i = 0; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		*/

		for (int[] edge : edges) {

			int v1 = edge[0];
			int v2 = edge[1];

			adjList[v1].add(1);
			if (isBoth)
				adjList[v2].add(1);
		}
		return adjList;
	}
}
