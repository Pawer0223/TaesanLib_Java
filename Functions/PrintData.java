package Functions;

import java.util.Arrays;
import java.util.List;

public class PrintData {
			
	public <T> void twoArr(T[][] arrs) {
		System.out.println("###### print two Arr ######");
		for(T[] arr : arrs) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public <T> void twoList(List<List<T>> lists) {
		System.out.println("###### print two list ######");
		for(List<T> list : lists) {
			System.out.println(list.toString());
		}
	}

}
