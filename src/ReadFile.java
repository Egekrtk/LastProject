import java.io.*;
import java.util.*;
import java.util.List;

public class ReadFile {
    private Task task;
    private static Scanner scanner;
    private static double time = 0.0;
    public HashMap<String, LinkedList<Task>> specialTaskForStation = new HashMap<String, LinkedList<Task>>();
    public HashMap<String, LinkedList<Task>> specialTaskForJob = new HashMap<String, LinkedList<Task>>();

    public ReadFile(String fileName) throws IOException {
        File file = new File("deneme.txt");
        //File jobFile = new File("jobList.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                int lineNumber = line.length();
                String newLine = line.substring(0, lineNumber);
                String LastLine = newLine.replaceAll("[( )]", " ");

                if (LastLine.startsWith(" TASKTYPES")) {
                    LinkedList<String> taskParts = new LinkedList<>(List.of(LastLine.split(" ")));
                    taskParts.remove(0);
                    taskParts.remove(0);
                    for (int i = 0; i <= taskParts.size(); i++) {
                        for (int j = 1; j <= taskParts.size(); j++) {
                            if (j == taskParts.size()) {
                                Task newTask = new Task(taskParts.get(i), 0);
                                newTask.createNewTask(taskParts.get(i), 0);
                                //System.out.println(newTask);
                                i++;
                                j++;
                            } else if (taskParts.get(j).equals("")) {
                                Task newTask = new Task(taskParts.get(i), 0);
                                newTask.createNewTask(taskParts.get(i), 0);
                                //System.out.println(newTask);
                                i++;
                                i++;
                                j++;
                            } else {
                                Task newTask = new Task(taskParts.get(i), Integer.valueOf(taskParts.get(Integer.valueOf(j))));
                                newTask.createNewTask(taskParts.get(i), Integer.valueOf(taskParts.get(Integer.valueOf(j))));
                                //System.out.println(newTask);
                                i++;
                                i++;
                                j++;
                            }
                        }
                    }
                }
                if (LastLine.startsWith(" S")) {
                    if (line.startsWith("(STATIONS")) {
                        continue;
                    }
                    LinkedList<String> stationParts = new LinkedList<>(List.of(LastLine.split(" ")));
                    line += 1;
                    Station newStation = new Station("Default",0,"Default", "Default",0.0);
                    stationParts.remove(0);

                    for (String parts: stationParts) {
                        newStation.setStationId(stationParts.get(0));
                        newStation.setCapacity(Integer.parseInt(stationParts.get(1)));
                        newStation.setMultiFlag(stationParts.get(2));
                        newStation.setFifoFlag(stationParts.get(3));
                        newStation.setSpeed(Double.parseDouble(stationParts.getLast()));
                        Task newTask = new Task("Default");
                        if (parts.contains("T")) {
                            for (Task ifTask : Task.taskTypesList) {
                                if (parts.equals(ifTask.getTaskId())) {
                                    newTask.setTaskId(ifTask.getTaskId());
                                    newTask.setTaskSize(ifTask.getTaskSize());
                                } else {
                                    //System.out.println("Hata verdi");
                                }
                                newTask.setTaskId(String.valueOf(parts));
                                newStation.setTaskId(newTask.getTaskId());
                            }

                        } else if ((parts.equals("0") || parts.equals("1") || parts.equals("2") || parts.equals("3") || parts.equals("4") || parts.equals("5") || parts.equals("6") ||
                                parts.equals("7") || parts.equals("8") || parts.equals("9"))) {
                            newTask.setTaskSize(Integer.parseInt(String.valueOf(parts)));
                            newStation.setSpeed(newTask.getTaskSize() / newStation.getSpeed());
                            //newStation.setTaskSize(newTask.getTaskSize());
                            newStation.setTaskSize(newStation.getTaskSize());//JOB DA Kİ GİBİ TASKSİZE I SPEEDE EŞİTLEDİM
                            //speedi burda ayarlayabilirsin yüzde kısmını galiba ama bilmiyom salla
                        }
                        if (newTask.getTaskId().contains("Default")){
                            continue;
                        }else {
                            newStation.stationWithTaskList.add(newTask);
                        }
                    }
                    Station.stationTypesList.add(newStation);
                    System.out.println("Station ıd: "+newStation.getStationId()+newStation.stationWithTaskList + "Station task making speed :"+ newStation.getSpeed());
                    specialTaskForStation.put(newStation.getStationId(), newStation.stationWithTaskList);
                }

                if (LastLine.startsWith(" J")) {
                    if (line.startsWith("(JOBTYPES")) {
                        continue;
                    }
                    ArrayList<String> jobsParts = new ArrayList<>(List.of(LastLine.split(" ")));
                    line += 1;
                    Job newJob = new Job("Default");
                    jobsParts.remove(0);
                    for (String parts : jobsParts) { //J1 T1 1 T2 T3 3
                        Task newTask = new Task("Default");
                        newJob.setJobId(jobsParts.get(0));
                            if (parts.contains("T")) {
                                for (Task ifTask : Task.taskTypesList) {
                                    if (parts.equals(ifTask.getTaskId())) {
                                        newTask.setTaskId(ifTask.getTaskId());
                                        newTask.setTaskSize(ifTask.getTaskSize());
                                    } else {
                                        //System.out.println("Hata verdi");
                                    }
                                    newTask.setTaskId(String.valueOf(parts));
                                    newJob.setTaskId(newTask.getTaskId());
                                }
                            }
                            else if ((parts.equals("0") || parts.equals("1") || parts.equals("2") || parts.equals("3") || parts.equals("4") || parts.equals("5") || parts.equals("6") ||
                                    parts.equals("7") || parts.equals("8") || parts.equals("9"))) {
                                int a = 0;
                                newTask.setTaskSize(Integer.parseInt(String.valueOf(parts)));
                                newJob.setTaskSize(newTask.getTaskSize() * Integer.valueOf(parts));
                                newJob.setTaskSize(newJob.getTaskSize());
                            }
                        if (newTask.getTaskId().contains("Default")){
                            continue;
                        }else {
                            newJob.jobWithTaskList.add(newTask);
                        }
                    }
                    Job.jobTypeList.add(newJob);
                    if (newJob.getJobId().startsWith("J2")|| !newJob.getJobId().startsWith("Job")){
                        Job.jobTypeList.remove(newJob);
                    }

                    System.out.println("Job ıd: "+newJob.getJobTypeId()+newJob.jobWithTaskList + "Job task making speed :"+ newJob.getTaskSize());
                    specialTaskForJob.put(newJob.getJobTypeId(),newJob.jobWithTaskList);
                }

            }



            System.out.println("------ JOBS-TASKS ----");
            //System.out.println(Job.jobWithTaskList);
            System.out.println("-----TASKS-----");
            System.out.println(Task.taskTypesList);
            System.out.println("-----STATIONS-----");
            System.out.println(Station.stationTypesList);
            System.out.println("-----JOBS PREFERENCES-----");
            System.out.println(Job.jobTypeList);
            System.out.println("statıon özel :");
            System.out.println(specialTaskForStation);
            System.out.println(specialTaskForStation.get("S3"));
        }
        makeEventQueue();
    }
    public static void makeEventQueue() {
        int max = 0;
        int j =-1;
        LinkedList<Job>EventQueue = new LinkedList<>();
        //LinkedList<Integer> timeList = new LinkedList<>();
        for (Job jobTime:Job.jobTypeList){
            int i= jobTime.getStartTime()+ jobTime.getDuration();
            if (i>=max){
                EventQueue.add(jobTime);
                max=i;
                j++;
            }else {
                EventQueue.add(j,jobTime);
;            }
        }
        System.out.println("EVENT QUEUE:"+EventQueue);
    }
}
