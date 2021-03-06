package Functions.Commons;

import java.util.List;

import Functions.BinarySearch;
import Functions.Combination;
import Functions.Permutation;
import Functions.PowerSet;
import Functions.TwoPointer;
import Functions.Graph.Dijkstra;
import Functions.Graph.FloydWarshall;
import Functions.Graph.Kruskal;
import Functions.Graph.LowestCommonAncestor1;
import Functions.Graph.LowestCommonAncestor2;

public class Caller {
	
	public <T> List<List<T>> permutation(T[] arr, int amout) {
		Permutation<T> p = new Permutation<>();
		return p.start(arr,  amout);
	}
	
	public <T> List<List<T>> combination(T[] arr, int amout) {
		Combination<T> c = new Combination<>();
		return c.start(arr,  amout);
	}
	
	public <T> List<List<T>> powerSet(T[] arr, boolean isDesc) {
		PowerSet<T> c = new PowerSet<>();
		return c.start(arr, isDesc);
	}
	
	public int[] dijkstra(int n, int[][] edges, int startV, int inf) {
		Dijkstra dijk = new Dijkstra();
		return dijk.start(n, edges, startV, inf);
	}
	
	public int kruskal(int n, int[][] edges) {
		Kruskal krus = new Kruskal();
		return krus.start(n, edges); 
	}
	
	public int twoPointer(int size, int findNum, int[] nums) {
		TwoPointer twoPointer = new TwoPointer();
		return twoPointer.start(size, findNum, nums);
	}
	
	public boolean binarySearch(int[] nums, int findNum) {
		BinarySearch bs = new BinarySearch();
		return bs.start(nums, findNum);
	}
	
	public int[][] floydWarshall(int n, int[][] arr, int inf) {
		FloydWarshall floyd = new FloydWarshall();
		return floyd.start(n, arr, inf); 
	}
	
	public int[] lca1(int n, int root, int[][] connect, int m, int[][] testCase) {
		LowestCommonAncestor1 lca1 = new LowestCommonAncestor1();
		return lca1.start(n, root, connect, m, testCase);
	}
	
	public int[] lca2(int n, int root, int[][] connect, int m, int[][] testCase) {
		LowestCommonAncestor2 lca2 = new LowestCommonAncestor2();
		return lca2.start(n, root, connect, m, testCase);
	}

}
