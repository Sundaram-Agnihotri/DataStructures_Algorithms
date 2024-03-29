import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

	public static ArrayList<Integer> kLargest(int input[], int k) {
		
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++) {

			pq.add(input[i]);
		}
		for (int i = k; i < input.length; i++) {

			int minVal = pq.peek();
			if (minVal < input[i])
				minVal = input[i];
			if (minVal != pq.peek()) {

				pq.poll();
				pq.add(minVal);
			}
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while (!pq.isEmpty())
			arr.add(pq.poll());
		return arr;
	}
}
