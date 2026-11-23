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
        displayTable(processes);
    }
    private void displayTable(List<Process> processes) {
        // Step 7: create private method displayTable with List param
        // Step 8: print the header table
        System.out.printf("%-8s %-10s %-8s %-8s %-8s %-10s %-10s%n",
                "PID", "Arrival", "Burst", "Start", "Finish", "Waiting", "Turnaround");
        // Step 9: Loop each process print it's all values
        for (Process p : processes) {
            System.out.printf("%-8s %-10d %-8d %-8d %-8d %-10d %-10d%n", p.getPid(),
                    p.getArrivalTime(), p.getBurstTime(), p.getStartTime(), p.getFinishTime(),
                    p.getWaitingTime(), p.getTurnaroundTime());
        }
    }
}
