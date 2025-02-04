import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Task class representing a scheduled task
class Task {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    public void execute() {
        System.out.println("[INFO] Executing task: " + name);
    }
}

public class TaskScheduler {
    private static final List<Task> tasks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    
    private static void addTask(String taskName) {
        tasks.add(new Task(taskName));
        System.out.println("[SUCCESS] Task added: " + taskName);
    }
    
    private static void runScheduler() {
        if (tasks.isEmpty()) {
            System.out.println("[WARNING] No tasks to execute.");
            return;
        }
        System.out.println("[INFO] Running Task Scheduler...");
        tasks.forEach(Task::execute);
        tasks.clear();
        System.out.println("[SUCCESS] All tasks executed and cleared.");
    }
    
    public static void main(String[] args) {
        while (true) {
            // Display the menu
            System.out.println("\n1. Add Task");
            System.out.println("2. Schedule (Run Tasks)");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1/2/3): ");
            String input = scanner.nextLine().trim();
            
            switch (input) {
                case "1":
                    // Add task
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine().trim();
                    if (!taskName.isEmpty()) {
                        addTask(taskName);
                    } else {
                        System.out.println("[ERROR] Task name cannot be empty.");
                    }
                    break;
                case "2":
                    // Run scheduler (execute tasks)
                    runScheduler();
                    break;
                case "3":
                    // Exit the program
                    System.out.println("[INFO] Exiting Task Scheduler...");
                    scanner.close();
                    return;
                default:
                    // Handle invalid input
                    System.out.println("[ERROR] Invalid option. Please choose 1, 2, or 3.");
                    break;
            }
        }
    }
}