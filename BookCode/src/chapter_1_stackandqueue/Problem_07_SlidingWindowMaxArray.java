package chapter_1_stackandqueue;

import java.util.LinkedList;

public class Problem_07_SlidingWindowMaxArray {

	public static int[] getMaxWindow(int[] arr, int w) {
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {//这里在进行比较
				qmax.pollLast();//小于等于才弹出 ,5来的时候会把4,3的下标都弹出
			}
			qmax.addLast(i);//存放arr中的下标,最开始存放0,大于rr[i]的直接放进qmax
			if (qmax.peekFirst() == i - w) {
				qmax.pollFirst();//队头下标过期,始终维护qmax的宽度为w,第一个索引对应的始终是窗口状态下的最大值
			}
			if (i >= w - 1) {
				res[index++] = arr[qmax.peekFirst()];//收集最大值
			}
		}
		return res;
	}

	// for test
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };//8
		int w = 3;//窗口宽度
		printArray(getMaxWindow(arr, w));

	}

}
