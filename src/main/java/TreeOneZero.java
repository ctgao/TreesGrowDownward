import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kristofer on 7/13/20.
 */
public class TreeOneZero {
    Node root;

    // constructors
    public TreeOneZero(){
        root = null;
    }
    public TreeOneZero(Integer value){
        add(value);
    }

    // ADD FUNCTION
    public void add(Integer value){
        this.root = addRecursive(root, value);
    }
    private Node addRecursive(Node current, Integer value){
        if(current == null){
            return new Node(value);
        }
        if(value <= current.value){
            current.left = addRecursive(current.left, value);
            return current;
        }
        if(value > current.value){
            current.right = addRecursive(current.right, value);
            return current;
        }
        // WE SHOULD NEVER GET HERE
        throw new RuntimeException("How did you get here???");
    }

    // FIND/GET FUNCTION
    public boolean containsNode(Integer value){
        return containsNodeRecursive(root, value);
    }
    private boolean containsNodeRecursive(Node current, Integer value){
        if(current == null){
            return false;
        }
        if(current.value == value){
            return true;
        }
        if(value < current.value){
            return containsNodeRecursive(current.left, value);
        }
        if(value > current.value){
            return containsNodeRecursive(current.right, value);
        }
        // WE SHOULD NEVER GET HERE
        throw new RuntimeException("How did you get here???");
    }

    // DELETE/REMOVE FUNCTION
    public void delete(Integer value){
        if(containsNode(value)){
            this.root = deleteRecursive(root, value);
        }
    }
    private Node deleteRecursive(Node current, Integer value){
        if(value < current.value){
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        if(value > current.value){
            current.right = deleteRecursive(current.right, value);
            return current;
        }
        // if we make it here, that means we're at the node to remove!!!
        if(current.right == null && current.left == null){
            return null;
        }
        else if(current.right == null){
            return current.left;
        }
        else if(current.left == null){
            return current.right;
        }
        else{
            //two children!
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
    }
    private int findSmallestValue(Node n){
        if(n.left == null){
            return n.value;
        }
        return findSmallestValue(n.left);
    }

    // DEPTH FIRST SEARCHES
    public String traverseInOrder(Node node){
        if(node == null){
            return "";
        }
        return traverseInOrder(node.left)
                + node.value + " "
                + traverseInOrder(node.right);
    }
    public String traversePostOrder(Node node){
        if(node == null){
            return "";
        }
        return traversePostOrder(node.left)
                + traversePostOrder(node.right)
                + node.value + " ";
    }
    public String traversePreOrder(Node node){
        if(node == null){
            return "";
        }
        return node.value + " "
                + traversePreOrder(node.left)
                + traversePreOrder(node.right);
    }

    // BREADTH FIRST SEARCHES
    public String traverseLevelOrder() {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
//            System.out.print(" " + node.value);
            sb.append(node.value + " ");
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        return sb.toString();
    }
}
