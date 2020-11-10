package Test;

import java.util.Arrays;
import java.util.Random;

import Functions.Commons.Caller;
import Functions.Commons.PrintData;

public class BinarySearchTest {
	
	static Caller caller = new Caller();
	static PrintData print = new PrintData();

	public static void main(String[] args) {

		int[] nums = new int[20];
		for (int i = 0; i < 20; i++) {
			int num = (int)(Math.random() * 201);
			nums[i] = num;
		}
		int findNum = (int)(Math.random() * 201);
		
		System.out.println(Arrays.toString(nums));
		System.out.println(findNum);
		
		System.out.println(Arrays.toString(nums) +" 배열에[ " + findNum +" ]이 존재하는가 ? ===> " + caller.binarySearch(nums, findNum));
		
		int[] nums2 = new int[10];
		for (int i = 0; i < 10; i++) {
			int num = (int)(Math.random() * 21);
			nums2[i] = num;
		}
		int findNum2 = (int)(Math.random() * 11);
		System.out.println(Arrays.toString(nums2));
		System.out.println(findNum2);
		System.out.println(Arrays.toString(nums2) +" 배열에[ " + findNum2 +" ]이 존재하는가 ? ===> " + caller.binarySearch(nums2, findNum2));
		
		
		

	}

}
