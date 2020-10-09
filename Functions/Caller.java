package Functions;

import java.util.List;

public class Caller {
	
	public List<int[]> permutation(int[] arr, int amout) {
		Permutation p = new Permutation();
		return p.start(arr,  amout);
	}
	
	public <T> List<List<T>> permutation2(T[] arr, int amout) {
		Permutation2<T> p = new Permutation2<>();
		return p.start(arr,  amout);
	}

}
