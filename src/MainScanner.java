import model.Process;
import scheduler.FCFS;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/* This is for Scanner version, Run this when sir req scanner version
 */
public class MainScanner {
        public static void main(String[] args) {
            List<Process> processes = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            int count = readInt(sc, "How many processes?: \t");
            for (int i = 1; i <= count; i++) {
                System.out.println("\nProcess " + i);
                String pid = "P" + i;

                // arrival and burst time
                int arrival = readInt(sc, "Arrival time: \t");
                int burst = readInt(sc, "Burst time: \t");
                // add pid,arrival, and burst in List
                processes.add(new Process(pid, arrival, burst));
            }
            FCFS fcfs = new FCFS();
            fcfs.schedule(processes);
    }
    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            try {
                // Ask how many processes needed ex. P1
                System.out.print(prompt);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, Please enter a number!");
                sc.nextLine();
            }
        }
    }
}
