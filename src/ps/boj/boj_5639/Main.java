package ps.boj.boj_5639;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        Node node = new Node(input.integer());
        while (true) {
            String str = input.br.readLine();
            if (str == null || str.equals("")) break;
            node.insert(Integer.parseInt(str));
        }
        node.postOrder(node);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public void insert(int data) {
            if (this.data < data) {
                if (this.right == null) {
                    this.right = new Node(data);
                } else {
                    this.right.insert(data);
                }
            } else {
                if (this.left == null) {
                    this.left = new Node(data);
                } else {
                    this.left.insert(data);
                }
            }
        }

        public void postOrder(Node node) {
            if (node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    static Main.Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int integer() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}
