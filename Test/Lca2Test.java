package Test;

import java.util.Arrays;

import Functions.Commons.Caller;
import Functions.Commons.PrintData;

public class Lca2Test {

	static Caller caller = new Caller();
	static PrintData print = new PrintData();

	public static void main(String[] args) {

		int n = 15;
		int root = 1;
		int[][] connect = {
				{1 ,2} ,
				{1 ,3} ,
				{2 ,4} ,
				{3 ,7} ,
				{6 ,2} ,
				{3 ,8} ,
				{4 ,9} ,
				{2 ,5} ,
				{5 ,11} ,
				{7 ,13} ,
				{10, 4} ,
				{11, 15} ,
				{12, 5} ,
				{14, 7}
		};
		
		int m = 6;
		int[][] testCase = {
				{6 ,11},
				{10 ,9},
				{2 ,6},
				{7 ,6},
				{8 ,13},
				{8 ,15}
		};

		System.out.println("### LCA 2 TEST...###");
		System.out.println("### graph 정보 출력 ### ");
		for (int[] con : connect) {
			System.out.println(Arrays.toString(con));
		}
		
		int[] result = caller.lca2(n, root, connect, m, testCase);
		
		System.out.println("### 결과 출력 ###");
		for (int i = 0; i < m; i++) {
			int[] t = testCase[i];
			System.out.println(t[0] +"과 "+t[1] + "의 LCA2 는 : [" + result[i] + "] 입니다.");
		}
		

	}

}
