import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Task {
    private String taskId;
    private int taskSize;
    public static LinkedList<Task> taskTypesList =  new LinkedList<>();
    public static LinkedList<Task> StationWithTask = new LinkedList<>();
    public static HashMap<String, LinkedList<Station>> StringtoStationTask = new HashMap<String, LinkedList<Station>>();

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
        ArrayList<String> tasks = new ArrayList<>(); // size ı kadar array için gerekli !!
        taskTypesList.add(newTask) ;
        for (int i = 0;i<taskSize;i++){
            tasks.add(taskName) ;
        }
        //newTask.toString();
        //System.out.println("içindeki taskler= "+ tasks);
    }

    public boolean isDefault(String taskId){
        if (taskId.contains("[taskId='Default',")){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return
                "taskId='" + taskId + '\'' +
                ", taskSize=" + taskSize +
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
    public static LinkedList<Task> getTaskList() {
        return taskTypesList;
    }
    public static void setTaskList(LinkedList<Task> taskList) {
        Task.taskTypesList = taskList;
    }
}
