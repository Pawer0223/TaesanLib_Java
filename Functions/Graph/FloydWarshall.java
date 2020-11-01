package Functions.Graph;

import java.util.Arrays;

import Functions.Commons.GraphCommon;


/*
 * 플로이드 와샬 알고리즘
 * 
 * 정점 A에서 다른 정점으로가는 모든 최단거리를 구한다.
 * 
 */
public class FloydWarshall {

	GraphCommon g = new GraphCommon();
	int[][] distance;
	int INF = 101;

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
