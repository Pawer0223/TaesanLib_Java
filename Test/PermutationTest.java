package Test;

import java.util.List;

import Functions.Caller;
import Functions.PrintData;

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
		
		List<List<Integer>> permutation = caller.permutation2(arr1, n);
		print.twoList(permutation);

		List<List<Character>> permutation2 = caller.permutation2(arr2, n2);
		print.twoList(permutation2);

		List<List<String>> permutation3 = caller.permutation2(arr3, n3);
		print.twoList(permutation3);
		
	}

}
