import java.util.stream.IntStream;

public class BinaryTree {
    private static final String[] data = {
            "9",
        "0 1 4",
        "1 2 3",
        "2 -1 -1",
        "3 -1 -1",
        "4 5 8",
        "5 6 7",
        "6 -1 -1",
        "7 -1 -1",
        "8 -1 -1"
    };

    private static final int NONE = -1;

    public static void main(String[] args) {
        new BinaryTree().run();
    }

    private void run() {
        int N = Integer.parseInt(data[0]);
        Node[] nodes = new Node[N];
        IntStream.range(0, N).forEach(i -> nodes[i] = new Node());
        IntStream.range(0, N).forEach(i -> {
            String[] nodeInfo = data[i + 1].split(" ");
            //should Node n = nodes[i] ?
            nodes[i].id = Integer.parseInt(nodeInfo[0]);
            nodes[i].left = Integer.parseInt(nodeInfo[1]);
            nodes[i].right = Integer.parseInt(nodeInfo[2]);
            if(nodes[i].left != -1) nodes[nodes[i].left].parent = nodes[i].id;
            if(nodes[i].right != -1) nodes[nodes[i].right].parent = nodes[i].id;
        });

        //looks redundant...
        IntStream.range(0, N).forEach(i -> {
            nodes[i].height = calcHeight(nodes, nodes[i].id);
            nodes[i].depth = calcDepth(nodes, nodes[i].id);
            nodes[i].sibling = getSibling(nodes, nodes[i].id);
            nodes[i].type = getType(nodes, nodes[i].id);
            print(nodes[i]);
        });
    }

    class Node{
        private int id, parent = NONE, sibling = NONE
                , left = NONE, right = NONE, depth, height;
        private Type type;
    }


    enum Type{
        ROOT("root"),
        INTERNAL("internal node"),
        LEAF("leaf");

        private final String type;

        Type(String type) {
            this.type = type;
        }

        private String getType() {
            return this.type;
        }
    }

    private int calcHeight(Node[] nodes, int id) {
        int h1 = 0, h2 = 0;
        if (nodes[id].left != NONE) {
            h1 = calcHeight(nodes, nodes[id].left) + 1;
        }
        if (nodes[id].right != NONE) {
            h2 = calcHeight(nodes, nodes[id].right) + 1;
        }

        return Math.max(h1, h2);
    }

    private int calcDepth(Node[] nodes, int id) {
        int d = 0;
        Node node = nodes[id];
        while(node.parent != -1) {
            node = nodes[node.parent];
            d++;
        }
        return d;
    }

    private int calcDegree(Node node) {
        int d = 0;
        if(node.left != NONE) d++;
        if(node.right != NONE) d++;
        return d;
    }

    private int getSibling(Node[] nodes, int id) {
        if (nodes[id].parent != NONE) {
            Node parent = nodes[nodes[id].parent];
            int left = parent.left;
            int right = parent.right;
            if (left == id) {
                return right;
            } else if (right == id) {
                return left;
            }
        }

        return NONE;
    }

    private Type getType(Node[] nodes, int id) {
        Node node = nodes[id];
        if(node.parent == NONE) return Type.ROOT;
        if(node.left == NONE && node.right == NONE) return Type.LEAF;
        return Type.INTERNAL;
    }

    private void print(Node node) {
        String out = new StringBuilder()
                .append("node ").append(node.id)
                .append(": parent = ").append(node.parent)
                .append(", sibling = ").append(node.sibling)
                .append(", degree = ").append(calcDegree(node))
                .append(", depth = ").append(node.depth)
                .append(", height = ").append(node.height)
                .append(", ").append(node.type.getType())
                .toString();
        System.out.println(out);
    }
}
