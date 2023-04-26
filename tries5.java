public class tries5 {
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

    public static int countNode(Node root){
        if (root == null){
            return 0;
        }
        int count = 0;
        for (int i=0; i<26; i++){
            if (root.children[i] != null){
                count += countNode(root.children[i]);
            }

        }
        return count+1;

    }

    public static void main(String[] args) {
        String str= "ababa";

        //suffix -> insert in tries
        for (int i=0; i<str.length(); i++){
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println(countNode(root));
    }

}

/*

10

 */
