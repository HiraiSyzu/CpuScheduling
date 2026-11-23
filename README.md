# CPU Scheduling — FCFS

Terminal-based First Come First Serve (FCFS) CPU scheduling simulator in Java.

## Features
- FCFS (non-preemptive) scheduling
- Handles CPU idle gaps
- Per-process start, finish, waiting, turnaround
- Average waiting and turnaround times
- Text Gantt chart
- Two entry points: `Main` (hardcoded) and `MainScanner` (interactive, with input validation)
- Auto-generated PIDs in the Scanner version

## Structure
src/
├── Main.java # hardcoded demo
├── MainScanner.java # interactive input
├── model/Process.java # process data
└── scheduler/FCFS.java # FCFS logic + output

text

## How to Run
Compile:
```bash
javac src/model/Process.java src/scheduler/FCFS.java src/Main.java src/MainScanner.java
Hardcoded demo:

bash
java -cp src Main
Interactive:

bash
java -cp src MainScanner
Sample Output
text
PID      Arrival    Burst    Start    Finish   Waiting    Turnaround
P1       0          5        0        5        0          5
P2       1          3        5        8        4          7
P3       2          8        8        16       6          14

Average Waiting Time: 8.20 seconds
Average Turnaround Time: 13.00 seconds

| P1 | P2 | P3 |
0    5    8    16
Notes
FCFS orders by arrival time, not input order.

Equal arrivals keep input order (stable sort).

Branches
main — stable

proto — development

text

### 🔁 Then
```bash
git add README.md
git commit -m "Add project README"
git push origin proto
Then merge:

bash
git checkout main && git pull origin main && git merge proto && git push origin main && git checkout proto
