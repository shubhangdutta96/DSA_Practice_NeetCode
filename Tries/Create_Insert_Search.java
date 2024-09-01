import java.util.*;

// Creation of Trie Node ( Node class)
class Node{
    Node[] children = new Node[26];
    boolean endOfWord = false;

    public Node(){
        for(int i=0;i<children.length;i++){
            children[i] = null;
            endOfWord = false;
        }
    }
}

public class tries{
    static Node root = new Node();

    public static void main(String args[]){
        String[] str = {"the", "the", "a", "there", "their", "thor"};
        for(int i=0;i<str.length;i++){
            insert(str[i]);  // insert op.
        } 

        // search op.
        System.out.println(search("the"));  // true
        System.out.println(search("any"));  // false
    }

    // insert 
    public static void insert(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];  // level wise 
        }
        curr.endOfWord = true;
    }

    // search
    public static boolean search(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.endOfWord == true;
    }
}
