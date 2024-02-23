# ParallelAssigmentTwo

1. Labyrinth
   Before entering the lab, the guests agreed to each only eat one cupcake. That way they will know that all guests have eaten a cupcake when a total of N cupcakes have been eaten.
   They could know how many have been eaten by seeing the number of dirty plates, asking the servant how many he has brought, or by seeing which guests have frosting on their faces (not sure if that last one would break the communication analogy but the other two seem safe.
   In addition to storing the total number of cupcakes eaten, I am also storing a boolean array of size N to implement the logic that a thread will only eat 1 cupcake once and will ask for a cupcake and then eat it if one is not already there. This simulates the guests following this agreed upon strategy.
   I added a wait in order to simulate a pause between the minotaurs calling people and the time it would take to eat a cupcake etc.
   I used a lock to ensure only one guest at a time could enter the labyrinth. I used a reentrant lock.

   This program is one file as labeled and can be run on the command line as typical for java or from an IDE set up for java. Java must be installed on your device either way.
   
2.. Vase
   1. Method 1: Having guests randomly stop by would allow them to have more free time for the guests(threads) to do other things but they would waste time by coming by to check and not finding the room available.
      It would be frustrating to keep looking in and not finding a time, on the other hand, there may be no one visiting for a period of time if no one comes and checks.
   2. Method 2: The sign introduces a quick way for guests to check and still have free time. The same issue of if everyone comes at once there will be a huge crowd at the door exists.
   3. Method 3: I prefer and will implement this idea because it is the most fair and ordered. While the guests will have less freedom, they will choose when to enter the queue and will know exactly when to expect to be let in.

I chose and used the 3rd option with a FIFO queue to keep track of which guests decide to wait to view the vase. Once they are at the top of the queue and called to view the showroom a lock is used to ensure only one at a time can enter the showroom code.
      
