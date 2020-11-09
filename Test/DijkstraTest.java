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
		System.out.println("expact : [0, 0, 1, 3, 2 ,2, 2]" + " ==> result : " + Arrays.toString(minDistance));
		
		minDistance = caller.dijkstra(n, edges, 4, inf);
		System.out.println("### dijkstra Result .. ###");
		System.out.println("expact : [0, 2, 1, 1, 0 ,2, 2]" + " ==> result : " + Arrays.toString(minDistance));
		
		minDistance = caller.dijkstra(n, edges, 5, inf);
		System.out.println("### dijkstra Result .. ###");
		System.out.println("expact : [0, 2, 1, 2, 2 ,0, 3]" + " ==> result : " + Arrays.toString(minDistance));
		
		
		// 해밀토니안 경로.. 안되네..ㅎㅎ		
		int n2 = 5; //6;
		int[][] e2 = {
			// {5,1},{2,5},{3,5},{3,6},{2,4},{4,0}
				{2,5},{2,0},{3,2},{4,2},{2,1}
		};
		minDistance = caller.dijkstra(n2, e2, 6, 200001);
		System.out.println("### Test Result .. ###");
		System.out.println("expact : [ ]" + " ==> result : " + Arrays.toString(minDistance));
		

		
		
	}

}
