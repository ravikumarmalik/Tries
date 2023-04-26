public class tries4 {
    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;
        int frequency;
        public Node() {
            for (int i=0; i<children.length; i++){
                children[i]=null;
            }
            frequency = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for (int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if (curr.children[idx] == null){
                curr.children[idx] = new Node();
            }else {
                curr.children[idx].frequency++;
            }
            curr=curr.children[idx];
        }
        curr.eow = true;
    }

    public static void findPrefix(Node root, String ans){ //o(n)
        if (root == null){
            return;
        }

        if (root.frequency == 1){
            System.out.print(ans+" ");
            return;
        }

        for (int i=0; i<root.children.length; i++){

            if (root.children[i] != null){
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }

        }
    }

    public static boolean startWith(String prefix){
        Node curr=root;

        for (int i=0; i<prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String word[] = {"apple", "app", "mango", "man", "woman"};
        String prefix1 = "app";
        String prefix2 = "moon";

        for (int i=0; i<word.length; i++){
            insert(word[i]);
        }
        System.out.println(startWith(prefix1));
        System.out.println(startWith(prefix2));

    }
}

/*

true
false

 */
