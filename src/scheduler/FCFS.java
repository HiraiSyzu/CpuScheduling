package scheduler;
import model.Process;
import java.util.List;
import java.util.Comparator;
public class FCFS {
    public void schedule(List<Process> processes) {
        // Sort List by arrival time
        processes.sort(Comparator.comparingInt(Process::getArrivalTime));
        // Track currentTime
        int currentTime = 0;

        // Loop through each process
        for (Process p : processes) {
            /*
            Step 1: start
            - Compare currentTime with process arrival time
            - take the larger val of two var
            - store it on local var (start)
             */
            int start = Math.max(currentTime, p.getArrivalTime());
            // Step 2: finish - start + burst = store in local var finish
            int finish = start + p.getBurstTime();
            // Step 3: waiting - start - getBurstTime() = store in local var waiting
            int waiting = start - p.getArrivalTime();
            // Step 4: turnaround - finish - getArrivalTime() = store in local var turnaround
            int turnaround = finish - p.getArrivalTime();

            // Step 5: push four values onto process via setters
            p.setStartTime(start);
            p.setFinishTime(finish);
            p.setWaitingTime(waiting);
            p.setTurnaroundTime(turnaround);
            // Step 6: store finish in currentTime
            currentTime = finish;
        }
    }
}
