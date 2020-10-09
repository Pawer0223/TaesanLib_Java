package Functions.Graph;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {
	
	Graph g = new Graph();
	int[] parents;
	
	public int start(int n, int[][] edges) {
		
		parents = new int[n + 1]; // 각 정점의 부모를 기록하기위한 배열
		
		for (int i = 0; i <= n; i++) { // 초기 값은 자기자신으로 지정
			parents[i] = i;
		}
		// edges에 [v1, v2, value]로 들어온다고 가정.
		// v1에서 v2로가는 비용은 value이다.
		return kruskal(n, edges);
	}
	
	private int kruskal(int n, int[][] edges) {
		
		int sumCost = 0;
		
		// 1. 가중치가 낮은것부터 정렬한다.
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
		});
		
		// 2. 가장 작은것부터 연결해 나간다.
		for (int[] edge : edges) {
			
			int v1 = edge[0];
			int v2 = edge[1];
			int value = edge[2];
			
			if (g.getParent(parents, v1) != g.getParent(parents, v2)) { // 연결 되어있는, 두 정점의 부모가 같지 않다면 연결해준다.
				// System.out.println(v1 +" 과 " + v2 +"를 연결 .... ");
				g.union(parents, v1, v2);
				// System.out.printf("parents[%d] = %d,  parents[%d] = %d \n", v1,parents[v1],v2,parents[v2]);
				sumCost += value;
			}
		}
		return sumCost;
	}

}
