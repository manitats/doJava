import java.util.Scanner;
import java.util.stream.IntStream;

public class BinarySearchTree {
    static Node root;

    public static void main(String[] args) {
        new BinarySearchTree().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        IntStream.range(0, N).forEach(i -> {
            String cmd = sc.next();
            if (cmd.equals("insert")) {
                int id = sc.nextInt();
                insert(new Node(id));
            } else if(cmd.equals("find")) {
                int id = sc.nextInt();
                System.out.println(find(root, id) != null ? "yes": "no");
            } else if(cmd.equals("delete")) {
                int id = sc.nextInt();
                delete(find(root, id));
            } else if(cmd.equals("print")) {
                print();
            }
        });
    }


    class Node {
        int id;
        Node parent = null, left = null, right = null;

        Node(int id) {
            this.id = id;
        }
    }

    private void delete(Node node) {
        Node del;
        Node delChild;

        //case1,2 or case3
        if (node.left == null || node.right == null) {
            del = node;
        } else {
            del = getSuccessor(node);
        }

        if (del.left != null) {
            delChild = del.left;
        } else {
            delChild = del.right;
        }

        if (delChild != null) {
            delChild.parent = del.parent;
        }

        if (del.parent == null) {
            root = delChild;
        } else {
            if (del == del.parent.left) {
                del.parent.left = delChild;
            } else {
                del.parent.right = delChild;
            }
        }

        //for case3
        if (del != node) {
            node.id = del.id;
        }
    }

    private Node getSuccessor(Node node) {
        if(node.right != null) return treeMinimum(node.right);
        Node s = node.parent;
        while (s != null && s.right == node) {
            node = s;
            s = s.parent;
        }
        return s;
    }

    private Node treeMinimum(Node node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node find(Node node, int id) {
        while(node != null && id != node.id) {
            if(id < node.id) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    private void insert(Node node) {
        Node parent = null;
        Node position = root;

        while(position != null) {
            parent = position;
            if(node.id < position.id) {
                position = position.left;
            } else {
                position = position.right;
            }
        }

        node.parent = parent;

        if (parent == null) {
            root = node;
        } else {
           if(node.id < parent.id) {
               parent.left = node;
           } else {
               parent.right = node;
           }
        }
    }

    private void print() {
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(" "  + node.id);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(" " + node.id);
        inOrder(node.right);
    }
}
