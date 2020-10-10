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
				// {4, 3}, {3, 2}, {2 ,4}, {1, 2}, {2, 5}
				{5, 4},	{4, 3}, {3, 2}, {2 ,1}
		};
		int INF = 101;

		System.out.println("### FloydWarshall Result .. ###");
		int[][] result = caller.floydWarshall(n, arr, INF);
		
		for (int[] r : result ) {
			System.out.println(Arrays.toString(r));
		}
		
		System.out.println("###################");
		
		int answer = 0;
		for ( int i=1; i<=n; i++ ) {
			boolean possible = true;
			for ( int j=1; j<=n; j++ ) {
				if( (i !=j ) && ( result[i][j] == INF && result[j][i] == INF ) ) {
					possible = false;
					break;
				}
			}			
			if( possible ) {
				System.out.println("[ possible : " + i + " ]");
				answer++;
			}
		}
		System.out.println("answer : " + answer );
		

	}

}
