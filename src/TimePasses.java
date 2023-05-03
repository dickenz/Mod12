import java.util.concurrent.TimeUnit;

public class TimePasses {

    public static void main(String[] args) {

        Thread timeThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            while (true) {
                long timeElapsed = System.currentTimeMillis() - startTime;
                System.out.println("Час, що минув: " + TimeUnit.MILLISECONDS.toSeconds(timeElapsed) + " секунд");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread messageThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Запуск потоків
        timeThread.start();
        messageThread.start();
    }
}