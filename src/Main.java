public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor(9);

        Producer p = new Producer(monitor, 5, 1000);
        Consumer c = new Consumer(monitor, 5, 1000);
        p.start();
        c.start();

    }
}
