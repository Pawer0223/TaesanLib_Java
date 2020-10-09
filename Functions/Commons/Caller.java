package Functions.Commons;

import java.util.List;

import Functions.Combination;
import Functions.Permutation;
import Functions.PowerSet;
import Functions.Graph.Dijkstra;
import Functions.Graph.Kruskal;

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


}
