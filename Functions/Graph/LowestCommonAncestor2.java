package Functions.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Functions.Commons.GraphCommon;

/*
 * LCA1의 풀이보다 경우의 수가 더 많다.
 * 
 * 이 경우 빠르게 처리하기위해 각 정점의 2^N번째 노드만 기억하도록한다. 
 * => A라는 노드의 2^3번째 조상의 2^3번째 조상을 알면, A라는 노드의 2^4 조상을 알 수 있다. => OK
 * => A라는 노드의 2^3번째 조상을 알면, A라는 노드의 2^4조상을 알 수 있다.
 * https://taesan94.tistory.com/183?category=331916
 * 
 */
public class LowestCommonAncestor2 {

	int MAX = 17; // 주어진 수 100,000으로 갈 수 있는 최대 깊이는 2^17(131,072) 까지이다.
	int[] depth; // 각 정점의 깊이를 기록한다.
	int[][] parents; // 각정점의 2^n깊이에 있는 부모노드를 기록한다.
	List<Integer>[] tree; // 트리정보를 저장

	/*
	 * n = 정점의 갯수
	 * root = root노드를 정해준다.
	 * connect = 정점간의 연결정보
	 * m = 테스트케이스의 갯수
	 * testCase = 테스트케이스 정보 a b 정점의 최소공통부모는 누구인가?를 찾는다.
	 */
	public int[] start(int n, int root, int[][] connect, int m, int[][] testCase) {

		int[] result = new int[m];

		depth = new int[n + 1];
		parents = new int[n + 1][MAX + 1];
		tree = new List[n + 1];

		// 초기화
		init(n, root);

		// tree 연결
		tree = GraphCommon.makeAdjList(tree, connect, true);

		// 핵심 1
		// 각 정점의 깊이와, 각 정점의 2^0 부모를 기록.
		dfs(1);

		// 핵심 2.
		// 각 정점의 조상노드를 2^0 조상을 기준으로 해서 초기화해주는 작업!!
		setParents(n);

		// testCase별로 공통 조상을 찾게된다.
		for (int i = 0; i < m; i++) {
			// 핵심 3.
			// LCA2를 구하는 코드 !
			result[i] = LCA2(testCase[i][0], testCase[i][1]);
		}
		return result;
	}

	/*
	 * 초기화 작업
	 */
	private void init(int n, int root) {

		for (int i = 0; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		Arrays.fill(depth, -1); // 방문체크 하기위함. -1은 방문하지 않음.
		depth[root] = 0; // root는 0으로

		for (int[] parent : parents) {
			Arrays.fill(parent, -1); // 방문체크 하기위함. -1은 방문 x
		}
	}

	/*
	 * dfs를 통해서 root부터 시작하여
	 *   - 각 정점의 depth와
	 *   - 각 정점의 2^n의 부모를 기록한다.
	 */
	private void dfs(int parent) {

		List<Integer> childs = tree[parent];

		for (int child : childs) {
			if (depth[child] == -1) { // 해당 자식정점의 깊이를 구하지 않은 경우.
				depth[child] = depth[parent] + 1; // 부모 깊이보다 + 1
				parents[child][0] = parent; // 해당 자식노드의 2^0위에 있는 노드설정.
				dfs(child); // 재귀한다.
			}
		}
	}
	/*
	 *  A라는 노드의 2^3번째 조상의 2^3번째 조상을 알면 A라는 노드의 2^4의 조상을 알 수 있다.
	 *  위와 같은 논리로 공식을 적용하여, 각 정점의 초기 값을 설정해준다 !!
	 */
	private void setParents(int n) {
		for (int j = 0; j <= MAX; j++) {
			for (int i = 1; i <= n; i++) {
				if(parents[i][j] != -1) {
					parents[i][j + 1] = parents[parents[i][j]][j];
				}
			}
		}
	}

	/*
	 * 공통 조상 찾기 !!
	 * moreDeep: 조상에서 더 깊은 노드를 저장한다 ! root에서 더 멀리 있는 .. 
	 * lessDeep: 조상에서 더 얕은 노드를 저장한다 ! root에서 더 가까이 있는 ..
	 */
	private int LCA2(int moreDeep, int lessDeep) {

		// moreDeep이 더 깊은 노드가 될 수 있도록 한다.
		if (depth[moreDeep] < depth[lessDeep]) {
			int temp = lessDeep;
			lessDeep = moreDeep;
			moreDeep = temp;
		}

		// 두 깊이의 차이를 구한다.
		int hDiff = depth[moreDeep] - depth[lessDeep];
		int i = 0;

		// 두 정점의 깊이를 맞춰준다. 더 깊은곳에서 --> 더 얕은곳으로 올려준다.
		// 2^n 만큼씩 올리는 것이다. (아래는 코드는 이해안되면 일단 공식처럼..(디버깅하면 논리적이다..))
		while (hDiff != 0) {
			if (hDiff % 2 != 0) {
				moreDeep = parents[moreDeep][i]; // 짝수의 경우에도 마지막 1일때는 무조건 타게되있다.. 그 때의 2^i 의 정점으로 바뀐다. 
			}
			hDiff /= 2; // 깊이를 높여 나가기
			i++; // 2^i을 의미한다... 2^i만큼 높이면서 깊이를 맞춘다.
		}

		// 깊이를 맞추지 못했다면..
		// 재 계산된 moreDeep과 lessDeep정점의 2^MAX 깊이부터 2^0 까지 비교한다.
		if (moreDeep != lessDeep) {
			for (int j = MAX; j >= 0; j--) {
				if (parents[moreDeep][j] != -1 && parents[moreDeep][j] != parents[lessDeep][j]) { // 해당 깊이에 정점이 존재하면서, 두 정점이 같지않을 때.. 정점을 낮춰간다.
					moreDeep = parents[moreDeep][j];
					lessDeep = parents[lessDeep][j];
				}
			}
			// 모든 for문이 끝났을 때의 정점에 2^0위치에 있는 정점이 LCA가 된다.
			// for문이 끝났을 때 최종 moreDeep정점이 가르키는 값은, lessDeep과 조상이 같지않은 최대 높이의 노드가 된다.
			// 즉, 최초 공통 조상 위치를 찾게된 순간부터 2^n만큼 아래로내려갈수록 그 정점이 바뀌지 않게된다... ( 헷갈려.. )  
			moreDeep = parents[moreDeep][0];
		}
		return moreDeep;
	}

}
