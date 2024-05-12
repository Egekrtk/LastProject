import java.util.ArrayList;
import java.util.Arrays;

public class Task {
    private String taskId;
    private int taskSize;
    public static ArrayList<String> taskTypesList = new ArrayList<>();

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
        Task newTask = new Task(taskName,taskSize); //yeni oluşturdu
        newTask.setTaskId(taskName); //girdiğin isme ayarladı
        String[] tasks = new String[taskSize]; // size ı kadar array için gerekli
        taskTypesList.add(taskName + " "+taskSize) ;//task typelara ekledi

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
    public static ArrayList<String> getTaskList() {
        return taskTypesList;
    }
    public static void setTaskList(ArrayList<String> taskList) {
        Task.taskTypesList = taskList;
    }
}
