import java.util.LinkedList;
import java.util.List;

/**
 * Created by fchen on 2/22/2015.
 */
public class BlockingQueue<T> {
    private List<T> list;
    private int capacity;

    public BlockingQueue(int capacity){
        this.capacity = capacity;
        list = new LinkedList<>();
    }

    public synchronized void put(T t){
        while(list.size()>=capacity){
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        list.add(t);
        notifyAll();
    }

    public synchronized T take(){
        while(list.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        T t = list.remove(0);
        notifyAll();
        return t;
    }

    public static void main(String[] args) {
        final BlockingQueue<String> queue = new BlockingQueue<>(1);

        // Test empty queue
/*        {
            Thread producer = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10 * 1000);
                    } catch (InterruptedException e) {
                    }
                    queue.put("SomeStuff");
                }
            });

            Thread consumer = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(queue.take());
                }
            });

            consumer.start();
            producer.start();
        }*/

        // Test queue exceeds capacity
        {
            Thread producer = new Thread(new Runnable() {
                @Override
                public void run() {
                    queue.put("first");
                    queue.put("second");
                    System.out.println("producer finish");
                }
            });

            Thread consumer = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(queue.take());
                    System.out.println(queue.take());
                    System.out.println("consumer finish");
                }
            });

            producer.start();
            consumer.start();
        }
    }
}
