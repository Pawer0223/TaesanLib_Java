package Functions;

/*
 * 두 개의 포인터를 지정하여, 수열의 특정 구간의 합을 구하는 알고리즘.
 */
public class TwoPointer {
	
	/*
	 * size: 수열의 크기를 나타낸다.
	 * findNum: 찾고자하는 구간의 합이 몇인지?
	 * nums: 탐색을 할 배열이 된다.
	 */
	public int start(int size, int findNum, int[] nums) {
		return twoPointer(size, findNum, nums);
	}
	
	private int twoPointer(int size, int findNum, int[] nums) {

		// pointer1
		int l = 0;
		// pointer2
		int r = 0;
		// 구간 합을 저장할 변수
		int areaSum = 0;
		
		// findNum에 해당하는 구간합이 총 몇개인지 기록하는 결과 변수. 
		int result = 0;

		// pointer2즉, right위치의 포인터가 끝에 도달할때까지 반복.
		while (r != size) {

			if (areaSum >= findNum) { // 구간 합이 크거나 같은 경우에는 pointer1, 즉 left 위치의 값을 빼고 left를 이동시킨다.
				areaSum -= nums[l++];
			} 
			else if (r == size) // 마지막 s == M 조건을 한번더 보기 위해 종료조건을 여기다 포함시킨다. ex) 6 13에 2 3 5 7 11 13일 때 마지막 13도 볼 수 있도록
				break;
			else 
				areaSum += nums[r++]; // 구간합보다 작은경우에는 그 합을 늘려간다.
			
			if (areaSum == findNum) {// 원하는 결과를 찾은경우!
				result++;
				System.out.println(result+ "번 째로 찾은 구간은 [" + l + "이상 ~ " + r +"미만] 입니다.");
			}
		}
		return result;
	}

}

