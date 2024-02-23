import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MinotaursVase {

    static int N = 15; // guests or threads at the party
    static int partyInSession = 0; //adjust this to adjust how long the party goes (aka how many times someone gets in the queue)

    static Lock lock = new ReentrantLock(); /// type of lock for threads
    static Queue<Integer> showroomQueue = new LinkedList<>(); // FIFO queue for the showroom


    public static void main(String[] args) throws InterruptedException {

        //time the party to make sure the program ends
        //during the party call random threads (guests) to join the queue
       while(partyInSession <= 30){
            Random random = new Random();
            int i = random.nextInt(N) + 1;
            int threadNumber = i;
            Thread thread = new Thread(() -> enterQ(threadNumber));
            thread.start();
            // delay each thread a random amount to simulate the party
            int rand = random.nextInt(1000) + 1;
            try {
                Thread.sleep(rand);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            partyInSession++;
        }
    }
    private static void enterQ(int threadNumber){

        showroomQueue.add(threadNumber);

        //System.out.println(threadNumber + " joins the Queue");

        //view the vase
        lock.lock();

        //System.out.println(threadNumber + " enters the showroom");
        enterShowroom(showroomQueue.remove());

        lock.unlock();

    }
    private static void enterShowroom(int threadNumber){

        //view the vase thread sleep to simulate time viewing
        try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
