package chapter_1_stackandqueue;

import java.util.Stack;

public class Problem_05_StackSortStack {

	public static void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();
		while (!stack.isEmpty()) {//把整个stack的元素都过滤完,最后按照栈顶到栈底从小到大全部放入help中
			int cur = stack.pop();
			while (!help.isEmpty() && help.peek() < cur) {
				stack.push(help.pop());//把help的元素都弹入stack
			}
			help.push(cur);//help中的是栈顶到栈底从小到大,不满足就照上边把元素再倒入stack
		}
		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(1);
		stack.push(6);
		stack.push(2);
		stack.push(5);
		stack.push(4);
		sortStackByStack(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

}
