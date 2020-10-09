package Test;

import java.util.Arrays;

import Functions.Commons.Caller;
import Functions.Commons.PrintData;

public class FloydWarshallTest {

	static Caller caller = new Caller();
	static PrintData print = new PrintData();

	public static void main(String[] args) {

		int n = 5;
		int[][] arr = {
				{4, 3}, {3, 2}, {2 ,4}, {1, 2}, {2, 5}
		};
		int INF = 101;

		System.out.println("### FloydWarshall Result .. ###");
		int[][] result = caller.floydWarshall(n, arr, INF);
		
		for (int[] r : result ) {
			System.out.println(Arrays.toString(r));
		}
	}

}
