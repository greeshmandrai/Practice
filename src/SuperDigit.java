import java.io.IOException;

public class SuperDigit {
	public static void sd() {
		System.out.println(superDigit("123", 3));
	}

	public static int superDigit(String n, int k) {
		int sum = 0;
		for (int i = 0; i < n.length(); i++) {
			sum += Character.getNumericValue(n.charAt(i));
		}
		sum = sum * k;
		while (sum > 9) {
			sum = addDigits(sum);
		}
		return sum;
	}

	public static int addDigits(int a) {
		int sum = 0;
		while (a > 0) {
			int d = a % 10;
			sum += d;
			a = a / 10;
		}
		return sum;
	}
}
