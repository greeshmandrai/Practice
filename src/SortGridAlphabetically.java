import java.util.ArrayList;
import java.util.List;

public class SortGridAlphabetically {

	public static String gridChallenge(List<String> grid) {
		int n = grid.size();
		int m = grid.get(0).length();
		
		List<Character> mins = new ArrayList<>();
		for(int i =0;i<n;i++) {
			String a = grid.get(i);
			char min= a.charAt(0);
			for(int j =0;j<m-1;j++) {
				if(a.charAt(j)>a.charAt(j+1)) {
					min = a.charAt(j+1);
				}
			}
			mins.add(min);
		}
		for(int i =0;i<n-1;i++) {
			if(mins.get(i)>mins.get(i+1)) {
				return "NO";
			}
		}

		return "YES";
	}
}
