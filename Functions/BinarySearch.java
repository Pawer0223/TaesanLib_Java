package Functions;

import java.util.Arrays;

/*
 * 2진탐색, 정렬 된 데이터 (혹은 거의 정렬이 된 데이터)가 주어졌을 때 범위를 좁혀가면서 빠른 시간안에 원하는 데이터를 찾는다.
 * 
 */
public class BinarySearch {
	
	/*
	 * arr: 탐색 대상 배열
	 * findNum: arr 안에 존재하는지 찾을 값
	 */
	public boolean start(int[] arr, int findNum) {
		
		// 이진 탐색을 적용하기 위해서는 반드시 데이터가 정렬되어야 한다...
		// 정렬 되지 않은 배열이 주어질 수 있기 때문에, 정렬을 먼저 수행한다.
		Arrays.sort(arr);
		
		// 처음 탐색 범위는 배열 전체 크기가 된다 !
		if (binarySearch(arr, 0, arr.length - 1,findNum))
			return true;
		// 없으면 false
		return false;
	}

	private boolean binarySearch(int[]arr, int start, int end,  int num) {

		// start ~ end 범위를 계속 바꿔나갈껀데,
		while (start <= end) { // start는 end보다 반드시 작아야한다. 같아지는 경우에도 한번도 찾는 num이 맞는지를 확인한다.
			
			int mid = (start + end) / 2; // 해당 범위의 가운데 위치 index를 구한다.
			// System.out.printf("Start : %d , end : %d, mid : %d \n",start,end,mid);
			int value = arr[mid];  // 중간 범위의 값을 pivot으로 잡는다 !
			
			if (num < value) { // 찾고자 하는 값보다 pivot값이 크다면, 찾고자하는 값은 더 좁은 범위에 존재한다.
				end = mid - 1; // 범위를 start~ 중간으로 변경. 
			} else if (num > value) { // 찾고자 하는 값이 더 작다면, 더 큰 범위에 존재한다.
				start = mid + 1; // 범위를 중간 ~ end로 변경. 
			} else if (num == value) {  // 찾았다면 ! 있다고 1을 return해준다.
				return true;
			}
		}
		return false;
	}
}
