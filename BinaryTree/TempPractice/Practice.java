import java.util.Stack;

class Node {
    int data;
    public Node left;
    public Node right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class Pair {
    Node node;
    int indicator;

    Pair(Node node) {
        this.node = node;
        this.indicator = 1;
    }
}

public class Practice {

    public static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        int[] eulerPath = { 10, 20, -1, -1, 30, -1, 40, 50, -1, -1, 60, -1, -1 };

        Stack<Pair> stack = new Stack<>();

        Node root = new Node(eulerPath[0]);
        Pair p = new Pair(root);
        stack.push(p);

        int i = 1;
        while (stack.size() > 0) {
            Pair element = stack.peek();
            if (element.indicator == 1) {
                if (eulerPath[i] != -1) {
                    Node node = new Node(eulerPath[i]);
                    element.node.left = node;
                    Pair p1 = new Pair(node);
                    stack.push(p1);
                }
                element.indicator++;
                i++;
            } else if (element.indicator == 2) {
                if (eulerPath[i] != -1) {
                    Node node = new Node(eulerPath[i]);
                    element.node.right = node;
                    Pair p2 = new Pair(node);
                    stack.push(p2);
                }
                element.indicator++;
                i++;
            } else if (element.indicator == 3) {
                stack.pop();
            }

        }

        preOrder(root);
    }
}
