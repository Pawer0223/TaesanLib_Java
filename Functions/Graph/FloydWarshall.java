package Functions.Graph;

import java.util.Arrays;

/*
 * 플로이드 와샬 알고리즘
 * 
 * 정점 A에서 다른 정점으로가는 모든 최단거리를 구한다.
 * 
 * 핵심은 1 -> 5로 갈때의 거리와
 *  1 -> 2 -> 5로 갈때의 거리
 *  1 -> 3 -> 5로 갈때의 거리
 *  1 -> 4 -> 5로 갈때의 거리를 모두 비교해서 최단거리를 찾아간다.
 * 
 */

public class FloydWarshall {

	int[][] distance; // 정점[i 에서][j로 가는 최단거리] 가 기록된다.
	int INF = 101; // 초기 값으로 i -> j로가는 최단거리는 Max다! 라고 설정해주어야 한다. 

	public int[][] start(int n, int[][] arr, int inf) {
		distance = new int[n + 1][n + 1];
		INF = inf;

		// 초기 값 SET
		for (int i = 0; i <= n; i++) {
			Arrays.fill(distance[i], INF);
		}

		// 초기 거리 SET
		for (int[] a : arr) {
			distance[a[0]][a[1]] = 1;
		}

		floydWarshall(n);
		return distance;
	}

	// n은 정점의 갯수이다. 1~n까지의 정점이 있다고 가정한다.
	private void floydWarshall(int n) {

		for (int k = 1; k <= n; k++ ) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) { // i에서 j로가는 경로 vs i에서 k를거쳐서 j로가는 경로중 작은 값으로 채워주기
					if (distance[i][k] + distance[k][j] < distance[i][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
	}

}
