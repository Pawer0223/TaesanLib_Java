package Functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * arr배열에서 n개를 선택하여 만들 수 있는 순열을 찾아 return한다.
 *  순열 : 순서가 있다.
 *  [1, 2]와 [2, 1]은 다르게 취급된다. 
 */
public class Permutation2<T> {
	List<List<T>> result = new ArrayList<>();
	int[] perResult;
	boolean[] visitPosition;
	/*
	 * arr: 순열을 찾을 대상..  int[]가 아닐수도 있다.
	 * n : arr에서 n개의 요소로 만들 수 있는 순열.
	 */
	public List<List<T>> start(T[] arr, int amount) {
		
		visitPosition = new boolean[arr.length];
		perResult = new int[amount];
		setPermutation(arr, amount, 0);

		return result;
	}
	/*
	 * result: 결과
	 * arr : i개의 데이터가 존재하는 배열
	 * pos : 현재 방문한 위치들을 기록하게되는 배열
	 * perResult : 현재 cnt번째의 데이터를 기록해준다.
	 * amount : arr에서 amount개의 요소를 찾는다
	 * cnt : 0번째 요소부터 방문한다.
	 */
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
			if (visitPosition[i])
				continue;
			visitPosition[i] = true;
			perResult[cnt] = i;
			setPermutation(arr, amount, cnt + 1);
			visitPosition[i] = false;
		}
	}
}
