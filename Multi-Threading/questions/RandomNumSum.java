import java.util.Random;


class RandomNumberGenerator implements Runnable {
    private int[] numbers;

    public RandomNumberGenerator(int[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        Random rand = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(101);
        }
    }
}


class SumCalculator implements Runnable {
    private int[] numbers;
    private int sum;

    public SumCalculator(int[] numbers) {
        this.numbers = numbers;
        this.sum = 0;
    }

    public void run() {
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        try {
            System.out.print("Numbers : ");
            for(int num : numbers){
                System.out.print(num + "  ");
            }
            System.out.println();
            System.out.println("calculated Sum: " + sum);
            System.out.println();

            Thread.sleep(1000);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getSum() {
        return sum;
    }
}


public class RandomNumSum {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int[] numbers = new int[10];

            RandomNumberGenerator rng = new RandomNumberGenerator(numbers);
            SumCalculator sc = new SumCalculator(numbers);

            Thread t1 = new Thread(rng);
            Thread t2 = new Thread(sc);

            t1.start();
            t1.join();
            t2.start();
            t2.join();
        }
    }
}
