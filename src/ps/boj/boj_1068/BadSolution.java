package ps.boj.boj_1068;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class BadSolution {

    static int n;
    static int deleteNodeNumber;
    static int[] nodes;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        n = input.integer();
        nodes = new int[n];

        for (int index = 0; index < n; index++) {
            nodes[index] = input.integer();
        }

        Tree tree = new Tree(0, 0, 0);

        for (int index = 0; index < n - 2; index++) {
            tree.searchNode(tree.root, index, index + 1, index + 2);
        }

        deleteNodeNumber = input.integer();
        tree.deleteNode(tree.root, deleteNodeNumber);
        tree.postOrder(tree.root);
        System.out.println(tree);
        System.out.println(answer);
    }

    static class Tree {
        Node root;

        Tree(int data, int left, int right) {
            if (root == null) {
                this.root = new Node(data);
                if (left != 0) {
                    root.left = new Node(left);
                }
                if (right != 0) {
                    root.right = new Node(right);
                }
            } else {
                searchNode(root, data, left, right);
            }
        }

        private void searchNode(Node node, int data, int left, int right) {
            if (Objects.isNull(node)) {
                return;
            } else if (node.data == data) {
                if (left != 0) {
                    node.left = new Node(left);
                }
                if (right != 0) {
                    node.right = new Node(right);
                }
            } else {
                searchNode(node.left, data, left, right);
                searchNode(node.right, data, left, right);
            }
        }

        public void deleteNode(Node node, int data) {
            if (Objects.isNull(node)) {
                return;
            } else if (node.data == data - 1) {
                node = null;
//                node.left = null;
//                node.right = null;
            }
        }

        public void postOrder(Node node) {
            if (!Objects.isNull(node)) {
                if (node.left != null) postOrder(node.left);
                if (node.right != null) {
                    postOrder(node.right);
                } else {
                    answer++;
                }
            }
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "root=" + root +
                    '}';
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int integer() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public String getString() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}
