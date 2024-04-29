import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(br.readLine());
        BST bst = new BST(value);

        while (true) {
            String str = br.readLine();
            if (str == null || str.equals("")) break;
            value = Integer.parseInt(str);
            bst.insert(value);
        }

        bst.postorder(bst.root);
    }


}

class Node {
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int value) {
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    public void insertLeft(Node node) {
        leftChild = node;
    }

    public void insertRight(Node node) {
        rightChild = node;
    }

}

class BST {
    Node root;
    public BST(int value) {
        root = new Node(value);
    }
    public void insert(int value) {
        Node node = root;
        while (true) {
            if (value < node.value) {
                if (node.leftChild == null) {
                    node.leftChild = new Node(value);
                    return;
                }
                node = node.leftChild;
            }
            else if (node.value < value) {
                if (node.rightChild == null) {
                    node.rightChild = new Node(value);
                    return;
                }
                node = node.rightChild;
            }
        }
    }

    public static void postorder(Node node){
        if (node != null) {
            if (node.leftChild != null) postorder(node.leftChild);
            if (node.rightChild != null) postorder(node.rightChild);
            System.out.println(node.value);
        }
    }
}