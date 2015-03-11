import java.util.Stack;

// Start at 12:20, finished at 12:38; start second time (no parent point) 12:44, finished at 1:02
public class FirstCommonAncestor {

    /**
     * http://www.careercup.com/question?id=5163063829331968
     * Given two nodes of a tree,
     * method should return the deepest common ancestor of those nodes.
     *
     *          A
     *         /   \
     *        B      C
     *       /   \    \
     *      D   E      M
     *     / \
     *    G   F
     *
     *  commonAncestor(D, F) = B
     *  commonAncestor(C, G) = A
     */

    //  A,B
    // A, B,D

    Stack<Node> stack = new Stack<>();

    public boolean postOrder(Node node, Node target){
        if (node == null)
            return false;

        if (node == target)
            return true;
        else {
            if (postOrder(node.left, target)){
                stack.push(node);
                return true;
            } else if (postOrder(node.right, target))
            {
                stack.push(node);
                return true;
            } else
            {
                return false;
            }

        }
    }

    public Node commonAncestor(Node nodeOne, Node nodeTwo)
    {
        if (nodeOne == null || nodeTwo == null)
            return null;

        Stack<Node> stackOne = new Stack<>();
        Stack<Node> stackTwo = new Stack<>();
        Node current = nodeOne;
        while(!current.isRoot())
        {
            Node parent = current.parent;
            stackOne.push(parent);
            current = parent;
        }

        current = nodeTwo;
        while(!current.isRoot())
        {
            Node parent = current.parent;
            stackTwo.push(parent);
            current = parent;
        }

        Node common = null;

        while( !(stackOne.isEmpty() || stackTwo.isEmpty()))
        {
            Node ret1 = stackOne.pop();
            Node ret2 = stackTwo.pop();
            if (ret1 == ret2)
            {
                common = ret1;
            } else{
                break;
            }
        }
        return common;
    }

    public static void main(String[] args) {
        FirstCommonAncestor common = new FirstCommonAncestor();

        Node a = new Node();
        a.data = "a";
        Node b = new Node();
        b.data = "b";
        Node c = new Node();
        c.data = "c";
        Node d = new Node();
        d.data = "d";
        Node e = new Node();
        e.data = "e";
        Node f = new Node();
        f.data = "f";
        Node g = new Node();
        g.data = "g";
        Node m = new Node();
        m.data = "m";

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        d.left = g;
        d.right = f;

        c.left = m;

        common.postOrder(a,m);


        while (!common.stack.isEmpty()){
            System.out.println(common.stack.pop().data);
        }

    }
}

class Node {

     Node parent;
     Node left;
     Node right;
     String data;

    public Node(){

    }

    public Node(Node parent, Node left, Node right, String data) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.data = data;
    }

    boolean isRoot() {
        return parent == null;
    }
}