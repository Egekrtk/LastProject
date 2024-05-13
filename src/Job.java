import java.util.LinkedList;
import java.util.Scanner;

public class Job extends  Task{
    private static Scanner scanner;
    // oluşan Taskleri belli joba eklmemiz lazım
    private String jobId;
    private String jobTypeId;
    private int startTime;
    private int duration;
    public static LinkedList<String> jobTypeList = new LinkedList<>();

    public static LinkedList<String> jobWithTaskList = new LinkedList<String>();
    public Job(){
    }
    public Job(String jobId, String jobTypeId, int startTime, int duration) {
        this.jobId = jobId;
        this.jobTypeId = jobTypeId;
        this.startTime = startTime;
        this.duration = duration;
        jobTypeList.add(jobId);
    }

    public Job(String jobId,LinkedList<String>taskList){
        super(String.valueOf(taskTypesList=taskList));
        this.jobId = jobId;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId='" + jobId + '\'' +
                ", jobTypeId='" + jobTypeId + '\'' +
                ", startTime=" + startTime +
                ", duration=" + duration +
                '}';
    }
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTypeId() {
        return jobTypeId;
    }

    public void setJobTypeId(String jobTypeId) {
        this.jobTypeId = jobTypeId;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
