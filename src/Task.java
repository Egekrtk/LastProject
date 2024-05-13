import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Task {
    private String taskId;
    private int taskSize;
    public static LinkedList<String> taskTypesList =  new LinkedList<>();

    public Task(){
    }

    public Task(String taskId){
    this.taskId = taskId;
    }

    public Task(String taskId, int taskSize){
        this.taskId = taskId;
        this.taskSize = taskSize;
    }

    public static void createNewTask(String taskName, int taskSize){
        Task newTask = new Task(taskName,taskSize);
        newTask.setTaskId(taskName);
        String[] tasks = new String[taskSize]; // size ı kadar array için gerekli !!
        taskTypesList.add(taskName + " "+taskSize) ;
        System.out.println("Yeni task oluşturuldu");
        newTask.toString();
        for (int i = 0;i<taskSize;i++){
            tasks[i] = taskName ;
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", taskSize=" + taskSize +
                ", taskTypes=" + taskTypesList +
                '}';
    }

    public String getTaskId() {
        return taskId;
    }
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    public int getTaskSize() {
        return taskSize;
    }
    public void setTaskSize(int taskSize) {
        this.taskSize = taskSize;
    }
    public static LinkedList<String> getTaskList() {
        return taskTypesList;
    }
    public static void setTaskList(LinkedList<String> taskList) {
        Task.taskTypesList = taskList;
    }
}
