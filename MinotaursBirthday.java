import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MinotaursBirthday {

    static int N = 15; // guests or threads at the party

    private static boolean[] cupcakesEaten = new boolean[N];
    static int cupcakesServed = 0;

    static Lock lock = new ReentrantLock(); /// type of lock for threads
    private static boolean cupcake = true;

    public static void main(String[] args) {

        // define and start the threads randomly bwteen 1 and N
        while(cupcakesServed < 15){
            Random random = new Random();
            int i = random.nextInt(N) + 1;
            int threadNumber = i;
            Thread thread = new Thread(() -> enterLab(threadNumber));
            thread.start();
            // delay each thread a random amount to simulate the labyrith
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        //announce that all guests have entered the labyrinth
        System.out.println("All Guests have entered the Labyrinth!!!");

    }

    public static void enterLab(int threadNumber) {

        
        lock.lock(); // only one at a time

       // System.out.println("thread" + threadNumber + "entering");

        try {
            //if you have not eaten a cupcake yet and there is one there
            if (cupcake && (cupcakesEaten[threadNumber-1] == false)) {

                // eat the cupcake //cupcake = false;
                eatCupcake(threadNumber);
                cupcake = false;
                
            } else {
                // request cupcake
                cupcake = true;

                //if you have not already eaten a cupcake
                if(cupcakesEaten[threadNumber-1] == false){

                    // eat cupcake
                    eatCupcake(threadNumber);
                    cupcake = false;
                }
                else{
                    // don't eat cupcake
                }
            }
        } finally {

            lock.unlock();
            //System.out.println("thread" + threadNumber + "exiting");

        }
    }
    public static void eatCupcake(int threadNumber) {
        cupcakesEaten[threadNumber-1] = true; //guest notes that they have now eaten a cupcake
        cupcakesServed++; //the number of cupcakes the servant has brought increases by 1
    }
}
