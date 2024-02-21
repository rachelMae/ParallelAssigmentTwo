import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MinotaursVase {

    static int N = 15; // guests or threads at the party
    static int partyInSession = 0;

    static Lock lock = new ReentrantLock(); /// type of lock for threads
    static Queue<Integer> showroomQueue = new LinkedList<>(); // FIFO queue for the showroom


    public static void main(String[] args) throws InterruptedException {

       while(partyInSession <= 30){
            Random random = new Random();
            int i = random.nextInt(N) + 1;
            int threadNumber = i;
            Thread thread = new Thread(() -> enterQ(threadNumber));
            thread.start();
            // delay each thread a random amount to simulate the labyrith
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            partyInSession++;
        }
    }
    private static void enterQ(int threadNumber){

        showroomQueue.add(threadNumber);

        //view the vase
        lock.lock();
        enterShowroom(showroomQueue.remove());

        lock.unlock();

    }
    private static void enterShowroom(int threadNumber){

        //view the vase
        //:)
        try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        exitShowroom(threadNumber);

    }
    private static void exitShowroom(int threadNumber){

        //view the vase

    }
    
}
