import java.util.LinkedList;

public class JobPreferences {
    private String JobId;
    private String JobTypeId;


    private int starTime;
    private int endTime;
    private int totalTime;
    public static LinkedList<JobPreferences> JobTypeList = new LinkedList<>();

    public JobPreferences(String jobId,String jobTypeId,int starTime,int endTime){ //Job File için
        this.JobId=jobId;
        this.JobTypeId=jobTypeId;
        this.starTime=starTime;
        this.endTime=endTime;

    }

    @Override
    public String toString() {
        return "JobPreferences{" +
                "JobId='" + JobId + '\'' +
                ", JobTypeId='" + JobTypeId + '\'' +
                ", starTime=" + starTime +
                ", endTime=" + endTime +
                '}';
    }

    public static void JobPreferenceList(String jobId, String jobTypeId, int starTime, int endTime){
        JobPreferences newJob = new JobPreferences(jobId, jobTypeId, starTime, endTime);
        JobTypeList.add(newJob);
        newJob.toString();
    }

    public JobPreferences(){

    }
    public String getJobTypeId() {
        return JobTypeId;
    }

    public void setJobTypeId(String jobTypeId) {
        JobTypeId = jobTypeId;
    }

    public static LinkedList<JobPreferences> getJobTypeList() {
        return JobTypeList;
    }

    public static void setJobTypeList(LinkedList<JobPreferences> jobTypeList) {
        JobTypeList = jobTypeList;
    }


    public String getJobId() {
        return JobId;
    }

    public void setJobId(String jobId) {
        JobId = jobId;
    }

    public int getStarTime() {
        return starTime;
    }

    public void setStarTime(int starTime) {
        this.starTime = starTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }
}
