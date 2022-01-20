import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Brackets {

	public static void isBalanced() {
		String s = "{";
		Map<Character, Character> a = new HashMap<>();
		a.put('(', ')');
		a.put('{', '}');
		a.put('[', ']');
		char[] c = s.toCharArray();
		for(int i=0; i<s.length(); i++) {
			char clos = a.get(c[i]);
			int cloI = s.indexOf(clos);
			if(i==cloI) {
				i = cloI;
			} else if(clos == -1)
			{
				System.out.println("NO");
				return;
			} else {
				boolean bal = checkBrackets(cloI, a, s.substring(i, cloI));
				if(!bal) {
					System.out.println("NO");
					return;
				}
			}
			
		}
		System.out.println("YES");
	}
	
	
	public static boolean checkBrackets(int j, Map<Character, Character> a, String s) {
		for(int i=0; i<j+1; i++) {
			char clos = a.get( s.charAt(i));
			int cloI = s.indexOf(clos);
			if(i==cloI) {
				i = cloI;
			} else if(clos == -1)
			{
				System.out.println("NO");
				return false;
			} else {
				checkBrackets(cloI, a, s.substring(i, cloI));
			}
			
		}
		return true;
	}
}
