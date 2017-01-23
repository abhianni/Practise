package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PossibleSumSubset {
	ArrayList<Integer> list = new ArrayList<>();
	Set<List<Integer>> result = new HashSet<>();
	int i, j, k;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 4, 5, 13 };
		List<Integer> list = new ArrayList<Integer>();
		list = Arrays.asList(array);
		PossibleSumSubset subset = new PossibleSumSubset();
		subset.findSubset(list, 15);
	}

	public void findSubset(List<Integer> original, int sum) {

		i = 0;

		k = original.size() - 1;
		Collections.sort(original);
		while (i < k) {
			if (original.get(i) + original.get(k) == sum) {
				list.add(original.get(i));
				list.add(original.get(k));
				if (result.add(list)) {
					System.out.println(list);
				}
				list.clear();
				k = k - 1;
			}

			else if (original.get(i) + original.get(k) < sum) {

				list.add(original.get(i));
				list.add(original.get(k));
				findAllSubset(i, k, 0, original, sum);
				i = i + 1;

			} else if (original.get(i) + original.get(k) > sum) {
				list.clear();
				i = i + 1;
				k = k - 1;
			}
		}
	}

	public void findAllSubset(int i, int k, int j, List<Integer> original, int sum) {

		int newsum = original.get(i) + original.get(k);
		while (j < k)

		{
			if (i == j || original.get(j) == original.get(j + 1)) {
				j = j + 1;
				continue;
			}
			newsum = newsum + original.get(j);
			list.add(original.get(j));
			if (newsum == sum) {
				if (result.add(list)) {
					System.out.println(list);
				}

				list.clear();
				break;
			} else if (newsum>sum){

				// list.clear();
				list.remove(list.size() - 1);
				newsum = newsum - original.get(j);
				j = j + 1;

			}
			else
			{
				newsum = newsum + original.get(j);
				list.add(original.get(j));
				j = j + 1;
			}

		}
		list.clear();

	}

}
