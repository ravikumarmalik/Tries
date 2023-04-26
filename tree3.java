public class tree3 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    //count of Node in a tree
    public static int countOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countOfTree(root.left);
        int rightCount = countOfTree(root.right);
        return leftCount + rightCount + 1;
    }

    //sum of Node in a tree
    public static int sumOfNode(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfNode(root.left);
        int rightSum = sumOfNode(root.right);
        return leftSum + rightSum + root.data;
    }


    //height of tree
    public static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = heightOfTree(root.left);//left Height of tree
        int rh = heightOfTree(root.right);//right height of tree
        return Math.max(lh, rh) + 1;
    }


    //Diameter of a tree
    public static int diameterOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDiameter = diameterOfTree(root.left);
        int leftHeight = heightOfTree(root.left);

        int rightDiameter = diameterOfTree(root.right);
        int rightHeight = heightOfTree(root.right);

        int selfDiameter = leftDiameter + rightDiameter + 1;
        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));

    }


//2nd method to calculate diameter.
    static class Info {
    int dia;
    int ht;

    Info(int dia, int ht) {
        this.dia = dia;
        this.ht = ht;
    }
}


    public static Info diameter2(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);

            int dia = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.ht + rightInfo.ht + 1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

            return new Info(dia, ht);
        }



//to find subTree in tree

        public static boolean isIdentical(Node node, Node subRoot) {
            if (node == null && subRoot == null) {
                return true;
            } else if (node == null || subRoot == null || node.data != subRoot.data) {
                return false;
            }
            if (!isIdentical(node.left, subRoot.left)){
                return false;
            }
            if (!isIdentical(node.right, subRoot.right)){
                return false;
            }
            return true;
        }

        public static boolean subTree(Node root, Node subRoot){
        if (root == null){
            return false;
        }
        if (root.data == subRoot.data){
            if (isIdentical(root,subRoot)){
                return true;
            }
        }
//        boolean leftAns=subTree(root.left,subRoot);//if exist in left sub tree return true
//            boolean rightAns=subTree(root.right,subRoot);//if exist in right sub tree return true

           // return leftAns || rightAns;

            return subTree(root.left,subRoot) || subTree(root.right,subRoot);
        }



    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        

//        System.out.println(heightOfTree(root));
//
//        System.out.println(countOfTree(root));
//
//        System.out.println(sumOfNode(root));

        System.out.println(diameterOfTree(root));//wrong ans
        //System.out.println(diameter2(root).dia);

        /*
        Node subRoot=new Node(2);
        subRoot.left=new Node(4);
        subRoot.right=new Node(5);

        System.out.println(subTree(root,subRoot));

         */
    }
}
