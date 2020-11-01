package Functions.Commons;

import java.util.List;

public class GraphCommon {

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
	public static int[][] makeAdjArr(int[][] adjArr, int[][] edges, boolean isBoth) {

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
	public static List<Integer>[] makeAdjList(List<Integer>[] adjList, int[][] edges, boolean isBoth) {

		/*
		 * dijkstra적용할 때, INF초기화해주고 들어와야해서 호출 전에 할당하도록..
		for (int i = 0; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		*/

		for (int[] edge : edges) {

			int v1 = edge[0];
			int v2 = edge[1];

			adjList[v1].add(v2);
			if (isBoth)
				adjList[v2].add(v1);
		}
		return adjList;
	}
	
	/*
	 * 부모 노드의 정보를 찾는다.
	 */
	public static int getParent(int[] parents, int v) {
		if (parents[v] == v)
			return v;
		return getParent(parents, parents[v]);
	}

	/*
	 *  두 정점의 부모를 동일하게 적용한다
	 */
	public static void union(int[] parents, int big, int small) {
		
		big = getParent(parents, big);
		small = getParent(parents, small);
		
		// 부모노드의 기준이 필요하다. 더 작은 숫자의 정점이 부모이다.라는 기준으로 합치겠다.
		if (small > big) {
			int temp = small;
			small = big;
			big = temp;
		}
		parents[big] = small; // big의 부모는 small이다. 
	}
}
