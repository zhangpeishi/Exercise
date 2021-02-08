import com.sun.corba.se.impl.presentation.rmi.ExceptionHandlerImpl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private Lock lock = new ReentrantLock();
    private Queue<String> queue = new LinkedList<String>();
    private Condition condition = lock.newCondition();

    public void addTask(String s){
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }
    public String getTask() throws InterruptedException{
        lock.lock();
        try {
            while (queue.isEmpty()) {
                 condition.await();

            }
            return queue.remove();

        } finally {
            lock.unlock();
        }
    }

}
