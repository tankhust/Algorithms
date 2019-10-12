package 春招公司笔试20190310_20190515.test;

/**
 * @author tankInternshipInterview
 * @create 2019/03/13 15:33
 */
public class Trie {
    private class Node{
        Node[] childs = new Node[26];
        boolean isLeaf;
    }

    private Node root = new Node();

    /** Initialize your data structure here. */
    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int idx = word.charAt(0) - 'a';
        insert(word, root);
    }

    private void insert(String word, Node node){
        int idx = word.charAt(0) - 'a';
        if(node.childs[idx] == null){
            node.childs[idx] = new Node();
        }
        if(word.length() == 1) node.childs[idx].isLeaf = true;
        else insert(word.substring(1), node.childs[idx]);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Node node){
        if(node == null) return false;
        int idx = word.charAt(0) - 'a';
        if(node.childs[idx] == null) return false;
        if(word.length() == 1) return node.childs[idx].isLeaf;
        return search(word.substring(1), node.childs[idx]);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startWith(prefix, root);
    }

    private boolean startWith(String prefix, Node node){
        if(node == null) return false;
        if(prefix.length() == 0) return true;
        int idx = prefix.charAt(0) - 'a';
        return startWith(prefix.substring(1), node.childs[idx]);
    }
}
