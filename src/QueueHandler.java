import java.util.Arrays;
import java.util.Scanner;

public class QueueHandler {

    public static void main(String[] args) {
        class Proc {
            private String name;
            private int time;

            public Proc(String name, int time) {
                this.name = name;
                this.time = time;
            }

            public String getName() {
                return name;
            }

            public int getTime() {
                return time;
            }
        }

        class Queue {
            private int head = 0, tail = 0;
            private int MAX;
            private Proc[] queue;

            public Queue() {
                this(20);
            }

            public Queue(int max) {
                MAX = max;
                queue = new Proc[max];
            }

            public void enqueue(Proc obj) {
                queue[tail] = obj;
                if (tail + 1 >= MAX) {
                    tail = 0;
                } else {
                    tail++;
                }
            }

            public Proc dequeue() {
                int tmp = head;
                if (head + 1 >= MAX) {
                    head = 0;
                } else {
                    head++;
                }
                return queue[tmp];
            }

            public Proc[] calc(int num, int q) {
                Proc[] order = new Proc[num];
                int timer = 0;
                int cnt = 0;
                while (head != tail) {
                    Proc proc = dequeue();
                    if (q >= proc.time) {
                        timer += proc.time;
                        order[cnt] = new Proc(proc.name, timer);
                        cnt++;
                    } else {
                        enqueue(new Proc(proc.name, (proc.time - q)));
                        timer += q;
                    }
                }

                return order;
            }
        }

//        args = new String[] {"5 100", "p1 150", "p2 80", "p3 80", "p4 29", "p5 101"};
//        int num = Integer.parseInt(args[0].split(" ")[0]);
//        int q = Integer.parseInt(args[0].split(" ")[1]);
        String[] line = new Scanner(System.in).nextLine().split(" ");
        int num = Integer.parseInt(line[0]);
        int q = Integer.parseInt(line[1]);

        Queue queue = new Queue(num * 2);

        for (int i = 1; i <= num; i++) {
            //String[] proc = args[i].split(" ");
            String[] proc = new Scanner(System.in).nextLine().split(" ");
            queue.enqueue(new Proc(proc[0]
                    , Integer.parseInt(proc[1])));
        }

        Proc[] result = queue.calc(num, q);
        Arrays.stream(result)
                .forEach(s -> System.out.println(
                        s.getName() + " " + s.getTime()));
    }
}
