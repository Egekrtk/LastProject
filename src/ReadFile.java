import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private Task task;
    private static Scanner scanner;

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
                    System.out.println("-----TASKS-----");
                    System.out.println(Task.taskTypesList);
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
                            specialJob.add(parts);
                        } else if (parts.startsWith("T")) {
                            specialJob.add(parts);
                        } else {
                            specialJob.add(parts);
                        }
                        specialJob.add(parts);
                        specialJob.getLast();
                        Job.jobWithTaskList.add(String.valueOf(specialJob.getLast()));
                    }
                }
                if (LastLine.startsWith(" S")) {
                    if (line.startsWith("(STATIONS")) {
                        continue;
                    }ArrayList<String> stationParts = new ArrayList<>(List.of(LastLine.split(" ")));
                    line += 1;
                    Station newStation = new Station("Default", 0, "Default", "Default", Task.taskTypesList,0.0 );
                    LinkedList<String> specailStation = new LinkedList<>();
                    stationParts.remove(0);
                    for (String parts: stationParts){
                        if (parts.startsWith("S")){
                            newStation.setStationId(parts);
                        } else if (parts.equals(stationParts.get(1))) {
                            newStation.setCapacity(Integer.parseInt(parts));
                        } else if (parts.equals(stationParts.get(2))) {
                            newStation.setMultiFlag(parts);
                        }else if (parts.equals(stationParts.get(3))){
                            newStation.setFifoFlag(parts);
                        } else if (parts.startsWith("T")) {
                            newStation.setTaskId(parts);
                        } else if (parts.contains(".")) {
                            newStation.setSpeed(Double.parseDouble(parts));
                        } else {
                            newStation.setTaskSize(Integer.parseInt(parts));
                        }
                        specailStation.add(parts);
                        specailStation.getLast();
                        Station.stationWithTaskList.add(String.valueOf(specailStation.getLast()));
                    }
                }

            }
        }
    }
}
