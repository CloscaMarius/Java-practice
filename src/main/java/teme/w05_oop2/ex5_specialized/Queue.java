package teme.w05_oop2.ex5_specialized;

class Queue {

    public void enqueue(String value) {
    }

    public String dequeue() {
        return null;
    }

    public String getFront() {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    //some manual tests
    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println("initial: " + q);
        System.out.println("empty?: " + q.isEmpty());
        System.out.println("front: " + q.getFront());

        System.out.println("dequeue: " + q.dequeue());
        System.out.println("after dequeue: " + q);

        q.enqueue("aa");
        q.enqueue("bb");
        q.enqueue("cc");
        System.out.println("after enqueue [aa,bb,cc]: " + q);
        System.out.println("empty?: " + q.isEmpty());
        System.out.println("front: " + q.getFront());

        System.out.println("dequeue: " + q.dequeue());
        System.out.println("after dequeue: " + q);

        System.out.println("dequeue: " + q.dequeue());
        System.out.println("dequeue: " + q.dequeue());
        System.out.println("empty?: " + q.isEmpty());
    }
}
