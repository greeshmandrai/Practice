import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstrashortreach {
	
	public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {

		int[] shortestPath = new int[n];
		for (int i = 0; i < n; i++)
			shortestPath[i] = 0;
		
		boolean[] isTraverse = new boolean[n];
		PriorityQueue<PathMap> q1 = new PriorityQueue<>(new Comparator<PathMap>() {
			@Override
			public int compare(PathMap n1, PathMap n2) {
				return n1.dis.compareTo(n2.dis);
			}
		});
		List<List<PathMap>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<>());
		
		for (int i = 0; i < edges.size(); i++) {
			int f = edges.get(i).get(0) - 1;
			int t = edges.get(i).get(1) - 1;
			int cost = edges.get(i).get(2);
			adj.get(f).add(PathMap.create(t, cost));
			adj.get(t).add(PathMap.create(f, cost));
		}
		q1.add(new PathMap(s - 1, 0));
		int ex = 0;
		while (!q1.isEmpty()) {
			PathMap cur = q1.poll();
			if (!isTraverse[cur.toNode]) {
				if (cur.dis == 0)
					ex = cur.toNode;
				shortestPath[cur.toNode] = cur.dis;
				isTraverse[cur.toNode] = true;
				
				List<PathMap> travelPaths = adj.get(cur.toNode);
				for (int i = 0; i < travelPaths.size(); i++) {
					PathMap path = travelPaths.get(i);
					if (cur.dis + path.dis < shortestPath[path.toNode]) {
						shortestPath[path.toNode] = cur.dis + path.dis;
						if (!isTraverse[path.toNode] && q1.contains(path)) {
							q1.remove(path);
							q1.add(new PathMap(path.toNode, shortestPath[path.toNode]));
						} else if (!isTraverse[path.toNode]) {
							q1.add(new PathMap(path.toNode, shortestPath[path.toNode]));
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (!isTraverse[i])
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
	
  static class PathMap {
		int toNode;
	    Integer dis;
	    public PathMap(int v, int cost) {
	        this.toNode = v;
	        this.dis = cost;
	    }
	    
	    public static PathMap create(int v, int cost) {
	       return new PathMap(v, cost);
	    }
	}
}
