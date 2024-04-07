import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.createNode(parent, left, right);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);

    }
}

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
    }

    public void insertLeft(char data) {
        this.left = (data == '.') ? null : new Node(data);
    }

    public void insertRight(char data) {
        this.right = (data == '.') ? null : new Node(data);
    }
}

class Tree{
    Node root;

    public void createNode(char parent, char left, char right) {
        if (root == null) {
            root = new Node(parent);
            root.insertLeft(left);
            root.insertRight(right);
        } else {
            //부모찾아서 거기에 left, right 삽입
            searchNode(root, parent, left, right);
        }
    }

    public void searchNode(Node node, char parent, char left, char right) {
        if (node == null) return;
        if (node.data == parent) {
            node.insertRight(right);
            node.insertLeft(left);
            return;
        }
        searchNode(node.left, parent, left, right);
        searchNode(node.right, parent, left, right);
    }

    public void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }
    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

}