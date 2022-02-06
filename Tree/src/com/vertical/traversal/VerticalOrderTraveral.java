package com.vertical.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class VerticalOrderTraveral {

	public static TreeMap<Integer, ArrayList> ht = new TreeMap<>();
    public ArrayList<Integer> al;
	
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	// Pre-Order Traversal
	public  void verticalTraversal(Node root, int level) {
		
		if (root == null) {
			return;
		}
		if (ht.containsKey(level)) {
			ArrayList list = ht.get(level);
			list.add(root.data);
			ht.put(level, list);
		}else {
			al = new ArrayList<Integer>();
			al.add(root.data);
			ht.put(level, al);
		}
		verticalTraversal(root.left, level-1);
		verticalTraversal(root.right, level+1);
	}
	
	public void verticalTraversalByQueue(Node root) {
		
		if (root == null) {
			return;
		}
		
		Node current =root;
		Queue<Node> queue = new LinkedList<Node>();
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		 ArrayList<Integer> list;
		 int hd = 0;
		 int left = hd;
			int right = hd;
		 list = new ArrayList<Integer>();
			list.add(current.data);
			map.put(hd, list);
		 
		 queue.add(current);
		while (!queue.isEmpty()) {
			
//			if (current==root) {
//				hd = 0;
//				list = new ArrayList<Integer>();
//				list.add(current.data);
//				map.put(hd, list);
//			}
			
			Node poll = queue.poll();
			if (poll.left!=null) {
				queue.add(poll.left);
				left = left-1;
				if (map.containsKey(left)) {
					list = map.get(left);
				}else {
					list = new ArrayList<Integer>();
				}
				
				list.add(poll.left.data);
				map.put(left, list);
			}
			if (poll.right!=null) {
				queue.add(poll.right);
				right = right+1;
				if (map.containsKey(right)) {
					list = map.get(right);
				}else {
					list = new ArrayList<Integer>();
				}
				list.add(poll.right.data);
				map.put(right, list);
			}
		}
		printResult(map);
	}
	
	public void printResult(TreeMap ht) {
        Set<Integer> i = ht.keySet();
        for (int keys : i) {
            System.out.println(ht.get(keys));
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
		
		VerticalOrderTraveral vertical = new VerticalOrderTraveral();
		vertical.verticalTraversal(root, 0);
		vertical.printResult(ht);
		
		//vertical.verticalTraversalByQueue(root);
		
	}

}
