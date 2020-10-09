package Functions;

import java.util.ArrayList;
import java.util.List;

/*
 * 순열 알고리즘
 * arr배열에서 n개를 선택하여 만들 수 있는 순열을 찾아 return한다.
 *  순열 : 순서에 의미가 있다.
 *  [1, 2]와 [2, 1]은 다르게 취급된다. 
 */
public class Permutation<T> {

	/*
	 * result: 결과
	 * perResult : 완성 된 수열의 index정보를 기록하는 배열
	 * visitPosition : 현재 방문한 위치들을 기록하게되는 배열
	 */
	private List<List<T>> result = new ArrayList<>();
	private int[] perResult;
	private boolean[] visitPosition;

	/*
	 * arr: 순열을 찾을 대상.
	 * amount: arr에서 n개의 요소로 만들 수 있는 순열.
	 */
	public List<List<T>> start(T[] arr, int amount) {

		visitPosition = new boolean[arr.length];
		perResult = new int[amount];
		setPermutation(arr, amount, 0);

		return result;
	}

	private void setPermutation(T[] arr, int amount, int cnt) {

		if (cnt == amount) {
			List<T> addPer = new ArrayList<>();
			for (int p : perResult) {
				addPer.add(arr[p]);
			}
			result.add(addPer);
			return ;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visitPosition[i]) {
				visitPosition[i] = true;
				perResult[cnt] = i;
				setPermutation(arr, amount, cnt + 1);
				visitPosition[i] = false;
			}
		}
	}
}
