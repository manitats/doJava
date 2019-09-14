import java.util.Arrays;
import java.util.stream.IntStream;

public class RootedTree {
    private static String[] data = {"13",
                             "0 3 1 4 10" ,
                             "1 2 2 3" ,
                             "2 0" ,
                             "3 0" ,
                             "4 3 5 6 7" ,
                             "5 0" ,
                             "6 0" ,
                             "7 2 8 9" ,
                             "8 0" ,
                             "9 0" ,
                             "10 2 11 12" ,
                             "11 0" ,
                             "12 0"};

    public static void main(String[] args) {
        new RootedTree().run();
    }

    private void run() {
        int num = Integer.parseInt(data[0]);
        Node[] nodes = new Node[num];
        IntStream.range(0 , nodes.length).forEach(i -> nodes[i] = new Node());
        IntStream.rangeClosed(1, num).forEach(i -> {
            String[] nodeInfo = data[i].split(" ");
            int number = Integer.parseInt(nodeInfo[0]);
            nodes[i - 1].number = number;
            int childNum = Integer.parseInt(nodeInfo[1]);
            int[] children = new int[childNum];

            IntStream.range(2, childNum + 2).forEach(j -> {
                children[j - 2] = Integer.parseInt(nodeInfo[j]);
                nodes[Integer.parseInt(nodeInfo[j])].parent = number;
            });
            nodes[i - 1].children = children;
         });

        Arrays.stream(nodes).forEach(n -> {
            n.depth = calcDepth(nodes, n.number);
            n.type = getType(n);
        });

        print(nodes);
    }

    class Node{
        private int number, parent, depth;
        private String type;
        private int[] children;

        Node(){
            parent = -1;
        }
    }

    private int calcDepth(Node[] nodes, int number) {
        int d = 0;
        while(nodes[number].parent != -1) {
            number = nodes[number].parent;
            d++;
        }
        return d;
    }

    private String getType(Node node) {
        if(node.parent == -1) {
            return "root";
        }

        if(node.children.length == 0) {
            return "leaf";
        }

        return "internal node";
    }

    private void print(Node[] nodes) {
        for(Node node : nodes) {
            StringBuilder sb = new StringBuilder();
            sb.append("node ").append(node.number).append(": ")
                    .append("parent = ").append(node.parent)
                    .append(", depth = ").append(node.depth)
                    .append(", ").append(node.type)
                    .append(", ").append(Arrays.toString(node.children));

            System.out.println(sb.toString());
        }
    }
}