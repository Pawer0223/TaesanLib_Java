package Functions.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Functions.Commons.GraphCommon;

/*
 *  두 정점간의 공통 부모중에서 가장가까운놈을 찾는다.
 */

public class LowestCommonAncestor1 {

	int[] parents; // 각 정점의 바로 위 부모가 누군지 기록한다! ===> idx의 부모는 value 이다.
	List<Integer>[] tree; // 트리를 나타내기 위한 인접 리스트.

	/*
	 * n = 정점의 갯수
	 * root = root노드를 정해준다.
	 * connect = 정점간의 연결정보
	 * m = 테스트케이스의 갯수
	 * testCase = 테스트케이스 정보 a b 정점의 최소공통부모는 누구인가?를 찾는다.
	 */
	public int[] start(int n, int root, int[][] connect, int m, int[][] testCase) {

		int[] result = new int[m];

		tree = new List[n + 1];
		parents = new int[n + 1];
		
		for (int i = 0; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		tree = GraphCommon.makeAdjList(tree, connect, true); // 양방향 연결
		
		// root노드를 알아야 한다. root부터 부모노드를 기록해나간다.
		setParents(n, root);
		// System.out.println(Arrays.toString(parents));

		for (int i = 0; i < m; i++) {
			int[] t = testCase[i];
			result[i] = LCA(t[0], t[1]);
		}

		return result;
	}

	// root부터 시작해서 각 정점의 바로 위 부모가 누군지 기록한다.
	void setParents(int n, int root) {

		boolean[] visited = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty()) {

			int parent = q.poll();

			if (visited[parent])
				continue;

			visited[parent] = true;

			List<Integer> childs = tree[parent];
			// System.out.println(parent + "의 childs..." + childs.toString());

			for (int i = 0; i < childs.size(); i++) {
				int child = childs.get(i);
				if (!visited[child]) {
					parents[child] = parent;
					q.add(child);
				}
			}
		}
	}

	// 현재 정점의 높이를 구한다.
	int getDepth(int v) {

		int depth = 0;

		// root의 부모는 초기 값인 0이다.
		// 현재 노드부터 root까지의 거리를 구한다.
		while (parents[v] != 0) {
			depth++;
			v = parents[v];
		}
		return depth;
	}

	// 두정점의 LCA를 구한다 !
	int LCA(int v1, int v2) {

		int d1 = getDepth(v1);
		int d2 = getDepth(v2);

		// 두 정점중에서 깊이가 더 깊은 정점을 구분한다. v2(d2)에 더 깊은 정점을 보관한다.
		if (d2 < d1) { // d2가 더 낮다면, 즉 더 위에있다면
			int temp = v1; // v1과 v2를 swap한다.
			v1 = v2;
			v2 = temp;
			temp = d1; // 역시 v1의 d와 v2의 depth도 같이 swap한다.
			d1 = d2;
			d2 = temp;
		}

		// 동일한 부모를 만날때까지
		while (v1 != v2) {
			// 두 정점의 깊이가 같아졌다면, 같이바꾸고
			if (d1 == d2) {
				v1 = parents[v1];
				v2 = parents[v2];
			} else { // 그렇지 않다면, 더 낮은 곶에있는 v2(d2)를 한칸씩 높여간다.
				v2 = parents[v2];
				d2--;
			}
		}
		return v1; // v1이든, v2든 상관없다. 높이를 맞췄기 때문에 결국 동일한 부모를 만났을 때 빠져나오게 된다.
	}
}
