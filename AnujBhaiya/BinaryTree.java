package AnujBhaiya;

import java.util.*;

public class BinaryTree {

    public static Node createTree(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Data");
        Integer data = sc.nextInt();

        if(data.equals(-1)) return null;
        Node node = new Node(data);

        System.out.println("Enter Left of "+data);
        node.left = createTree();
        System.out.println("Enter Right of "+data);
        node.right = createTree();

        return node;
    }

    public static  void inOrder(Node n){
        if(n == null) return;
        inOrder(n.left);
        System.out.print(n.data + " ");
        inOrder(n.right);
    }
    public static  void preOrder(Node n){
        if(n == null) return;
        System.out.print(n.data + " ");
        preOrder(n.left);
        preOrder(n.right);
    }
    public static  void postOrder(Node n){
        if(n == null) return;
        postOrder(n.left);
        postOrder(n.right);
        System.out.print(n.data + " ");

    }

    public static  int height(Node n){
        if(n == null) return 0;
        int temp = 0;
        int lh =  height(n.left);
        temp = Math.max(lh, temp);
        int rh = height(n.right);
        temp = Math.max(temp,rh);
        return temp+1;
    }

    public static int size(Node n){
        if(n == null) return 0;
        return size(n.left) + size(n.right) + 1;
    }

    public static int max(Node n){
        if(n == null) return  Integer.MIN_VALUE;
        int temp = n.data;
        temp = Math.max(temp,max(n.left));
        temp = Math.max(temp,max(n.right));
        return temp;
    }

    public static void levelOrder(Node n){
        Queue<Node> queue = new LinkedList<>();
        queue.add(n);
        queue.add(null);

        while (queue.size() > 0){
            Node removed = queue.remove();
            if(removed != null){
                System.out.print(removed.data + " ");
                if(removed.left != null){
                    queue.add(removed.left);
                }
                if(removed.right != null){
                    queue.add(removed.right);
                }
            }else if(removed == null && !queue.isEmpty()){
                queue.add(null);
                System.out.println();
            }

        }
    }

    public static void levelOrder2(Node n){
        HashMap<Integer,List<Node>> hash = new HashMap<>();
        levelUtil(hash,0,n);

        for (List<Node> li : hash.values()){
            System.out.println(li);
        }
    }

    public static void levelUtil(HashMap<Integer,List<Node>> hash, int level, Node n){
        if(n == null) return;
        if(hash.get(level) == null){
            List<Node> li = new ArrayList<>();
            li.add(n);
            hash.put(level,li);
        }else{
            hash.get(level).add(n);
        }

        levelUtil(hash,level+1,n.left);
        levelUtil(hash,level+1,n.right);
    }

    public static void leftView(Node n){
        List<Node> li = new ArrayList<>();

        leftViewUtil(li,0,n);
        for(Node node : li){
            System.out.print(node.data + " ");
        }
    }

    public static void leftViewUtil(List<Node> li,int level,Node n){
        if(n == null) return;
//        if(li.get(level) == null){
//            li.add(level,n);
//        }
        if(li.size() == level){
            li.add(level,n);
        }
        leftViewUtil(li,level+1,n.left);
        leftViewUtil(li,level+1,n.right);
    }
    public static void main(String[] args) {
        Node root = createTree();
        inOrder(root);
        System.out.println(height(root));
        System.out.println(size(root));
        System.out.println(max(root));
        levelOrder(root);
        levelOrder2(root);
        leftView(root);
    }

}

class Node {
    Integer data;
    Node right,left;

    Node(Integer data){
        this.data = data;
    }

    public String toString(){
        return data.toString();
    }
}
