class Trie {
    class Node {
        Node[] son = new Node[26];
        boolean end = false;
    }

    private final Node root = new Node();


    public void insert(String word){
        Node cur = root;
        for (char c: word.toCharArray()){
            c -= 'a';
            if(cur.son[c] == null){
                cur.son[c] = new Node();
            }
            cur = cur.son[c];
        }
        cur.end = true;

    }

    public boolean search(String word){
        return find(word) == 2;
    }

    public boolean startsWith(String prefix){
        return find(prefix) != 0;
    }


    public int find(String word){
        Node cur = root;
        for(char c: word.toCharArray()){
            c -= 'a';
            if(cur.son[c] == null){
                return 0;
            }
            cur = cur.son[c];
        }

        return cur.end ? 2 : 1;
    }
}