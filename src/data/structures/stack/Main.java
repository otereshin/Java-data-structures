package data.structures.stack;

public class Main {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("1");
		stack.push("2");
		stack.push("5");
		for (String str : stack) {
			System.out.println(str);
		}
	}

}
