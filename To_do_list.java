import java.util.ArrayList;
import java.util.Scanner;

class SimpleToDoList {

    private static ArrayList<String> toDoList = new ArrayList<>();// I used an ArrayList to store the tasks

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskAsCompleted(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the to-do list application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {// function to show the menu
        System.out.println("\n--- To-Do List Menu ---");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter the task: ");
        String task = scanner.nextLine();
        toDoList.add(task);
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (toDoList.isEmpty()) {
            System.out.println("No tasks in the to-do list.");
        } else {
            System.out.println("\n--- To-Do List ---");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        viewTasks();
        if (!toDoList.isEmpty()) {
            System.out.print("Enter the task number to mark as completed: ");
            int taskNumber;
            try {
                taskNumber = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid task number.");
                scanner.nextLine(); // Consume the invalid input
                return;
            }

            if (isValidTaskNumber(taskNumber)) {
                String completedTask = toDoList.remove(taskNumber - 1);// removes the task which is completed
                System.out.println("Task marked as completed: " + completedTask);
            } else {
                System.out.println("Invalid task number. Please try again.");
            }
        }
    }

    private static boolean isValidTaskNumber(int taskNumber) {
        return taskNumber > 0 && taskNumber <= toDoList.size();
    }
}
