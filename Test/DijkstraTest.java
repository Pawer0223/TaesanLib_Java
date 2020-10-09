package Test;

import java.util.Arrays;

import Functions.Commons.Caller;
import Functions.Commons.PrintData;

public class DijkstraTest {

	static Caller caller = new Caller();
	static PrintData print = new PrintData();

	public static void main(String[] args) {

		int n = 6;
		int[][] edges = {
				{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
		};
		int startV = 1;
		int inf = 30000;

		int[] minDistance = caller.dijkstra(n, edges, startV, inf);
		System.out.println("### dijkstra Result .. ###");
		System.out.println(Arrays.toString(minDistance));
		
	}

}
