import java.util.ArrayList;
import java.util.LinkedList;

public class Station extends Task{
    private String stationId;
    private int capacity;// capacity.length yazdırırız görürüz
    private String multiFlag;
    private String fifoFlag;
    public static LinkedList<String> stationTypesList = new LinkedList<>();
    public static LinkedList<String> stationWithTaskList = new LinkedList<>();
    private double speed;

    public Station(){
    }

    public Station(String stationId, int capacity, String multiFlag, String fifoFlag, LinkedList<String> taskList, double speed) {
        super(String.valueOf(taskTypesList=taskList));
        this.stationId = stationId;
        this.capacity = capacity;
        this.multiFlag = multiFlag;
        this.fifoFlag = fifoFlag;
        this.speed = speed;
        stationTypesList.add(stationId);
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId='" + stationId + '\'' +
                ", capacity='" + capacity + '\'' +
                ", multiFlag='" + multiFlag + '\'' +
                ", fifoFlag='" + fifoFlag + '\'' +
                ", speed=" + speed + '\'' +
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

    public String getMultiFlag() {
        return multiFlag;
    }

    public void setMultiFlag(String multiFlag) {
        this.multiFlag = multiFlag;
    }

    public String getFifoFlag() {
        return fifoFlag;
    }

    public void setFifoFlag(String fifoFlag) {
        this.fifoFlag = fifoFlag;
    }

    public static LinkedList<String> getStationTypesList() {
        return stationTypesList;
    }

    public static void setStationTypesList(LinkedList<String> stationTypesList) {
        Station.stationTypesList = stationTypesList;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
