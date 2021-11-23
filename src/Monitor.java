

public class Monitor {
    private final String[] buff;
    private int top = 0;

    private boolean full = false;
    private boolean empty = true;

    public Monitor(int capacity){
        this.buff = new String[capacity];
    }

    public synchronized void put(String vegetable) throws InterruptedException {
        while (full){
            wait();
        }
        buff[top] = vegetable;
        top++;
        empty = false;
        full = top >= buff.length;
        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while (empty) {
            wait();
        }
        top--;
        String vegetable = buff[top];
        full = false;
        empty = top <= 0;
        notifyAll();
        return vegetable;
    }
}
