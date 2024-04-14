package lambda;

public class LambdaMultithreading {
    public static void main(String[] args) {
        // Runnable rn = () -> {
        // for (int i = 0; i < 10; i++) {
        // try {
        // if (i == 6)
        // Thread.yield();
        // System.out.println("MyThread " + i);
        // Thread.sleep(500);
        // } catch (InterruptedException e) {
        // System.out.println(e);
        // }
        // }
        // };

        Runnable destinationSelection = () -> {
            try {
                System.out.println("Selecting Destination");
                Thread.sleep(3000);
                System.out.println("Destination Selected");
            } catch (Exception e) {
                // TODO: handle exception
            }
        };
        Thread t1 = new Thread(destinationSelection);

        Runnable cardPrinting = () -> {
            try {
                t1.join();
                System.out.println("Printing Started");
                Thread.sleep(3000);
                System.out.println("Printing Completed");
            } catch (Exception e) {
                // TODO: handle exception
            }
        };
        Thread t2 = new Thread(cardPrinting);

        Runnable cardDestribution = () -> {
            try {
                t2.join();
                System.out.println("Destribution Started");
                Thread.sleep(3000);
                System.out.println("Destribution Completed");
            } catch (Exception e) {
                // TODO: handle exception
            }
        };

        Thread t3 = new Thread(cardDestribution);
        t1.setDaemon(true);
        t3.start();
        t1.start();
        t2.start();
    }
}
