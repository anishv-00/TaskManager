import java.util.ArrayList;
import java.util.Scanner;

public class MyConsole {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner input = new Scanner(System.in);

        while (true) {

          System.out.println("Welcome to the Task Manager! Open for Parents or Children!");
          System.out.println("0: Child");
          System.out.println("1: Parent");
          System.out.println("2: Exit");

          int option = input.nextInt();
          input.nextLine();

            if (option == 0) {
                System.out.println("0: View All Tasks");
                System.out.println("1: Mark A Task Complete");
                System.out.println("2: View All Completed and Incomplete Tasks");
                System.out.println("3: Exit");
              
                int child_option = input.nextInt();
                input.nextLine();
                ArrayList<Task> childTasks = toDoList.getTasks();

                if (child_option == 0) {
                    System.out.println("Your tasks:");
                    if (childTasks.isEmpty()) {
                        System.out.println("You don't have any tasks yet.");
                    } 
                    else {
                        for (Task task : childTasks) {
                            System.out.println(task.getTitle());
                        }
                    }
                } 
                else if (child_option == 1) {
                    System.out.println("Your tasks:");
                    if (childTasks.isEmpty()) {
                        System.out.println("You don't have any tasks yet.");
                    } 
                    else {
                        System.out.println("Enter the index of the task you want to set as complete:");
                        int taskIndex = input.nextInt();
                        input.nextLine();
                        if (taskIndex >= 0 && taskIndex < childTasks.size()) {
                            Task taskToComplete = childTasks.get(taskIndex);
                            taskToComplete.setComplete(true);
                            System.out.println("Task marked as complete: " + taskToComplete.getTitle());
                        } 
                        else {
                            System.out.println("Invalid task index.");
                        }
                    }
                }

                if(child_option == 2){
                  if (childTasks.isEmpty()) {
                        System.out.println("You don't have any tasks yet.");
                    }
                  else {
                    for (Task task : childTasks) {
                            if(task.isComplete() == true){
                              System.out.println(task.getTitle() + " -> Complete");
                            }
                            if(task.isComplete() == false){
                              System.out.println(task.getTitle() + " -> Incomplete");
                            }
                           
                      }
                  }
                }
                
                if (child_option == 3) {
                    System.out.println("Have a nice day.");
                    break;
                }
            } 
            
            else if (option == 1) {
                System.out.println("0: See Tasks");
                System.out.println("1: Add Tasks ");
                System.out.println("2: Remove Tasks");
                System.out.println("3: Exit");

                int parent_option = input.nextInt();
                input.nextLine();

                if (parent_option == 0) {
                    ArrayList<Task> allTasks = toDoList.getTasks();
                    System.out.println("All tasks:");
                    if (allTasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        for (Task task : allTasks) {
                            System.out.println(task.getTitle());
                        }
                    }
                } 
                else if (parent_option == 1) {
                    System.out.println("Enter the title of the new task:");
                    String taskTitle = input.nextLine();
                    Task task = new Task(taskTitle);
                    toDoList.addTask(task);
                    System.out.println("Task added: " + taskTitle);
                  
                } 
                else if (parent_option == 2) {
                    System.out.println("Enter the index of the task that you want to remove:");
                    int parent_remove = input.nextInt();
                    input.nextLine();
                    ArrayList<Task> allTasks = toDoList.getTasks();
                    if (parent_remove < allTasks.size()) {
                        Task taskToRemove = allTasks.get(parent_remove);
                        toDoList.removeTask(taskToRemove);
                        System.out.println("Task removed: " + taskToRemove.getTitle());
                    } else {
                        System.out.println("Invalid task index.");
                    }
                } 
            } 
            else {
                System.out.println("Have a nice day.");
                break;
            }
        }
    }
}
