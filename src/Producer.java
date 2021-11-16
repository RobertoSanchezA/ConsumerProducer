
import java.util.Arrays;

public class Producer extends Thread{
    private Monitor buffer;
    private int producedUnits;
    private int madurationTime;

    private final String vegetables [] = {
            "lettuce",
            "cabbage",
            "onion",
            "spinach",
            "potato",
            "celery",
            "asparagus",
            "radish",
            "broccoli",
            "artichoke",
            "tomato",
            "cucumber",
            "eggplant",
            "carrot",
            "green bean"
    };

    public Producer(Monitor buffer, int producedUnits, int madurationTime) {
        this.buffer = buffer;
        this.producedUnits = producedUnits;
        this.madurationTime = madurationTime;
    }

    public String selectRandomVegetable() {
        int randomVegetablePosition = (int)(Math.random() * vegetables.length);
        return vegetables[randomVegetablePosition].toString();

    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < producedUnits; i++) {
                buffer.put(selectRandomVegetable());
                System.out.println("Produced => " + vegetables[i]);
                sleep((int) (Math.random() * this.madurationTime));
            }

        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}


