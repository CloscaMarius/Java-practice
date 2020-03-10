package teme.w05_oop2.ex5_specialized;

class Stack {

    public void push(String value) {
    }

    public String pop() {
        return null;
    }

    public String peek() {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    //some manual tests
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("empty?: " + stack.isEmpty());

        stack.push("aa");
        stack.push("bb");
        System.out.println("after push 'aa','bb': empty?: " + stack.isEmpty());

        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("empty?: " + stack.isEmpty());

        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
    }
}
