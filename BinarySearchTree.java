package tree;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    private class Node {
        T data;
        Node left, right;

        public Node(T d) {
            data = d;
            left = right = null;
        }
    }
 
    private Node insertRec(Node root, T d) {
        if (root == null) {
            root = new Node(d);
        } else if (d.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, d);
        } else {
            root.right = insertRec(root.right, d);
        }
        return root;
    }

    public void insert(T d) {
        root = insertRec(root, d);
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    public void delete(T key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, T key) {
        if (root == null) return null;

        if (key.compareTo(root.data) < 0) {
            root.left = deleteRec(root.left, key);
        } else if (key.compareTo(root.data) > 0) {
            root.right = deleteRec(root.right, key);
        } else {
            // Case 1: No child
            if (root.left == null && root.right == null)
                return null;

            // Case 2: One child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Case 3: Two children
            // Get inorder successor (minimum in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private T minValue(Node root) {
        T minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(7);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(6);
        bst.insert(8);

        System.out.print("Pre Order : ");
        bst.preOrder();
        System.out.println();

        System.out.print("In Order : ");
        bst.inOrder();
        System.out.println();

        System.out.print("Post Order : ");
        bst.postOrder();
        System.out.println();
        bst.delete(0);
    }
}
