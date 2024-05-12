import java.io.*;
import java.util.ArrayList;
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
                if (line.startsWith("(TASKTYPES") && line.endsWith(")")) {
                    ArrayList<String> taskParts = new ArrayList<>(List.of(line.split(" ")));
                    for (int i = 1; i < taskParts.size(); i++) {
                        System.out.println(taskParts.get(i));
                        if (!taskParts.get(i).contains(")")) {
                            if (!taskParts.get(i + 1).equals("")) {
                                Task newTask = new Task(taskParts.get(i), Integer.parseInt(taskParts.get(i + 1)));
                                newTask.createNewTask(taskParts.get(i), Integer.parseInt(taskParts.get(i + 1)));
                                System.out.println(newTask);
                                i++;
                            } else if (taskParts.get(i + 1).equals("")) {
                                Task newTask = new Task(taskParts.get(i));
                                newTask.createNewTask(taskParts.get(i), 0);
                                System.out.println(newTask.getTaskId() + "Has no size");
                                System.out.println("Task{" + newTask.getTaskId() + ", taskSize=0}");
                                i++;
                            }
                        } else if (taskParts.get(i).contains(" )")) {
                            Task newTask = new Task(taskParts.get((i)));
                            newTask.createNewTask(taskParts.get(i), 0);
                            System.out.println(newTask.getTaskId() + "Has no size");
                            System.out.println("Task{" + newTask.getTaskId() + ", taskSize=0}");
                            i++;
                        }
                    }
                    line += 1;
                }

                if (line.startsWith("(JOBTYPES") && line.endsWith(" )")) {
                    if (line.startsWith("(J") && line.endsWith(")")) {
                        ArrayList<String> jobsParts = new ArrayList<>(List.of(line.split("  ")));
                        line += 1;
                        // Job newJob = new Job(); eklencek
                    }
                }

                if (line.startsWith("(STATIONS") && line.endsWith(")")) {
                }
                if (line.startsWith("(S") && line.endsWith(")")) {
                    ArrayList<String> stationParts = new ArrayList<>(List.of(line.split(" ")));
                    line += 1;
                    Station newStation = new Station("Default", "Default", "Default", "Default", Task.taskTypesList, "Default");
                    for (String parts : stationParts) {
                        if (parts.startsWith("(S")) {
                            newStation.setStationId(String.valueOf(parts));
                        } else if (parts == stationParts.get(1)) {
                            newStation.setMultiFlag(parts);
                        } else if (parts.contains("N") || parts.contains("Y")) {
                            newStation.setFifoFlag(parts);
                        } else if (parts.contains("T")) {
                            newStation.setTaskId(parts);
                        } else if (parts.contains(".") && parts.contains(")")) {
                            newStation.setSpeed(parts);
                        } else {
                            if (parts.contains(")")) {
                                continue;
                            }
                            newStation.setTaskSize(Integer.parseInt(parts));
                        }
                    }
                    System.out.println(newStation.toString());
                }
            }
        }
    }
}
