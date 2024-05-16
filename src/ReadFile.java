import java.io.*;
import java.util.*;

public class ReadFile {
    private Task task;
    private static Scanner scanner;
    private static double time = 0.0;

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

                if (LastLine.startsWith(" J")) {
                    if (line.startsWith("(JOBTYPES")) {
                        continue;
                    }
                    ArrayList<String> jobsParts = new ArrayList<>(List.of(LastLine.split(" ")));
                    line += 1;
                    Job newJob = new Job("Default", Task.taskTypesList);
                    LinkedList<String> specialJob = new LinkedList<>();
                    jobsParts.remove(0);
                    for (String parts : jobsParts) {
                        if (parts.startsWith("J")) {
                            newJob.setJobId(parts);
                        } else if (parts.startsWith("T")) {
                            specialJob.add(parts);
                        } else {
                            specialJob.add(parts);
                        }
                    }
                    for (String taskler : specialJob) {
                        //System.out.println("Id si:" + newJob.getJobId() + " --" + "Taskleri :" + specialJob);
                    }
                    Job.jobWithTaskList.add(newJob.getJobId() + specialJob);
                }


                if (LastLine.startsWith(" S")) {
                    if (line.startsWith("(STATIONS")) {
                        continue;
                    }
                    LinkedList<String> stationParts = new LinkedList<>(List.of(LastLine.split(" ")));
                    line += 1;
                    Station newStation = new Station("Default",0,"Default", "Default",0.0);
                    stationParts.remove(0);

                        newStation.setStationId(stationParts.get(0));
                        newStation.setCapacity(Integer.parseInt(stationParts.get(1)));
                        newStation.setMultiFlag(stationParts.get(2));
                        newStation.setFifoFlag(stationParts.get(3));
                        newStation.setTaskId(stationParts.get(4));
                        newStation.setTaskSize(Integer.parseInt(stationParts.get(5)));
                        if (stationParts.contains("T")) {
                            newStation.setTaskSize(Integer.parseInt(stationParts.get(4) + stationParts.get(5) + stationParts.get(6) + stationParts.get(7)));
                        }
                        newStation.setSpeed(Double.parseDouble(stationParts.getLast()));
                    Station.stationTypesList.add(newStation);

                }
            }
            System.out.println("-----TASKS-----");
            System.out.println(Task.taskTypesList);
            System.out.println("-----JOBS-----");
            System.out.println(Job.jobWithTaskList);
            System.out.println("-----STATIONS-----");
            System.out.println(Station.stationTypesList);
            System.out.println("-----JOBS PREFERENCES-----");
            System.out.println(Job.jobTypeList);
        }
        makeEventQueue();
    }
    public static void makeEventQueue() {



    }
}
