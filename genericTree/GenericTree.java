package genericTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public static void main(String[] args) {
        int[] eulerPath = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
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
    }

}
