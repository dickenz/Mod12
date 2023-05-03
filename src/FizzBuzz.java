import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzz {
    private int n;
    private BlockingQueue<String> queue;

    public FizzBuzz(int n) {
        this.n = n;
        this.queue = new LinkedBlockingQueue<>();
    }

    public void fizz() throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                queue.add("fizz");
            }
        }
        queue.put("DONE");
    }

    public void buzz() throws InterruptedException {
        for (int i = 5; i <= n; i += 5){
            if(i % 3 != 0) {
                queue.add("buzz");
            }
        }
        queue.put("DONE");
    }

    public void fizzbuzz() throws InterruptedException {
        for (int i = 15; i <= n; i += 15){
                queue.add("fizzbuzz");
        }
        queue.put("DONE");
    }

    public void number() throws InterruptedException {
        for(int i = 1; i <= n; i++) {
            String output;
            if (i % 3 == 0 && i % 5 == 0) {
                output = "fizzbuzz";
            } else if (i % 3 == 0) {
                output = "fizz";
            } else if (i % 5 == 0) {
                output = "buzz";
            } else {
                output = String.valueOf(i);
            }
                System.out.print(output);

            if (i < n) {
                System.out.print(", ");
            }

            if (i == n) {
                System.out.print(".");
            }

            }
        queue.put("DONE");
       }


    public static void main (String[] args) throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadD= new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        threadA.join();
        threadB.join();
        threadC.join();
        threadD.join();

    }
}

