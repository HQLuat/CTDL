package Lab10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyLIFO_App {
	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> tmp = new Stack<E>();
		for (int i = 0; i < array.length; i++) {
			tmp.push(array[i]);
		}
		int index = 0;
		while (!tmp.isEmpty()) {
			array[index++] = tmp.pop();
		}
	}

	// This method checks the correctness of the given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==> false
	public static boolean isCorrect(String input) {
		Stack<Character> s1 = new Stack<Character>();
		Stack<Character> s2 = new Stack<Character>();
		char[] arr = input.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
				s1.push(arr[i]);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ')' || arr[i] == '}' || arr[i] == ']') {
				s2.push(arr[i]);
			}
		}
		return false;
	}

	// This method evaluates the value of an expression
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		Stack<Integer> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

			if (Character.isDigit(c)) {
				int operand = 0;
				while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
					operand = operand * 10 + Character.getNumericValue(expression.charAt(i));
					i++;
				}
				i--; // Adjust the index after extracting the entire number
				operandStack.push(operand);
			} else if (c == '(') {
				operatorStack.push(c);
			} else if (c == ')') {
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					processOperator(operandStack, operatorStack);
				}
				operatorStack.pop(); // Pop '('
			} else if (isOperator(c)) {
				while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)) {
					processOperator(operandStack, operatorStack);
				}
				operatorStack.push(c);
			}
		}

		while (!operatorStack.isEmpty()) {
			processOperator(operandStack, operatorStack);
		}

		return operandStack.pop();
	}

	private static void processOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char operator = operatorStack.pop();
		int operand2 = operandStack.pop();
		int operand1 = operandStack.pop();
		switch (operator) {
		case '+':
			operandStack.push(operand1 + operand2);
			break;
		case '-':
			operandStack.push(operand1 - operand2);
			break;
		case '*':
			operandStack.push(operand1 * operand2);
			break;
		case '/':
			operandStack.push(operand1 / operand2);
			break;
		}
	}

	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	private static int precedence(char op) {
		switch (op) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0;
		}
	}

	public static String insertBlank(String expression) {
		StringBuilder sb = new StringBuilder();

		for (char c : expression.toCharArray()) {
			if (Character.isDigit(c)) {
				sb.append(c);
			} else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')' || c == '{' || c == '}'
					|| c == '[' || c == ']') {
				sb.append(" ").append(c).append(" ");
			}
		}
		return sb.toString().trim();
	}

	// method stutter that accepts a queue of integers as a parameter and replaces
	// every element of the queue with two copies of that element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		Queue<E> tmp = new LinkedList<>();
		int size = input.size();
		tmp.addAll(input);
		input.clear();

		for (int i = 0; i < size; i++) {
			input.offer(tmp.peek());
			input.offer(tmp.poll());
		}
	}

	// Method mirror that accepts a queue of strings as a parameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		Stack<E> st = new Stack<>();
		st.addAll(input);
		while (!st.isEmpty()) {
			input.offer(st.pop());
		}
	}
}
