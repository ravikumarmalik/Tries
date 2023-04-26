public class tries6 {
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

    public static int countNode(tries5.Node root){
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

    public static String ans = "";
    public static void longestWords(Node root, StringBuilder temp){
        if (root == null){
            return;
        }
        for (int i=0; i<26; i++){
            if (root.children[i] !=null && root.children[i].eow == true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if (temp.length() > ans.length()){
                    ans = temp.toString();//stringBuilder ke value ko directly string me assign ni krte so tostring method use kiye
                }
                //backtrack
                longestWords(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);

            }
        }

    }

    public static void main(String[] args) {
        String words[] = {"a", "banana","app","appl","ap","apply","apple"};
        for (int i=0; i<words.length; i++){
            insert(words[i]);
        }
        longestWords(root, new StringBuilder(""));
        System.out.println(ans);
    }
}

/*

apple

 */
