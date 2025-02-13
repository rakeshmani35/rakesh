package com.vertical.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.vertical.traversal.VerticalOrderTraversal_PreOrderTraversal_Map.Node;

// https://www.techiedelight.com/vertical-traversal-binary-tree/
// https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
// https://www.youtube.com/watch?v=PQKkr036wRc
public class VerticalOrderTraversal_levelOrderTraversal_ByUsingClass {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	// factory method for creating a Typed Pair immutable instance
	static class Pair<U, V> {
		public final U first; // consider as node
		public final V second; // consider as level

		private Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}

		public static <U, V> Pair<U, V> of(U a, V b) {
			return new Pair<>(a, b);
		}
	}

	public static void verticalOrder(Node root) {

		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		Queue<Pair<Node, Integer>> q = new ArrayDeque<>();

		// enqueue queue with HD=0
		q.add(Pair.of(root, 0));
		while (!q.isEmpty()) {

			Node node = q.peek().first; // Retrieves node, but does not remove
			Integer level = q.peek().second; // Retrieves level, but does not remove

			q.poll(); // Retrieves and removes node and level

			if (map.containsKey(level)) {
				List<Integer> list = map.get(level);
				list.add(node.data);
				map.put(level, list);
			} else {
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(node.data);
				map.put(level, al);
			}

			if (node.left != null) {
				q.add(Pair.of(node.left, level - 1));
			}
			if (node.right != null) {
				q.add(Pair.of(node.right, level + 1));
			}
		}
		
		for (List<Integer> list : map.values()) {
			System.out.println(list);
		}
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);

		verticalOrder(root);

	}

}
