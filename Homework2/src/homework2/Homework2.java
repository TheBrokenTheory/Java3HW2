//This is the main class. It creates a thread pool of 2 
//and runs an instace of two PingPong classes

package homework2;

import java.util.concurrent.*;


/**
 *
 * @author Jonathan Anders
 */
public class Homework2 {

    public static void main(String[] args) throws InterruptedException
    {
        //Create thread pool of two
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        //Execute new Ping pong objects
        executor.execute(new PingPong());
        executor.execute(new PingPong());

        //Shut down the executor
        executor.shutdown();
    }
    
}
