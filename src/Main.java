import java.util.ArrayList;
import java.util.List;
import model.Process;
import scheduler.FCFS;

/* This is for HardCoded version, Run this when sir req hardcoded value version
    Just alter the processes value
 */
public class Main {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        // Test
        processes.add(new Process("P1", 0, 5));
        processes.add(new Process("P2", 1, 3));
        processes.add(new Process("P3", 2, 8));
        processes.add(new Process("P4", 3, 6));
        processes.add(new Process("P5", 4, 2));

        FCFS fcfs = new FCFS(); // Create FCFS object
        fcfs.schedule(processes);
    }
}
