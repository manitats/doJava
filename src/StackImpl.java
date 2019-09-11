public class StackImpl {
    public static void main(String[] args) {
        calc(input);
    }

    static void calc(String po) {
        Stack stack = new Stack();
        String[] elems = po.split(" ");
        for (String elem : elems) {
            try {
                int num = Integer.parseInt(elem);
                stack.push(num);
            } catch (NumberFormatException e) {
                int second = stack.pop();
                int first = stack.pop();
                switch (elem) {
                    case "+":
                        stack.push(first + second);
                        break;
                    case "-":
                        stack.push(first - second);
                        break;
                    case "*":
                        stack.push(first * second);
                        break;
                    case "/":
                        stack.push(first / second);
                        break;

                }
            }
        }
        System.out.println("result: " + stack.pop());
    }

    private static final String input = "3 4 + 2 3 - *";

    public static class Stack {
        int[] stack;
        int top;
        int max;

        Stack() {
            this(10);
        }

        Stack(int max) {
            this.stack = new int[max];
            this.max= max;
            this.top = 0;
        }

        void push(int x) {
            if (isFull()) {

            }
            stack[top] = x;
            top++;
        }

        int pop() {
            if(isEmpty()) {

            }
            top--;
            return stack[top];
        }

        boolean isEmpty() {
            return top == 0;
        }

        boolean isFull() {
            return top == max;
        }
    }
}
