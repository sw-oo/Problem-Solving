import java.util.*;

class TrieNode {
    char data;
    int isLast;
    Map<Character, TrieNode> childNodes = new HashMap<>();
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    boolean insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(current.childNodes.containsKey(c)) {
                current = current.childNodes.get(c);
                if(current.isLast != 0) {
                    return false;
                }
            } else {
                TrieNode newChild = new TrieNode();
                newChild.data = c;
                current.childNodes.put(c, newChild);
                current = newChild;
            }
        }
        current.isLast = 1;
        return true;
    }
}

class Solution {    
    public boolean solution(String[] phone_book) {
        boolean flag;
        
        Trie tree = new Trie();
        
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length; i++) {
            flag = tree.insert(phone_book[i]);
            if(!flag) {
                return false;
            }
        }
        return true;
    }
}