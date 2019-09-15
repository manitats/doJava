import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TreeWalk {

    public static Node[] nodes = new Node[30];
    static final int NONE = -1;

    public static void main(String[] args) {
        new TreeWalk().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        nodes = new Node[N];
        IntStream.range(0, N).forEach(i -> nodes[i] = new Node());
        IntStream.range(0, N).forEach(i -> {
            int num = sc.nextInt();
            Node node = nodes[num];
            node.number = num;
            node.left = sc.nextInt();
            node.right = sc.nextInt();
            if(node.left != NONE) nodes[node.left].parent = node.number;
            if(node.right != NONE) nodes[node.right].parent = node.number;
        });

        int rootNum = findRoot().number;
        System.out.println("Preorder");
        preParse(rootNum);
        System.out.println("\nInorder");
        inParse(rootNum);
        System.out.println("\nPostorder");
        postParse(rootNum);
        System.out.println("");
    }

    class Node {
        int number, left = NONE, right = NONE , parent = NONE;
    }

    public Node findRoot() {
        return Arrays.stream(nodes)
                .filter(s -> s.parent == NONE)
                .findFirst()
                .orElse(null);
    }

    public void preParse(int number) {
        if(number == NONE) return;
        System.out.print(" " + number);
        preParse(nodes[number].left);
        preParse(nodes[number].right);
    }

    public void inParse(int number) {
        if(number == NONE) return;
        inParse(nodes[number].left);
        System.out.print(" " + number);
        inParse(nodes[number].right);
    }

    public void postParse(int number) {
        if(number == NONE) return;
        postParse(nodes[number].left);
        postParse(nodes[number].right);
        System.out.print(" " + number);
    }
}



