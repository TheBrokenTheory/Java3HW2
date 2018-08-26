//PingPong class. Has a static counter that will initiate the obj with either "Ping" or  "Pong"

package homework2;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Jonathan Anders
 */
public class PingPong implements Runnable {
    private String wordToPrint;
    private static int initCounter = 0;
    private static Lock lock = new ReentrantLock();
    
    //Init the obj with either ping or pong based on the static counter
    public PingPong()
    {
        initCounter++;
        
        switch (initCounter)
        {
            case 1: 
                this.wordToPrint = "Ping";
                break;
            case 2:
                this.wordToPrint = "Pong";
                break;
        }
    }

    //Print the word, then wait for 10 seconds. 
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println(wordToPrint);
            try
            {
                lock.lock();
                Thread.sleep(10000);
                
            } catch (InterruptedException ex){}
            finally
            {
              lock.unlock();
            }             
        }
    }
    
    
    
}
