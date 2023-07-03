public class Task {
    private String title;
    private boolean complete;

    public Task(String title) {
        this.title = title;
        this.complete = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
