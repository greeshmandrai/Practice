import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Rough {

	public static void levelOrder(Node root) {
		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();
		q1.add(root);
		Node cur = null;
		while (!q1.isEmpty() || !q2.isEmpty()) {
			while (!q1.isEmpty()) {
				cur = q1.poll();
				if (cur.left != null) {
					q2.add(cur.left);
				}
				if (cur.right != null) {
					q2.add(cur.right);
				}
				System.out.print(cur.data + " ");
			}
			while (!q2.isEmpty()) {
				cur = q2.poll();
				if (cur.left != null) {
					q1.add(root.left);
				}
				if (cur.right != null) {
					q1.add(root.right);
				}
				System.out.print(cur.data + " ");
			}
		}
		
		/*
		public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
	        List<Integer> a = new ArrayList<>();
	        Map<Integer,<Map<Integer, Integer>>> q2 = new HashMap<>();
	        Map<Integer, Integer> q1 = new HashMap<>();
	        
	        for(int i =0;i<=edges.size();i++){  
	            List<Integer> q3 = edges.get(i);
	                int st = q3.get(0);
	                int end = q3.get(1);
	                int dis = q3.get(2);
	                if(st==(i+1)){
	                    q1.put(end, dis); 
	                } else if(end ==(i+1)){
	                    q1.put(st, dis); 
	                }
	            q2.add(i+1, q1);
	        }
	        System.out.println(q2);
	        /*
	        Map<Integer, Integer> q1 = new HashMap<>();
	        Map<Integer, Integer> q2 = new HashMap<>();
	        for(int i =s;i<n;i++){
	            for(int j =s+1;i<n;j++){
	                boolean cons = edges.get(i) == i+1 || edges.get(i+1) == i+1 ;
	                if(cons){
	                    q1.put(i+1, q1.poll());
	                }
	            }
	            q2.put(i+1, q1.poll());
	        }
	        
	        Map<Integer, Integer> a1 = q2.get(1);
	        for(int i =2;i<3;i++){
	            a.add(a1.get(i));
	        }
	        
	        return a;
	    }
	*/
	  
	}


}
