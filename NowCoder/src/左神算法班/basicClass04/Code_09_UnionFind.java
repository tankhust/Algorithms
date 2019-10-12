package 左神算法班.basicClass04;

import java.util.HashMap;
import java.util.List;

public class Code_09_UnionFind {//并查集

	public static class Node {
		// whatever you like
	}

	public static class DisjointSets {
		public HashMap<Node, Node> fatherMap;
		public HashMap<Node, Integer> sizeMap;

		public DisjointSets() {
		/*	makeSets();*/
		}

		public void makeSets(List<Node> nodes) {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
			fatherMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		public Node findHead(Node n) {
			Node father = fatherMap.get(n);
			if (father != n) {
				father = findHead(father);
			}
			fatherMap.put(n, father);
			return father;
		}

		public boolean isSameSet(Node a, Node b) {
			return findHead(a)== findHead(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aFather = findHead(a);
			Node bFather = findHead(b);
			if (aFather != bFather) {
				int aFrank = sizeMap.get(aFather);
				int bFrank = sizeMap.get(bFather);
				if (aFrank <= bFrank) {
					fatherMap.put(aFather, bFather);
					sizeMap.put(bFather, aFrank + bFrank);
				} else {
					fatherMap.put(bFather, aFather);
					sizeMap.put(aFather, aFrank + bFrank);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
