package chapter_1_stackandqueue;

import java.util.Stack;

public class Problem_03_ReverseStackUsingRecursive {//如何仅用递归函数和栈操作逆序一个栈

	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int i = getAndRemoveLastElement(stack);//结合书上的图来看这两个递归函数的描述
		reverse(stack);
		stack.push(i);//限压入的是3
	}

	public static int getAndRemoveLastElement(Stack<Integer> stack) {//获取并删除栈底元素,返回栈底元素
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}

	public static void main(String[] args) {
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		reverse(test);
		while (!test.isEmpty()) {
			System.out.println(test.pop());//1,2,3,4,5
		}

	}

}
