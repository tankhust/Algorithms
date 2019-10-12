package 春招公司笔试20190310_20190515.basicClass;


public class Code_31_Trie {//字典树（前缀树）

    public static class TrieNode {
        public int path;//记录多少单词公用这个节点
        public int end;//记录多少个单词以这个节点结尾
        public TrieNode[] map;//字符路径26种

        public TrieNode() {
            path=0;
            end=0;
            map = new TrieNode[26];//将26个字母包含进来
        }
    }

    public static class Trie {


        private TrieNode root;//根节点，没有字符路径

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {//添加word，可重复添加
            if (word == null) {
                return;
            }
            TrieNode node=root;
            char[] chs = word.toCharArray();
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';//字符路径key范围0~25
                if (node.map[index] == null) {
                    node.map[index] = new TrieNode();//字符路径指向的节点value
                }
                node = node.map[index];
                node.path++;
            }
            node.end++;
        }

        public void delete(String word) {//删除word,如果添加过多次，仅删除一个
            if (!search(word)) {
                return;
            }
            TrieNode node = root;
            char[] chs = word.toCharArray();
            int index=0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (--node.map[index].path==0) {
                    node.map[index] = null;
                    return;
                }
                node = node.map[index];
            }
            node.end--;
        }

        public boolean search(String word) {//查询word是否在字典树中
            if (word == null) {
                return false;
            }
            TrieNode node = root;
            char[] chs = word.toCharArray();
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.map[index] == null) {
                    return false;
                }
                node = node.map[index];
            }
            return node.end != 0;
        }

        public int prefixNumber(String pre) {//返回以字符串pre为前缀的单词数量
            if (pre == null) {
                return 0;
            }
            TrieNode node = root;
            char[] chs = pre.toCharArray();
            int index=0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.map[index] == null) {
                    return 0;
                }
                node = node.map[index];
            }
            return node.path;
        }



    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("tankInternshipInterview"));
        trie.insert("tankInternshipInterview");
        System.out.println(trie.search("tankInternshipInterview"));
        trie.delete("tankInternshipInterview");
        System.out.println(trie.search("tankInternshipInterview"));
        trie.insert("tankInternshipInterview");
        trie.insert("tankInternshipInterview");
        trie.delete("tankInternshipInterview");
        System.out.println(trie.search("tankInternshipInterview"));
        trie.delete("tankInternshipInterview");
        System.out.println(trie.search("tankInternshipInterview"));
        trie.insert("tanka");
        trie.insert("tankac");
        trie.insert("tankab");
        trie.insert("tankad");
        trie.delete("tanka");
        System.out.println(trie.search("tanka"));
        System.out.println(trie.prefixNumber("tankInternshipInterview"));
    }


}
