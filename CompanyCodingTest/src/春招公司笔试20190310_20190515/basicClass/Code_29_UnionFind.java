package 春招公司笔试20190310_20190515.basicClass;

import java.util.HashMap;
import java.util.List;

public class Code_29_UnionFind {//并查集
    public static class Node {
        public int value;
        public Node next;
    }


    public static class DisJointSets {
        public HashMap<Node,Node> fatherMap;
        public HashMap<Node, Integer> sizeMap;

        public void makeSets(List<Node> nodes) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public boolean isSameSet(Node node1, Node node2) {
            return (getHead(node1) == getHead(node2));
        }

        public Node getHead(Node node) {
            Node father =fatherMap.get(node);
            if (father != node) {
                father = getHead(father);
            }
            return father;
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aHead = getHead(a);
            Node bHead = getHead(b);
            if (aHead != bHead) {
                int aSetsNum = sizeMap.get(aHead);
                int bSetsNum = sizeMap.get(bHead);
                if (aSetsNum <= bSetsNum) {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetsNum + bSetsNum);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetsNum + bSetsNum);
                }
            }
        }
    }


}
