import java.util.HashMap;
import java.util.LinkedList;

public class Job {
    private int time = 0;
    public static int totalTime = 0;
    private String JobTypeId;
    private Task task;
    public static HashMap<String, Integer> JobWithTaskList = new HashMap<String, Integer>();

    public Job(){
    }

    public Job(String jobTypeId,String taskId,int taskSize){
        this.JobTypeId=jobTypeId;
        new Task(taskId, taskSize);
        JobWithTaskList.put(JobTypeId, taskSize);

    }

    public void addJobWithTask(String jobıd,Task task){
        JobWithTaskList.put(jobıd, task.getSize());
    }
    public void calculateTime(Job job,Task task){
        Station station;
        int size = Task.TaskList.get(task.getId());
        int adet = JobWithTaskList.get(job.getJobTypeId());
        int taskDuration= size*adet ;
        if (Task.isInStation(task)){
            String key = task.getId();
            Station.specialTaskForStation.containsKey(key);
            int hizlandir = Integer.parseInt(Station.specialTaskForStation.get(key));
            time += (taskDuration/hizlandir);
            totalTime += time;
            System.out.println("Task finished " + time + "took time");
            System.out.println("Task when finished" + totalTime);
        }else {
            time += taskDuration;
            Task.TaskList.replace(task.getId(), size);
            System.out.println("Task finished " + time + "took time");
            totalTime += time;
            System.out.println("Task when finished" + totalTime);
        }
    }

    public void createJob(String jobTypeId,String taskId,int taskSize){
        Job newJob = new Job(jobTypeId, taskId, taskSize);
        Task newTask = new Task(taskId,taskSize);
        JobWithTaskList.put(newJob.getJobTypeId(), newTask.getSize());
        System.out.println("Tasks added ");
        newJob.addJobWithTask(jobTypeId,newTask);
        newJob.calculateTime(newJob,newTask);
    }

    public void addTask(Task job){
        //LinkedList<Job>jobSpecialTask = new LinkedList<>();
        //jobSpecialTask.addFirst(Job.JobWithTaskList.get(getJobId()));
        LinkedList<String> jobSpecialTask = new LinkedList<>();
        if (job.getId() == null){
            new SyntaxError("Job not found");
        }else {
            String task = "Task ıd :" + job.getId() +" , "+ "Size time : " + job.getSize();
            jobSpecialTask.addFirst(task);
            System.out.println(jobSpecialTask);
        }
    }

    @Override
    public String toString() {
        return "Job{" +
                ", JobTypeId='" + JobTypeId + '\'' +
                ", task=" + task +
                '}';
    }


    public String getJobTypeId() {
        return JobTypeId;
    }

    public void setJobTypeId(String jobTypeId) {
        JobTypeId = jobTypeId;
    }


    public static HashMap<String, Integer> getJobWithTaskList() {
        return JobWithTaskList;
    }

    public static void setJobWithTaskList(HashMap<String, Integer> jobWithTaskList) {
        JobWithTaskList = jobWithTaskList;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }


}
