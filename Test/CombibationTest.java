package Test;

import java.util.List;

import Functions.Commons.Caller;
import Functions.Commons.PrintData;

public class CombibationTest {
	
	static Caller caller = new Caller();
	static PrintData print = new PrintData();

	public static void main(String[] args) {
		
		Integer[] arr1 = {1, 2, 3, 4};
		int n = 3;

		Character[] arr2 = {'a', 'b', 'c' ,'d' , 'e'};
		int n2 = 2;
		
		String[] arr3 = {"red" , "blue" , "black"};
		int n3 = 3;
		
		List<List<Integer>> combination = caller.combination(arr1, n);
		print.twoList(combination);

		List<List<Character>> combination2 = caller.combination(arr2, n2);
		print.twoList(combination2);

		List<List<String>> combination3 = caller.combination(arr3, n3);
		print.twoList(combination3);
		
	}

}
