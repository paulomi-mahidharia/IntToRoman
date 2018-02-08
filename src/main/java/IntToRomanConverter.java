import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * A program to take an INTEGER as an input and return ROMAN number for it.
 *
 * @author Paulomi Mahidharia
 */
public class IntToRomanConverter {

	private static Map<Integer, String> map = new HashMap<>();

	public static void main(String args[]) {

		// Adding 4, 9 and their factors of 10.
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");

		// Prints using old approach (original)
		System.out.println(intToRomanFirstPass(2005));

		// Prints using optimal recursive approach, found gradually while working on first approach
		System.out.println(intToRomanOptimal(2005));
	}

	/**
	 * Optimal solution to find Roman from Int value. Recursive in nature.
	 * Looks for nearest key in the HashMap and recursively computes Roman equivalent.
	 *
	 * @param num an integer number
	 * @return Roman number equivalent to given number
	 */
	private static String intToRomanOptimal(final int num) {
		if(num <= 0){
			return "Roman Numeral not possible";
		}
		if(map.containsKey(num)) {
			return map.get(num);
		}

		int closestKeyInMap = map.keySet().stream().min(Comparator.comparingInt(p -> Math.abs(p - num))).get();
		return (map.get(closestKeyInMap)) + intToRomanOptimal(num - closestKeyInMap);
	}

	/**
	 * First pass to find Roman from Int value. Not an optimal solution but reflects the first approach/idea.
	 * Computes with the help of several conditional modulus checks.
	 *
	 * @param num an integer number
	 * @return Roman number equivalent to given number
	 */
	private static String intToRomanFirstPass(int num) {
		int i = 0;
		final StringBuilder sb = new StringBuilder();
		final char[] romanChar = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

		while (num > 0 && i < romanChar.length - 1) {
			if (num % 10 < 4) {
				for (int j = 0; j < num % 10; j++) {
					sb.append(romanChar[i]);
				}
			} else if (num % 10 == 4) {
				sb.append(romanChar[i + 1]).append(romanChar[i]);
			} else if (num % 10 < 9) {
				for (int j = 5; j < num % 10; j++) {
					sb.append(romanChar[i]);
				}
				sb.append(romanChar[i + 1]);
			} else {
				sb.append(romanChar[i + 2]).append(romanChar[i]);
			}
			num = num / 10;
			i = i + 2;
		}
		if (num != 0) {
			for (int j = 0; j < num % 10; j++) {
				sb.append(romanChar[i]);
			}
		}
		return sb.reverse().toString();
	}
}

