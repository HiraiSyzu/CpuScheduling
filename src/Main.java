import java.util.ArrayList;
import java.util.List;
import model.Process;
import scheduler.FCFS;

public class Main {
    static void main() {
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
