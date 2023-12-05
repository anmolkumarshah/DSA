package genericTree;

import java.util.*;

public class GenericTree {

    private static class Node{
        Integer data;
        List<Node> children = new ArrayList<>();

        Node(Integer data){
            this.data = data;
        }

        public void add(Node n){
            this.children.add(n);
        }


    }

    public static void display(Node root){
        String str = root.data + " -> ";
        for(Node n : root.children){
            str+= n.data + " ";
        }
        str += " . ";
        System.out.println(str);
        for(Node n : root.children){
            display(n);
        }
    }

    public static int size(Node node){
        int size = 1;
        for(Node child : node.children){
            size += size(child);
        }
        return size;
    }

    public static int height(Node n){
        int ht = -1;
        // wrt edge calculation
        // for node put ht = 0
        for(Node child : n.children){
            int ch = height(child);
            ht = Math.max(ch,ht);
        }
        return ht+1;
    }

    public static void preOrder(Node n){
        System.out.print(n.data + " ");
        for(Node child :n.children){
            preOrder(child);
        }
    }

    public static void postOrder(Node n){
        for(Node child :n.children){
            postOrder(child);
        }
        System.out.print(n.data + " ");
    }

    public static  void levelOrder(Node n){
        // remove print add
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(n);
        while(queue.size() > 0){
            Node removed = queue.remove();
            System.out.print(removed.data + " ");
            for(Node child : removed.children){
                queue.add(child);
            }
        }
    }

    public static void levelOrderLineWise(Node n){
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(n);
        Queue<Node> cq = new ArrayDeque<>();

        while (mq.size() > 0){
            Node removed = mq.remove();
            System.out.print(removed.data + " ");
            for(Node child : removed.children){
                cq.add(child);
            }
            if(mq.size() == 0){
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    public static void levelOrderLineWiseZigZag(Node n){
        Stack<Node> ms = new Stack<>();
        ms.push(n);
        Stack<Node> cs = new Stack<>();

        int level =1;
        while (ms.size() > 0){
            Node popped = ms.pop();
            System.out.print(popped.data + " ");
            if(level % 2 != 0){
                // left ->
                for(int i=0;i<popped.children.size();i++){
                    cs.push(popped.children.get(i));
                }
            }else{
                // right <-
                for(int i=popped.children.size()-1;i>=0;i--){
                    cs.push(popped.children.get(i));
                }
            }
            if(ms.size() == 0){
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    public static void mirror(Node node){
        for(Node child:node.children){
            mirror(child);
        }
        Collections.reverse(node.children);
    }

    public static void removeLeafNode(Node n){
        for(int i=n.children.size()-1;i>=0;i--){
            Node node = n.children.get(i);
            if(node.children.size() == 0){
                n.children.remove(node);
            }
        }
        for(Node child : n.children){
            removeLeafNode(child);
        }
    }

    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;
    public static void ceilAndFloor(Node n,int data){
        if(n.data>data){
            if(n.data<ceil){
                ceil = n.data;
            }
        }
        if(n.data<data){
            if(n.data > floor){
                floor = n.data;
            }
        }
        for(Node child : n.children){
            ceilAndFloor(child,data);
        }
    }

    public static int KthLargestElement(Node n,int k){
        int factor = Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            ceilAndFloor(n,factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }
        return factor;
    }


    public static void main(String[] args) {
//        int[] eulerPath = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        int[] eulerPath = {10,20,-1,30,40,-1,50,60,-1,-1,-1,-1};
        Node root = null;
        Stack<Node> stack = new Stack<>();

        for(int element : eulerPath){
            if(element != -1){
                Node node = new Node(element);
                if(stack.size() == 0){
                    root = node;
                }else{
                    stack.peek().add(node);
                }
                stack.push(node);
            }else{
                stack.pop();
            }
        }

        display(root);
        System.out.println("Size of tree -> "+size(root));
        System.out.println("Height of tree -> "+height(root));
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println();
//        levelOrderLineWise(root);
        System.out.println();
//        levelOrderLineWiseZigZag(root);
//        mirror(root);
//        removeLeafNode(root);
        levelOrder(root);
        ceilAndFloor(root,35);
        System.out.println();
        System.out.println(ceil);
        System.out.println(floor);
        System.out.println(KthLargestElement(root,1));
    }

}
