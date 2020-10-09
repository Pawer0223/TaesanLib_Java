package Test;

import java.util.List;

import Functions.Commons.Caller;
import Functions.Commons.PrintData;

public class PowerSetTest {
	
	static Caller caller = new Caller();
	static PrintData print = new PrintData();

	public static void main(String[] args) {
		
		Integer[] arr1 = {1, 2, 3, 4};
		Character[] arr2 = {'a', 'b', 'c' ,'d' , 'e'};
		String[] arr3 = {"red" , "blue" , "black"};
		
		boolean isDesc = false;
		
		List<List<Integer>> powerSet = caller.powerSet(arr1, isDesc);
		print.twoList(powerSet);

		List<List<Character>> powerSet2 = caller.powerSet(arr2, isDesc);
		print.twoList(powerSet2);

		List<List<String>> powerSet3 = caller.powerSet(arr3, isDesc);
		print.twoList(powerSet3);
		
	}

}
