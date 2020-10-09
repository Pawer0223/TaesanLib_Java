package Test;

import Functions.Commons.Caller;
import Functions.Commons.PrintData;

public class KruskalTest {

	static Caller caller = new Caller();
	static PrintData print = new PrintData();

	public static void main(String[] args) {

		int n = 4;
		int[][] edges = {
				{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}
		};

		System.out.println("### kruskal Result .. ###");
		System.out.println("expact : 4" + " ==> result : " + caller.kruskal(n, edges));
		
		int[][] edges2 = {
				{0,1,100},{0,2,10},{1,2,20},{1,3,30},{2,3,1}
		};
		
		System.out.println("### kruskal Result .. ###");
		System.out.println("expact : 31" + " ==> result : " + caller.kruskal(n, edges2));
		
		

	}

}
