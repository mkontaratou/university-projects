public class Task {
    private int taskId;
    private int taskTime;

    public Task(int taskId,int taskTime){
        this.taskId=taskId;
        this.taskTime=taskTime;
    }
    public int getTaskId() {
        return taskId;
    }

    public int getTaskTime() {
        return taskTime;
    }
}
