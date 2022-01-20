import java.io.IOException;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MainTest {

	public static List<Integer> main(String[] args) throws IOException {
		// construct returning datasture;
		List<List<Integer>> edges = new ArrayList<>();
		int n = 0;
		int s = 0;

		int[] shortestPath = new int[n];
		for (int i = 0; i < n; i++)
			shortestPath[i] = Integer.MAX_VALUE;
		boolean[] visited = new boolean[n];
		PriorityQueue<Cost> pq = new PriorityQueue<>(new Comparator<Cost>() {
			@Override
			public int compare(Cost n1, Cost n2) {
				if (n1.cost < n2.cost)
					return -1;
				else if (n1.cost == n2.cost)
					return 0;
				else
					return 1;
			}
		});
		List<List<Cost>> adj = new ArrayList<>();
		
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<>());
		for (int i = 0; i < edges.size(); i++) {
			int f = edges.get(i).get(0) - 1;
			int t = edges.get(i).get(1) - 1;
			int cost = edges.get(i).get(2);
			adj.get(f).add(Cost.create(t, cost));
			adj.get(t).add(Cost.create(f, cost));
		}
		pq.offer(new Cost(s - 1, 0));
		int ex = 0;
		while (!pq.isEmpty()) {
			Cost cur = pq.poll();
			if (!visited[cur.v]) {
				if (cur.cost == 0)
					ex = cur.v;
				shortestPath[cur.v] = cur.cost;
				visited[cur.v] = true;
				List<Cost> neighbors = adj.get(cur.v);
				for (int i = 0; i < neighbors.size(); i++) {
					Cost nei = neighbors.get(i);
					if (cur.cost + nei.cost < shortestPath[nei.v]) {
						shortestPath[nei.v] = cur.cost + nei.cost;
						if (!visited[nei.v] && pq.contains(nei)) {
							pq.remove(nei);
							pq.offer(new Cost(nei.v, shortestPath[nei.v]));
						} else if (!visited[nei.v]) {
							pq.offer(new Cost(nei.v, shortestPath[nei.v]));
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i])
				shortestPath[i] = -1;
		}
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			res.add(-1);
			if (i < ex)
				
				res.set(i, shortestPath[i]);
			else if (i > ex)
				res.set(i - 1, shortestPath[i]);
		}
		return res;

	}
	
  static class Cost {
		int v;
	    int cost;
	    public Cost(int v, int cost) {
	        this.v = v;
	        this.cost = cost;
	    }
	    
	    public static Cost create(int v, int cost) {
	       return new Cost(v, cost);
	    }
	}

}

