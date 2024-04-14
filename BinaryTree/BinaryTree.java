package BinaryTree;

import java.util.ArrayDeque;
import java.util.Stack;

public class BinaryTree {

    static class Node {
        Integer data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.right = right;
            this.left = left;
        }
    }

    static class Pair {
        Node n;
        int state;

        Pair(Node n) {
            this.n = n;
            this.state = 1;
        }
    }

    public static void display(Node root) {
        if (root == null)
            return;
        String right = root.right != null ? root.right.data.toString() : ".";
        String left = root.left != null ? root.left.data.toString() : ".";
        System.out.println(left + "<-" + root.data + "->" + right);

        display(root.left);
        display(root.right);
    }

    public static int height(Node n) {
        if (n == null)
            return 0;
        int temp = 0;
        int lh = height(n.left);
        temp = Math.max(lh, temp);
        int rh = height(n.right);
        temp = Math.max(temp, rh);
        return temp + 1;
    }

    public static void levelOrder(Node root) {
        if (root == null)
            return;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() > 0) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node n = queue.remove();
                System.out.print(n.data + " ");
                if (n.left != null)
                    queue.add(n.left);
                if (n.right != null)
                    queue.add(n.right);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Integer[] eulerPath = { 10, 20, null, null, 30, null, 40, 50, null, null, 60, null, null };
        Stack<Pair> stack = new Stack<>();

        Node root = new Node(eulerPath[0], null, null);
        Pair p = new Pair(root);
        stack.push(p);

        int i = 1;
        while (stack.size() > 0) {
            Pair peek = stack.peek();
            if (peek.state == 1) {
                // left
                Integer element = eulerPath[i];
                if (element != null) {
                    Node node = new Node(element, null, null);
                    peek.n.left = node;
                    Pair p1 = new Pair(node);
                    stack.push(p1);
                }
                peek.state++;
                i++;

            } else if (peek.state == 2) {
                // right
                Integer element = eulerPath[i];
                if (element != null) {
                    Node node = new Node(element, null, null);
                    peek.n.right = node;
                    Pair p1 = new Pair(node);
                    stack.push(p1);
                }
                peek.state++;
                i++;

            } else if (peek.state == 3) {
                // pop
                stack.pop();
            }

        }

        // display(root);
        // System.out.println(height(root));
        levelOrder(root);
    }

}
