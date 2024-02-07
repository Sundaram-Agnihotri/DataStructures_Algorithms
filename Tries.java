import java.util.*;

class TrieNode {
    char data;
    boolean isTerminal = false;
    TrieNode children[]; // for storing reference of all characters
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        this.isTerminal = false;
        this.children = new TrieNode[26];
        this.childCount = 0;
    }
}

public class Tries {
    private TrieNode root;

    public Tries() {
        root = new TrieNode('\0');
    }

    private void helper(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminal = true;
            return;
        }

        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }

        helper(child, word.substring(1));
    }

    public void add(String word) {
        helper(root, word);
    }

    private boolean searchhelper(TrieNode root, String word) {
        if (word.length() == 0)
            return root.isTerminal;

        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null)
            return false;

        return searchhelper(child, word.substring(1));
    }

    public boolean search(String word) {
        return searchhelper(root, word);
    }

    private void removehelper(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminal = false;
            return;
        }

        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return;
        }

        removehelper(child, word);

        if (!child.isTerminal && child.childCount == 0) {
            root.children[childIndex] = null;
            root.childCount--;
        }
    }

    public void remove(String word) {
        removehelper(root, word);
        // root.childCount--;

    }

    // this functions does not remove all the useless nodes
    public static void main(String[] args) {
        Tries t = new Tries();
        t.add("SUNDARAM");
        t.add("SUN");
        t.add("SUNDAR");
        System.out.println(t.search("SUNDAR"));
        System.out.println(t.search("SUN"));
        t.remove("SUNDAR");
        t.remove("SUN");

        System.out.println(t.search("SUN"));
        System.out.println(t.search("SUNDAR"));
        System.out.println(t.search("AMAN"));
    }
}
