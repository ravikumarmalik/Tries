import javax.swing.*;
public class tries2 {
        static class Node {
            Node children[] = new Node[26];
            boolean eow = false;//end of word

            Node() {
                for (int i = 0; i < 26; i++) {
                    children[i] = null;
                }
            }
        }

        public static Node root = new Node();

        public static Void Insert(String arr) {
            Node curr = root;
            for (int level = 0; level < arr.length(); level++) {
                int idx = arr.charAt(level) - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }
            curr.eow = true;
            return null;
        }
        public static boolean Search(String key){
            Node curr = root;
            for (int level = 0; level < key.length(); level++) {
                int idx = key.charAt(level) - 'a';
                if (curr.children[idx] == null) {
                    return false;
                }
                curr = curr.children[idx];
            }
            return curr.eow == true;
        }

        public static boolean wordBreak(String key){ //o(n)
            if (key.length()==0){
                return true;
            }
            for (int i=0; i<=key.length(); i++){
                //substring(first index, last index) last index select ni hoga
               if (Search(key.substring(0,i)) &&
                       wordBreak(key.substring(i))){
                   return true;
                }

            }
            return false;
        }

        public static void main(String[] args) {
            String arr[] = {"i","like","sam","samsung","mobile","ice"};
            for (int i=0; i<arr.length; i++){
                Insert(arr[i]);
            }
            String key = "ilikesamsung";
            System.out.println(wordBreak(key));

        }
    }

    /*

    true

     */



