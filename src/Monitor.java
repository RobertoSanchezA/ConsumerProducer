

public class Monitor {

    private String buff[] = null;
    private int top = 0;

    private boolean full = false;
    private boolean empty = true;

    public Monitor(int capacity){
        this.buff = new String[capacity];
    }

    public synchronized void put(String vegetable) throws InterruptedException {
        while (full) wait();
        System.out.println("Poniendo el valor en top " + top);
        buff[top] = vegetable ;
        top++;
        empty = false;
        full = top >= buff.length;
        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while (empty) wait();
        String vegetable = buff[--top];
        System.out.println("Obteniendo valor de top " + top);
        full = false;
        empty = top <= 0;
        notifyAll();
        return vegetable;
    }

}
