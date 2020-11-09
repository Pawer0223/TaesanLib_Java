package Test;

import java.util.List;

import Functions.Commons.Caller;
import Functions.Commons.PrintData;

public class PermutationTest {
	
	static Caller caller = new Caller();
	static PrintData print = new PrintData();

	public static void main(String[] args) {
		
		Integer[] arr1 = {1, 2, 3, 4};
		int n = 3;

		Character[] arr2 = {'a', 'b', 'c' ,'d' , 'e'};
		int n2 = 2;
		
		String[] arr3 = {"red" , "blue" , "black"};
		int n3 = 3;
		
		List<List<Integer>> permutation = caller.permutation(arr1, n);
		print.twoList(permutation);

		List<List<Character>> permutation2 = caller.permutation(arr2, n2);
		print.twoList(permutation2);

		List<List<String>> permutation3 = caller.permutation(arr3, n3);
		print.twoList(permutation3);
		
		String[] numbers = {
				// "1", "7"
				"0", "1", "2","3","4","5","6"
		};
		
		List<List<String>> permutation4 = caller.permutation(numbers, 7);
		print.twoList(permutation4);
		
	}

}
