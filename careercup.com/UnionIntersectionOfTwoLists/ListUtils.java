import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class ListUtils {
	
	public List<Integer> union(List<Integer> list1, List<Integer> list2) {
		if (list1 == null || list2 == null) {
			throw new IllegalArgumentException();
		}
		return merge(list1, list2);
	}
	
	private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
		List<Integer> mergedList = new ArrayList<>();
		int i1 = 0;
		int i2 = 0;
		while (i1 + i2 != list1.size() + list2.size()) {
			if (i1 == list1.size()) {
				mergedList.add(list2.get(i2++));
			} else if (i2 == list2.size()) {
				mergedList.add(list1.get(i1++));
			} else if (list1.get(i1) < list2.get(i2)) {
				mergedList.add(list1.get(i1++));
			} else {
				mergedList.add(list2.get(i2++));
			}
		}
		return mergedList;
	}
	
	public List<Integer> intersection(List<Integer> list1, List<Integer> list2) {
		if (list1 == null || list2 == null) {
			throw new IllegalArgumentException();
		}
		return intersect(list1, list2);
	}
	
	private List<Integer> intersect(List<Integer> list1, List<Integer> list2) {
		List<Integer> mergedList = new ArrayList<>();
		int i1 = 0;
		int i2 = 0;
		while (i1 + i2 != list1.size() + list2.size()) {
			if (i1 == list1.size() || i2 == list2.size()) {
				break;
			} else if (list1.get(i1) == list2.get(i2)) {
				mergedList.add(list1.get(i1));
				++i1;
				++i2;
			} else if (list1.get(i1) < list2.get(i2)) {
				++i1;
			} else {
				++i2;
			}
		}
		return mergedList;
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(new Integer[] {1,2,3,4,5,6,7});
		
		List<Integer> list2 = Arrays.asList(new Integer[] {-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10});
		
		ListUtils listUtils = new ListUtils();
		System.out.println("Union: ");
		for (Integer i : listUtils.union(list1, list2)) {
			System.out.print(" " + i);
		}
		System.out.println();
		
		System.out.println("Intersection: ");
		for (Integer i : listUtils.intersection(list1, list2)) {
			System.out.print(" " + i);
		}
		System.out.println();
	}
	
}