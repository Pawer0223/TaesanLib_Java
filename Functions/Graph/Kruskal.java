package Functions.Graph;

import java.util.Arrays;
import java.util.Comparator;

import Functions.Commons.GraphCommon;

/*
 *  크루스칼 알고리즘.
 *  
 *  최소비용으로 그래프를 연결하는 방법이다.
 *  
 *  가중치가 낮은 정점부터 연결해 나간다.
 *  부모노드가 같다면 연결하지 않는다.
 *  부모노드가 다르다면 연결한다.
 * 
 */
public class Kruskal {

	// 각 정점의 최상위 부모노드를 기록한다.
	int[] parents;

	/*
	 * 초기 값 지정
	 * parents: 부모노드의 초기 값은 자기 자신이다.
	 * 그래야 다른 parent가 갱신될 때 root는 자기자신을 계속해서 가르킬 수 있다.
	 */
	public int start(int n, int[][] edges) {
		
		parents = new int[n + 1]; // 각 정점의 부모를 기록하기위한 배열
		
		for (int i = 0; i <= n; i++) { // 초기 값은 자기자신으로 지정
			parents[i] = i;
		}
		return kruskal(n, edges);
	}
	
	/*
	 * n: 
	 *  정점의 갯수
	 *  
	 * edges:
	 *  [v1, v2, value]로 들어온다고 가정. (v1 -> v2로 가는데 value가 든다.)
	 */
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
			
			if (GraphCommon.getParent(parents, v1) != GraphCommon.getParent(parents, v2)) { // 연결 되어있는, 두 정점의 부모가 같지 않다면 연결해준다.
				// System.out.println(v1 +" 과 " + v2 +"를 연결 .... ");
				GraphCommon.union(parents, v1, v2);
				// System.out.printf("parents[%d] = %d,  parents[%d] = %d \n", v1,parents[v1],v2,parents[v2]);
				sumCost += value;
			}
		}
		return sumCost;
	}

}
