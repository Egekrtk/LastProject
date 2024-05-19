import java.util.HashMap;
import java.util.LinkedList;

public class Station extends Task{
    private String stationId;
    private int capacity;
    private boolean multiFlag;
    private boolean fifoFlag;
    private Task task;
    private Job job;
    private double speed;
    public static LinkedList<Station> StationTypeList = new LinkedList<>();
    public static LinkedList<Task> stationWithTaskList = new LinkedList<>();
    public static HashMap<String, String> specialTaskForStation = new HashMap<String, String>();


    public Station(){

    }
    public Station(String stationId, int capacity, boolean multiFlag, boolean fifoFlag, double speed) {
        this.stationId = stationId;
        this.capacity = capacity;
        this.multiFlag = multiFlag;
        this.fifoFlag = fifoFlag;
        this.speed = speed;
    }
    public static void createStation(String stationId, int capacity, boolean multiFlag, boolean fifoFlag, double speed,Task task) throws SyntaxError {
        Station newStation = new Station(stationId, capacity, multiFlag, fifoFlag, speed);
        //Task newTask = new Task(task.getId(),task.getSize());
        Task.StationWithTask.add(task);
        stationWithTaskList.add(task);
        specialTaskForStation.remove(0);
        specialTaskForStation.put(newStation.getStationId()," Added "+task.getId()+"-"+task.getSize());
    }


    @Override
    public String toString() {
        return "Station{" +
                "stationId='" + stationId + '\'' +
                ", capacity=" + capacity +
                ", multiFlag=" + multiFlag +
                ", fifoFlag=" + fifoFlag +
                ", speed=" + speed +
                '}';
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isMultiFlag(String bool) {
        if (bool.equals("Y")){
            multiFlag = true;
        } else if (bool.equals("N")) {
            multiFlag = false;
        }else {
            new SyntaxError("this station can not do more task");
        }
        return multiFlag;
    }

    public void setMultiFlag(boolean multiFlag) {
        this.multiFlag = multiFlag;
    }

    public boolean isFifoFlag(String bool) {
        if (bool.equals("Y")){
            multiFlag = true;
        } else if (bool.equals("N")) {
            multiFlag = false;
        }else {
            new SyntaxError("this station can not do more task");
        }
        return fifoFlag;
    }

    public void setFifoFlag(boolean fifoFlag) {
        this.fifoFlag = fifoFlag;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        double max = speed;
        double min = (speed*-1);
        double range = (max - min)+speed ;
        double rand = (double) (Math.random() * range) + min;
        this.speed = rand;
    }
}

