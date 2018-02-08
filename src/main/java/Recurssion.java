import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Recurssion {

	public static void main(String arg[]) {

//		Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5);
//
//		System.out.println(ints.reduce((i, j) -> i+j).get());

		// Factorial
		System.out.println(factorial(0));

		// Sum of digits
		System.out.println(sum(1077));

		// Power of digits
		System.out.println(power(2, 5));

		// Fibonacci
		printFibo(5);

		System.out.println(palindrome("adbda"));

		int[] a = { 5, 10, 15, 20, 25, 30 };
		System.out.println(binarySearch(a, 5));

	}

	private static boolean binarySearch(int[] a, int i) {

		int left = 0;
		int right = a.length - 1;

		while (left < right) {
			int mid = (int) Math.floor((left + right) / 2);
			if(a[mid] == i) {
				return true;
			} else if(a[mid] < i) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return false;
	}

	private static int factorial(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		return n * factorial(n-1);
	}

	private static int sum(int n) {
		if(n % 10 == n){
			return n;
		}
		return (n % 10) + sum(n/10);
	}

	private static int power(int n, int p) {
		if(p == 0){
			return 1;
		} else if(p == 1) {
			return n;
		}
		return n * power(n, p-1);
	}

	private static void printFibo(int n) {
		for (int i = 1; i <= n; i++)
			System.out.print(fibonacci(i) + " ");
	}

	private static int fibonacci(int number){
		if(number == 1 || number == 2){
			return 1;
		}

		return fibonacci(number-1) + fibonacci(number -2); //tail recursion
	}

	private static boolean palindrome(String s) {
		char[] chars = s.toCharArray();

		int i = 0;
		int j = chars.length - 1;

		while (i<j){
			if (chars[i] != chars[j]) {
				return false;
			}else{
				i++;
				j--;
			}
		}
		return true;
	}

	private static void reverseLinkedList(LinkedList list) {
		System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
	}
}
