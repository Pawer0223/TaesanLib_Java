package Functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 특정 집합의 모든 부분집합을 구한다.
 */
public class PowerSet<T> {

	/*
	 * result: 결과
	 * visitPosition : 현재 방문한 위치들을 기록하게되는 배열
	 */
	private List<List<T>> result = new ArrayList<>();
	private boolean[] visitPosition;
	private boolean isDesc;

	/*
	 * arr: 순열을 찾을 대상.
	 * isDesc: true이면 n개부터 저장
	 *         false이면 1개부터 저장(정확히는 null부터)
	 */
	public List<List<T>> start(T[] arr, boolean isDesc) {

		visitPosition = new boolean[arr.length];
		this.isDesc = isDesc;
		powerSet(arr, 0);

		return result;
	}

	private void powerSet(T[] arr, int cnt) {
		
		if (cnt == arr.length) {
			List<T> addPer = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				if (visitPosition[i]) {
					addPer.add(arr[i]);
				}
			}
			result.add(addPer);
			return ;
		}

		visitPosition[cnt] = isDesc;
		powerSet(arr, cnt + 1);
		visitPosition[cnt] = !isDesc;
		powerSet(arr, cnt + 1);
	}

}
