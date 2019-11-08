package com.date;

public class BinaryTree<T> {
    //根节点，二叉树链表结点结构
    public BinaryNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public BinaryNode<T> insert(T x) {
        return this.root = new BinaryNode<T>(x, this.root, null);
    }

    //插入x为parent结点的左/右孩子，leftChild指定孩子，取值为true(左),false(右)
    //
    //
    public BinaryNode<T> insert(BinaryNode<T> parent, T x, boolean leftChild) {
        if (x == null)
            return null;
        if (leftChild)
            return parent.left = new BinaryNode<T>(x, parent.left, null);
        return parent.right = new BinaryNode<T>(x, null, parent.right);
    }

    public BinaryTree(T[] prelist) {
        this.root = create(prelist);
    }

    private int i = 0;

    private BinaryNode<T> create(T[] prelist) {
        BinaryNode<T> p = null;
        if (i < prelist.length) {
            T elem = prelist[i];
            i++;
            if (elem != null) {
                p = new BinaryNode<T>(elem);
                System.out.println(p.data.toString());
                p.left = create(prelist);

                p.right = create(prelist);
            }
        }
        return p;
    }

    public void inorder() {
        inorder(this.root);
        System.out.println();
    }

    public void inorder(BinaryNode<T> p) {
        if (p != null) {
            inorder(p.left);
            System.out.println(p.data.toString() + "");
            inorder(p.right);
        }
    }

    public void preorder() {
        preorder(this.root);
        System.out.println();
    }

    private void preorder(BinaryNode<T> p) {
        if (p != null) {
            System.out.println(p.data.toString() + "");
            preorder(p.left);
            preorder(p.right);
        }
    }

    int x = 0;

    private int size() {
        size(this.root);
        return x;
    }

    private int size(BinaryNode<T> p) {
        x++;
        size(p.left);
        size(p.right);
        return x;
    }


    public static void main(String[] args) {
        String[] prelist = {"A", "B", "D", null, "G", null, null, null, "C", "E", null, null, "F", "H"};
        BinaryTree<String> bitree = new BinaryTree<String>(prelist);
        System.out.println("先根次序遍历二叉树：" + bitree.toString());
//        System.out.println("中根次序遍历二叉树：")+bitree.inorder();

    }
}
