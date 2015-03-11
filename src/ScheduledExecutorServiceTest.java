import java.util.Date;
import java.util.concurrent.*;

/**  Linkedin Interview Question
 * A server receives requests from different clients...each client send a Runnable job and time on which this job should be run.
 * Write a java program that would accept these jobs and run each job at the required time.
 * Hint: the solution should have a job priority queue to hold the jobs and it should be multithreaded.
 * One thread should accept the tasks, the other one should run the jobs. Also conditions and signalling will be used
 */

public class ScheduledExecutorServiceTest {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void execute(Job[] jobs){
        for(Job job:jobs){
            scheduler.schedule(job.getR(),job.getDate().getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public void shutdown(long milli){
        try {
            Thread.sleep(milli);
            scheduler.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Job{
    private String Id;
    private Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("Thread: "+Id+", "+date);
        }
    };

    private Date date;

    public Job(String id, Date date){
        this.Id = id;
        this.date = date;
    }

    public Runnable getR(){
        return r;
    }

    public Date getDate(){
        return date;
    }
}