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
        displayAverages(processes);
        displayGanttChart(processes);
    }
    private void displayTable(List<Process> processes) {
        // Step 7: create private method displayTable with List param
        // Step 8: print the header table
        System.out.printf("\n%-8s %-10s %-8s %-8s %-8s %-10s %-10s%n",
                "PID", "Arrival", "Burst", "Start", "Finish", "Waiting", "Turnaround");
        // Step 9: Loop each process print it's all values
        for (Process p : processes) {
            System.out.printf("%-8s %-10d %-8d %-8d %-8d %-10d %-10d%n", p.getPid(),
                    p.getArrivalTime(), p.getBurstTime(), p.getStartTime(), p.getFinishTime(),
                    p.getWaitingTime(), p.getTurnaroundTime());
        }
    }
    private void displayAverages(List<Process> processes) {
        // Step 10: create private method displayAverages with param List Process
        // Step 11: declare two totals before loop (set = 0)
        int sumWaitingTime = 0;
        int sumTurnaroundTime = 0;
        /* Step 11: Loop through processes
        - add p.getWaitingTime to sumWaitingTime
        - add p.getTurnaroundTime to sumTurnaroundTime
         */
        for (Process p : processes) {
            sumWaitingTime += p.getWaitingTime();
            sumTurnaroundTime += p.getTurnaroundTime();
        }
        // Step 12: Compute averages after the loop
        double averageWaitingTime = sumWaitingTime / (double) processes.size();
        double averageTurnaroundTime = sumTurnaroundTime / (double) processes.size();

        // Step 13: Display (print) the average time
        System.out.printf("\nAverage Waiting Time: %.2f seconds%n", averageWaitingTime);
        System.out.printf("Average Turnaround Time: %.2f seconds%n", averageTurnaroundTime);
        System.out.println();
    }
    private void displayGanttChart(List<Process> processes) {
        // Step 14: declare lastFinishedTime var set = 0
        int lastFinishedTime = 0;
        // Step 15: Declare a loop processes for PID, and StartTime
        for (Process p : processes) {
            System.out.printf("| %s ", p.getPid());
        }
        System.out.println("|");
        for (Process p : processes) {
            System.out.printf("%-5d", p.getStartTime());
            lastFinishedTime = p.getFinishTime();
        }
        System.out.printf("%-5d%n", lastFinishedTime);
    }
}
