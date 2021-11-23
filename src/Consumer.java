public class Consumer extends Thread{

    private Monitor buffer;
    private int expectedUnits;
    private int maxWaitTime;

    public Consumer(Monitor buffer, int expectedUnits, int maxWaitTime) {
        this.buffer = buffer;
        this.expectedUnits = expectedUnits;
        this.maxWaitTime = maxWaitTime;
    }

    @Override
    public void run() {
        String vegetable;
        try{
            for (int i = 0; i < expectedUnits; i++) {
                vegetable = buffer.get();
                System.out.println("Consumed: " + vegetable);
                sleep((int) (Math.random() * maxWaitTime));
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
