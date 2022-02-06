package com.stack;

import java.util.Stack;

//https://www.geeksforgeeks.org/print-stack-elements-from-top-to-bottom/
/*
* Print stack without removing elements
*/
public class PrintStackTopToBottom {

	public static void PrintStack_Recursive(Stack<Integer> s) {

		if (s.isEmpty()) {
			return;
		}

		Integer x = s.pop();

		System.out.print(x + " ");

		PrintStack_Recursive(s);
		
		s.push(x); // again insert in stack
	}

	// Using another Stack
	public static void PrintStack_Iterative(Stack<Integer> s) {

		Stack<Integer> temp = new Stack<Integer>();

		while (!s.isEmpty()) {
			int x = s.pop();
			System.out.print(x + " ");
			temp.push(x);
		}

		while (!temp.isEmpty()) {
			s.push(temp.pop());
		}
	}

	public static void main(String[] args) {

		// Stack s
		Stack<Integer> s = new Stack<Integer>();

		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);

		System.out.println("Original stack");
		System.out.println(s);

		System.out.println("\n\nPrint stack top to bottom recursivelly : ");
		PrintStack_Recursive(s);
		
		System.out.println("\n\nPrint stack bottom to top iterativelly using another stack : ");
		PrintStack_Iterative(s);
		
		return ;

	}

}
