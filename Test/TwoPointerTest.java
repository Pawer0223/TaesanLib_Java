package Test;

import java.util.Arrays;

import Functions.Commons.Caller;
import Functions.Commons.PrintData;

public class TwoPointerTest {
	
	static Caller caller = new Caller();
	static PrintData print = new PrintData();

	public static void main(String[] args) {
		
		// N개의 수로 된 수열 A[1], A[2], ... A[N]이 있다. 
		// 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i + 1] + ... + A[j - 1] + A[j]가  M이 되는 경우의 수를 구하여라.ㅣ
		
		int[] nums1 = { 1, 1, 1, 1 };
		int size = 4;
		int findNum = 2;

		int r1 = caller.twoPointer(size, findNum, nums1);
		System.out.println("수열 => " + Arrays.toString(nums1)+"의 구간 합이 " + findNum +"가 되는 경우의 수는 [" + r1 +"] 개 입니다.");
		
		int[] nums2 = { 1, 2, 3, 4, 2, 5, 3, 1, 1, 2 };
		size = 10;
		findNum = 5;
		int r2 = caller.twoPointer(size, findNum, nums2);
		System.out.println("수열 => " + Arrays.toString(nums2)+"의 구간 합이 " + findNum +"가 되는 경우의 수는 [" + r2 +"] 개 입니다.");
		
		
		

	}

}
