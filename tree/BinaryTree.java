

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
public class BinaryTree{

    public static class Node{
        public int value;
        public Node left; // left child
        public Node right;// right child

        public Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {

        //创建一颗树
        //        5
        //    4      7
        //  1   6   3   8
        Node head = initTree();

        //先序遍历
        print("先序遍历:");
        proorderTraverseTree(head);
        print("\r\n");

        //中序遍历
        print("中序遍历:");
        inorderTraverseTree(head);
        print("\r\n");

        //后序遍历
        print("后序遍历:");
        postorderTraverseTree(head);
        print("\r\n");

        //层次遍历
        print("层次遍历:");
        levelTraverseTree(head);
        print("\r\n");

        //树的高度
        int high = geHeight(head);
        print("Tree height : " + high);
        print("\r\n");

        //树的宽度
        int width = getWidth(head);
        print("Tree width : " + width);
        print("\r\n");

        //树所有节点的个数
        int numbers = getNumbers(head);
        print("Tree All Nodes Number  : " + numbers);
        print("\r\n");

        //是否是满二叉树
         boolean b1 = isFullBinaryTree(head);
         print("isFullBinaryTree : " + b1);
         print("\r\n");

        //是否是完全二叉树
        boolean b2 = isCompleteBinaryTree(head);
        print("isCompleteBinaryTree : " + b2);
        print("\r\n");



        //是否是平衡二叉树
        boolean b3 =  isBalancedBinaryTree(head);
        print("isBalancedBinaryTree : " + b3);
        print("\r\n");


        //是否为搜索二叉树
        boolean b4 = isBinarySearchTree(head);
        print("isBinarySearchTree : " + b4);
        print("\r\n");


        /*  out
            先序遍历:5 4 1 6 7 3 8
            中序遍历:1 4 6 5 3 7 8
            后序遍历:1 6 4 3 8 7 5
            层次遍历:5 4 7 1 6 3 8
            Tree height : 3
            Tree width : 4
            Tree All Nodes Number  : 7
            isFullBinaryTree : true
            isCompleteBinaryTree : true
            isBalancedBinaryTree : true
            isBinarySearchTree : true
        */
    }


    public static boolean isBinarySearchTree(Node head){//还可以 看中序遍历是不是递增的序列 判断
        if(head == null)
            return true;
        if(head.left != null && head.left.value > head.value){
            return  false;
        }
        if(head.right != null && head.right.value < head.value){
            return  false;
        }
        return isBinarySearchTree(head.left) && isBinarySearchTree(head.right);
    }

    public static boolean isFullBinaryTree(Node head){
        return  (1<<geHeight(head))-1 == getNumbers(head);
    }

    public static boolean isCompleteBinaryTree(Node head){
        if(head == null)
            return false;
        Queue<Node> queue  = new LinkedList<Node>();
        queue.offer(head);
        Node cur;
        boolean flag = false;
        while(!queue.isEmpty()){
            cur = queue.poll();

            if(cur.right != null && cur.left != null ){
                queue.offer(cur.right);
                queue.offer(cur.left);
            }
            if(cur.right != null && cur.left == null) return false;
            if(cur.right == null) {
                flag = true;
            }

            if(flag && ( cur.left !=null || cur.right != null)){
                return false;
            }
        }

        return true;
    }

    public static boolean isBalancedBinaryTree(Node head){
        if(head == null)
            return  true;
        if(Math.abs(geHeight(head.left)-geHeight(head.right)) > 1 )
            return  false;
        return  isBalancedBinaryTree(head.left) && isBalancedBinaryTree(head.right);
    }



    public static int getWidth(Node head){
        if(head == null)
            return 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(head);
        int maxWidth = 1;
        int curLevelWidth;
        while(!queue.isEmpty()){
            head = queue.poll();
            if(head.left != null) queue.offer(head.left);
            if(head.right != null) queue.offer(head.right);
            curLevelWidth = queue.size();
            maxWidth = Math.max(curLevelWidth,maxWidth);
        }
        return  maxWidth;
    }


    public static int geHeight(Node head){
        if(head == null)
            return 0;
        int l = geHeight(head.left);
        int r = geHeight(head.right);
        return  Math.max(l,r)+1;
    }

    public static int getNumbers(Node head){
        if(head == null)
            return 0;
        int l = getNumbers(head.left);
        int r = getNumbers(head.right);
        return  l+r+1;
    }

    public static void proorderTraverseTree(Node head){
        if(head == null)
            return ;
        System.out.print(head.value +" ");
        proorderTraverseTree(head.left);
        proorderTraverseTree(head.right);
    }

    public static void inorderTraverseTree(Node head){
        if(head == null)
            return ;
        inorderTraverseTree(head.left);
        System.out.print(head.value +" ");
        inorderTraverseTree(head.right);
    }


    public static void postorderTraverseTree(Node head){
        if(head == null)
            return ;
        postorderTraverseTree(head.left);
        postorderTraverseTree(head.right);
        System.out.print(head.value +" ");
    }

    public static void levelTraverseTree(Node head){
        if(head == null)
            return ;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            System.out.print(head.value+" ");
            if(head.left != null) queue.offer(head.left);
            if(head.right != null) queue.offer(head.right);
        }
    }


    public static Node initTree(){
        //         5
        //    4      7
        //  1   6   3   8
        Node  head ;
        head = new Node(5);
        head.left = new Node(4);
        head.right = new Node(7);
        head.left.left = new Node(1);
        head.left.right = new Node(6);
        head.right.left = new Node(3);
        head.right.right = new Node(8);
        return  head;
    }

    public static  void print(Object mes){
        System.out.print(mes);
    }

}
