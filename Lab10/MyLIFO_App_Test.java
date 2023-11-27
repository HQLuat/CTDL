package Lab10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MyLIFO_App_Test {
	public static <E> void main(String[] args) {
		Integer[] arr = { 1, 2, 3 };
		String str = "())()()()}{{}}[]][]";

		Queue<Integer> q1 = new LinkedList<>();
		q1.offer(1);
		q1.offer(2);
		q1.offer(3);

		Queue<String> q2 = new LinkedList<>();
		q2.offer("a");
		q2.offer("b");
		q2.offer("c");

		// Testing reserve method
		System.out.println("**Result of reserve method**");
		MyLIFO_App.reserve(arr);
		System.out.println(Arrays.asList(arr));
		System.out.println("----------------------------------------------");

		// Testing isCorrect method
		System.out.println("**Result of isCorrect method**");
		System.out.println(MyLIFO_App.isCorrect(str));
		System.out.println("----------------------------------------------");

		// Testing evaluateExpression method
		System.out.println("**Result of evaluateExpression method**");
		String expression = "51+(54*(3+2))";
		String spacedExpression = MyLIFO_App.insertBlank(expression);
		int result = MyLIFO_App.evaluateExpression(spacedExpression);
		System.out.println(spacedExpression + " = " + result);
		System.out.println("----------------------------------------------");

		// Testing stutter method
		System.out.println("**Result of stutter method**");
		MyLIFO_App.stutter(q1);
		System.out.println(q1);
		System.out.println("----------------------------------------------");

		// Testing mirror method
		System.out.println("**Result of mirror method**");
		MyLIFO_App.mirror(q2);
		System.out.println(q2);
		System.out.println("----------------------------------------------");
	}
}
