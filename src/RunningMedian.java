import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

;

public class RunningMedian {

	public static List<Double> rddg(List<Integer> b) {
		int n = b.size();
        List<Double> ans = new ArrayList<>();
        ans.add( (double)b.get(0));
        List<Integer> a = new ArrayList<>(b.get(0));
        Double prevMed = null;
        for(int i=1;i<n;i++){
            
            a.add(a.get(i));
            
          if(i%2!=0){
              ans.add((double) a.get(i/2));
          }  else {
             Double sum = (double) (a.get((i/2)-1) + a.get(i/2) );
             ans.add(sum/2);
          }
        }
        return ans;
	}
	
	private static Comparator<Integer> minComparator = new Comparator<Integer>() {
	    @Override
	    public int compare(Integer first, Integer second) {
	      return first.compareTo(second);
	    }
	  };

	  private static Comparator<Integer> maxComparator = new Comparator<Integer>() {
	    @Override
	    public int compare(Integer first, Integer second) {
	      return second.compareTo(first);
	    }
	  };
	  
	public static List<Double> main(List<Integer> b) {
		PriorityQueue<Integer> minSortedQueue = new PriorityQueue<Integer>(100, minComparator);
		PriorityQueue<Integer> maxSortedQueue = new PriorityQueue<Integer>(100, maxComparator);

		ArrayList<Integer> foundValues;
		List<Double> ans = new ArrayList<>();
		for (int currentIndex = 1; currentIndex <= b.size(); currentIndex++) {
			Integer value = b.get(currentIndex - 1);
			double median = -1;

			// alternate insert to keep tree balanced
			if (currentIndex % 2 == 0) {
				maxSortedQueue.add(value);
			} else {
				minSortedQueue.add(value);
			}

			// swap end elements if out of order
			// This makes it so we only need to do one operation after the sorted
			// insert instead of traversing the list.
			if (minSortedQueue.size() > 0 && maxSortedQueue.size() > 0) {
				
				if (minSortedQueue.peek() < maxSortedQueue.peek()) {
					Integer maxSortedValue = maxSortedQueue.poll();
					Integer minSortedValue = minSortedQueue.poll();
					minSortedQueue.add(maxSortedValue);
					maxSortedQueue.add(minSortedValue);
				}
			}

			// get median using the definition in the problem set
			if (currentIndex == 1) {
				median = value;
				ans.add(median);
			} else if (currentIndex % 2 != 0) {
				median = minSortedQueue.peek();
				ans.add(median);
			} else {
				double sum = (minSortedQueue.peek() + maxSortedQueue.peek());
				median = sum / 2.0;
				ans.add(median);
			}
			System.out.printf("%.1f\n", median);
		}
		System.out.println(minSortedQueue);
		System.out.println( maxSortedQueue);
		return ans;
	}
}
