import java.util.Stack;

public class ExpressionTree<E> {
    private Node<E> root;

    //node class (some problems with compiling so I just put node class into expressionTree class)
    public class Node<E> {
        public E element;
        public Node<E> leftChild;
        public Node<E> rightChild;
        
        public Node (E element) {
            this (element, null, null);
        }
        
        public Node (E element, Node<E> l, Node<E> r) {
            this.element = element;
            leftChild = l;
            rightChild = r;
        }
        
        public String toString() {
            return element.toString();
        }
    }

    //constructor-builds tree from a postfix exp
    public ExpressionTree(String postfix) {
        root = buildTree(postfix);
    }

    //builds an expression tree from a postfix exp
    private Node<E> buildTree(String postfix) {
        Stack<Node<E>> stack = new Stack<>();
        //split postfix into tokens, split by space
        String[] tokens = postfix.split(" ");  

        for (String token : tokens) {
            //operand
            if (Character.isDigit(token.charAt(0))) {
                stack.push(new Node<>((E) token));
            } 
            //operator
            else {
                Node<E> right = stack.pop();
                Node<E> left = stack.pop();
                stack.push(new Node<>((E) token, left, right));
            }
        }
        return stack.pop(); //final root
    }   

    //returns prefix exp (preorder)
    public String prefix() {
        return prefix(root);
    }

    //preorder: N, L, R
    private String prefix(Node<E> node) {
        if (node == null) return "";
        return node.element + prefix(node.leftChild) + prefix(node.rightChild);
    }

    //returns postfix exp (postorder) 
    public String postfix() {
        return postfix(root);
    }

    //postorder: L, R, N
    private String postfix(Node<E> node) {
        if (node == null) return "";
        return postfix(node.leftChild) + postfix(node.rightChild) + node.element;
    }

    //returns infix exp (inorder)
    public String infix() {
        return infix(root);
    }

    //inorder: L, N, R
    private String infix(Node<E> node) {
        if (node == null) return "";

        //leaf node (operand), just return number
        if (node.leftChild == null && node.rightChild == null) {
            return node.element.toString();
        }

        //put sub-exp in parentheses for order
        return "(" + infix(node.leftChild) 
                + node.element 
                + infix(node.rightChild) + ")";
    }
}