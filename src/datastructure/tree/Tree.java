package datastructure.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * - 데이터는 중복되지 않는다고 가정.
 * - 데이터는 int만 고려.
 */
public class Tree {

    private static final Logger log = LoggerFactory.getLogger(Tree.class);

    private Node root;

    public void createNode(int data, int left, int right) {
        if (Objects.isNull(root)) {
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

    public void preOrder(Node node) {
        if (!Objects.isNull(node)) {
            log.info("Node: {}", node);
            if (node.left != null) preOrder(node.left);
            if (node.right != null) preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if (!Objects.isNull(node)) {
            if (node.left != null) inOrder(node.left);
            log.info("Node: {}", node);
            if (node.right != null) inOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (!Objects.isNull(node)) {
            if (node.left != null) postOrder(node.left);
            if (node.right != null) postOrder(node.right);
            log.info("Node: {}", node);
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }

    /**
     *     0
     *   1    2
     * 4  5  7  8
     */
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();
        tree.createNode(0, 1, 2);
        tree.createNode(1, 4, 5);
        tree.createNode(2, 7, 8);
        tree.postOrder(tree.root);
    }
}
