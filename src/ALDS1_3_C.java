import java.util.Scanner;

public class ALDS1_3_C {
    public static void main(String[] args) {
        class DoublyLinkedListImpl implements DoublyLinkedList{
            private Integer[] array;
            private int prev;
            private int next;
            private final int MAX;
            public DoublyLinkedListImpl(Integer max) {
                this.MAX = max;
                this.array = new Integer[max];
            }

            public void insert(Integer obj) {
                array[next] = obj;
                next++;
            }
            public void delete(Integer obj) {
                for(int i = 0; i < array.length; i++) {
                    if (array[i] != null && array[i].equals(obj)) {
                        array[i] = null;
                        return;
                    }
                }
            }
            public void deleteFirst() {
                array[prev] = null;
                prev++;
            }
            public void deleteLast() {
                array[next] = null;
                next--;
            }

            public void print() {
                boolean isFirst = true;
                for (Integer val : array) {
                    if (val == null) {
                        continue;
                    }

                    if (isFirst) {
                        System.out.print(val);
                        isFirst = false;
                    } else {
                        System.out.print(" " + val);
                    }
                }
            }
        }

        DoublyLinkedList list = new DoublyLinkedListImpl(20);
        int num = new Scanner(System.in).nextInt();

        for (int i = 0; i < num; i++) {
            String line = new Scanner(System.in).nextLine();
            String cmd = line.split(" ")[0];
            int value = Integer.parseInt(line.split(" ")[1]);
            switch (cmd) {
                case "insert":
                    list.insert(value);
                    break;
                case "delete":
                    list.delete(value);
                    break;
                case "deleteFirst":
                    list.deleteFirst();
                    break;
                case "deleteLast":
                    list.deleteLast();
                    break;
                default:
                    break;
            }
        }

        list.print();
    }

    public interface DoublyLinkedList {
        void insert(Integer obj);
        void delete(Integer obj);
        void deleteFirst();
        void deleteLast();
        void print();
    }



}
