import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Task> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void completeTask(Task task) {
        task.setComplete(true);
    }

    public ArrayList<Task> getTasksForChild() {
        ArrayList<Task> childTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isComplete()) {
                childTasks.add(task);
            }
        }
        return childTasks;
    }
}
