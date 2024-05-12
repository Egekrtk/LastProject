import java.util.ArrayList;

public class Station extends Task{
    private String stationId;
    private String capacity;// capacity.length yazdırırız görürüz
    private String multiFlag;
    private String fifoFlag;
    public static ArrayList<String> stationTypesList = new ArrayList<>();
    private String speed;

    public Station(){
    }

    public Station(String stationId, String capacity, String multiFlag, String fifoFlag, ArrayList<String> taskList,String speed) {
        super(String.valueOf(taskTypesList=taskList));
        this.stationId = stationId;
        this.capacity = capacity;
        this.multiFlag = multiFlag;
        this.fifoFlag = fifoFlag;
        this.speed = speed;
    }

    public static void createNewStation(String newStationId, String newCapacity, String newMultiflag, String newFifoflag, ArrayList<String> newTaskList, String newSpeed){
        Station newStation = new Station(newStationId, newCapacity,newMultiflag,newFifoflag , newTaskList,newSpeed);
        newStation.setStationId(newStationId);
        stationTypesList.add(newStationId +" ");
        newStation.toString();
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId='" + stationId + '\'' +
                ", capacity='" + capacity + '\'' +
                ", multiFlag='" + multiFlag + '\'' +
                ", fifoFlag='" + fifoFlag + '\'' +
                ", speed=" + speed + '\'' +
                ", Tasks=" + taskTypesList +
                '}';
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
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

    public static ArrayList<String> getStationTypesList() {
        return stationTypesList;
    }

    public static void setStationTypesList(ArrayList<String> stationTypesList) {
        Station.stationTypesList = stationTypesList;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
