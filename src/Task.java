import java.util.HashMap;
import java.util.LinkedList;

public class Task {
    private String ıd;
    private int size;

    public static HashMap<String,Integer>TaskList = new HashMap<>();
    public static LinkedList<Task>JobspecilTask = new LinkedList<>();
    public static LinkedList<Task>TasksList = new LinkedList<>();
    public static LinkedList<Task> StationWithTask = new LinkedList<>();

    public Task(String ıd,int size){
        this.ıd = ıd;
        this.size = size;

        TaskList.put(ıd, size);
    }
    public Task(){
    }
    public static boolean isInStation(Task task){
        boolean b ;
        String key = task.getId();
        if (Station.specialTaskForStation.containsKey(key)){
            int value = Integer.parseInt(Station.specialTaskForStation.get(key));
            b = true;
        } else {
            b = false;
        }
        return b;
    }
    public static void addList(Task task){
        task = new Task();
        TasksList.add(task);
    }



    public String getId() {
        return ıd;
    }

    public void setId(String ıd) {
        this.ıd = ıd;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public HashMap<String, Integer> getTaskList() {
        return TaskList;
    }

    public void setTaskList(HashMap<String, Integer> taskList) {
        TaskList = taskList;
    }
}
