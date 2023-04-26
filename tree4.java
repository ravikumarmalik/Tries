import java.util.LinkedList;
import java.util.*;

public class tree4 {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class Info{
        Node node;
        int hd;//horizontal distance
        public Info(Node node, int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public static void topView(Node root){
        //level order
        Queue<Info> q= new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();
        int min=0,max=0;

        q.add(new Info(root,0));
        q.add(null);

        while (!q.isEmpty()){
            Info current=q.remove();
            if (current == null){
                if (q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }else {
                if (map.containsKey(current.hd)){//if true then key exist in map
                    map.put(current.hd, current.node);
                }
                if (current.node.left != null){
                    q.add(new Info(current.node.left, current.hd-1));
                    min = Math.min(min, current.hd-1);
                }
                if (current.node.right != null){
                    q.add(new Info(current.node.right, current.hd+1));
                    max=Math.max(max, current.hd+1);
                }
            }
        }
        for (int i=min; i<=max; i++){
            System.out.println(map.get(i).data+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        topView(root);
    }
}
