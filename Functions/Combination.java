package Functions;

import java.util.ArrayList;
import java.util.List;

public class Combination<T> {
	
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
		setCombination(arr, amount, 0, 0);

		return result;
	}
	
	/*
	 * start: 중복을 피하기 위해서, 다음 데이터의 시작위치를 한칸씩 증가시키며 이동한다.
	 */
	void setCombination(T[] arr, int amount, int idx, int start) {
		
		if (idx == amount) {
			
			List<T> addPer = new ArrayList<>();
			for (int p : perResult) {
				addPer.add(arr[p]);
			}
			result.add(addPer);
			return ;
		}
		
		// 1 ~ N 까지의 숫자
		for (int i = start; i < arr.length; i++) {
			if (!visitPosition[i]) {
			visitPosition[i] = true; // 방문
			perResult[idx] = i;
			setCombination(arr, amount, idx + 1 , i + 1); // i + 1이나 i나 결과는 같다.
			visitPosition[i] = false;
			}
		}
	}
	
}
