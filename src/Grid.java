import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Grid {

	public static void sd(String[] args) {
		//"ebacd", "fghij", "olmkn", "trpqs", "xywuv"
		//"abc", "hjk", "mpq", "trpqs", "xywuv"
		//"abc", "lmp", "qrt"
		
		//"kc","iu"
	//"uxf","vof", "hmp"

		List<String> grid =  Arrays.asList("kc","iu");
		String a = gridChallenge(grid);
		System.out.println(a);
	}

	public static String gridChallenge(List<String> grid) {
		int n = grid.size();
		int m = grid.get(0).length();
		char temp;
		for(int i =0;i<n;i++) {
			String a = grid.get(i);
			for(int j =0;j<m-1;j++) {
				if(a.charAt(j)>a.charAt(j+1)) {	
					temp = a.charAt(j+1);
					a = a.replace(a.charAt(j+1), a.charAt(j));
					a = a.replace(a.charAt(j), temp);
				}
			}
		}
		for(int i =0;i<n-1;i++) {
			if( grid.get(i).charAt(0)>grid.get(i+1).charAt(0)) {
				return "NO";
			} else if( grid.get(i).charAt(0)==grid.get(i+1).charAt(0)) {
				String a = grid.get(i);
				for(int j =0;j<m-1;j++) {
					if( grid.get(i).charAt(j)>grid.get(i+1).charAt(j)) {
						return "NO";
					}
				}
			} 
		}

		return "YES";
	}
}
