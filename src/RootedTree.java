import java.util.stream.IntStream;

public class RootedTree {
    private static final int BIG_NUM  = 2000000000;
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
        class Node implements  NodeInterface{
            private int number, parent, depth;
            private int[] children;

            Node(int number){
                this.number = number;
                parent = -1;
            }

            public int getNumber() {
                return number;
            }

            public int getParent() {
                return parent;
            }

            public void setParent(int parent) {
                this.parent = parent;
            }

            public int getDepth() {
                return depth;
            }

            public void setDepth(int depth) {
                this.depth = depth;
            }

            public int[] getChildren() {
                return children;
            }

            public void setChildren(int[] children) {
                this.children = children;
            }
        }

        int num = Integer.parseInt(data[0]);
        Node[] nodes = new Node[num];
        IntStream.rangeClosed(1, num).forEach(i -> {
            String[] nodeInfo = data[i].split(" ");
            int number = Integer.parseInt(nodeInfo[0]);
            nodes[i - 1] = new Node(number);
            int childNum = Integer.parseInt(nodeInfo[1]);
            int[] children = new int[childNum];

            IntStream.range(2, childNum + 2).forEach(j -> {
                children[j - 2] = Integer.parseInt(nodeInfo[j]);
                nodes[Integer.parseInt(nodeInfo[j])].setParent(number);
            });

            nodes[i - 1].setChildren(children);
        });
    }

    //TODO: To use Node class from static method other than main method
    interface NodeInterface {
        int[] getChildren();
    }

    static int calcDepth() {
        //TODO: caluculate depth
        return -1;
    }
}