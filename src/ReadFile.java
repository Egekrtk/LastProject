import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFile {
    public static LinkedList<JobPreferences> EventQueue = new LinkedList<>();
    static File file;

    public ReadFile() throws IOException, NumberFormatException, SyntaxError {

        if (checkIf()) {

            BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
            String line = br.readLine();

            BufferedReader nr = new BufferedReader(new FileReader(file.getPath()));
            String otherLine = nr.readLine();

            BufferedReader ar = new BufferedReader(new FileReader(file.getPath()));
            String anOtherLine = ar.readLine();

            while ((line = br.readLine()) != null) {
                int lineNumber = line.length();
                String newLine = line.substring(0, lineNumber);
                String LastLine = newLine.replaceAll("[( )]", " ");
                LinkedList<String> LinePart = new LinkedList<>(List.of(LastLine.split(" ")));


                if (LastLine.startsWith(" TASKTYPES")) {
                    LinePart.remove(0);
                    Task newTask = new Task();
                    for (int i = 1; i < LinePart.size(); i++) {
                        if (LinePart.get(i).startsWith("T")) {
                            newTask.setId(LinePart.get(i));
                        } else if (LinePart.get(i).contains(".") || LinePart.get(i).contains("-") || LinePart.get(i).contains("_")) {
                            new SyntaxError();
                        } else if (LinePart.get(i).startsWith("1") || LinePart.get(i).startsWith("2") || LinePart.get(i).startsWith("3") || LinePart.get(i).startsWith("4") || LinePart.get(i).startsWith("5") || LinePart.get(i).startsWith("6") || LinePart.get(i).startsWith("7") || LinePart.get(i).startsWith("8") || LinePart.get(i).startsWith("9")) {
                            newTask.setSize(Integer.parseInt(LinePart.get(i)));
                        } else {
                            new SyntaxError("Wrong input detected");
                        }
                        Task.TaskList.put(newTask.getId(), newTask.getSize());
                    }
                    System.out.println("----Task Types----");
                    System.out.println(Task.TaskList);
                }
            }
            System.out.println(" ");
            System.out.println("---Stations and features---");
            System.out.println(" ");
            while ((anOtherLine = ar.readLine()) != null) {
                int anotherNewLineNumber = anOtherLine.length();
                String anotherLine = anOtherLine.substring(0, anotherNewLineNumber);
                String anotherLastLine = anotherLine.replaceAll("[( )]", " ");
                LinkedList<String> anotherNewLinePart = new LinkedList<>(List.of(anotherLastLine.split(" ")));
                if (anotherLine.startsWith("(S") && anotherLine.endsWith(")")) {
                    anotherNewLinePart.remove(0);
                    Station newStation = new Station();
                    Task newTask = new Task();
                    for (int i = 0; i < anotherNewLinePart.size(); i++) {
                        if (anotherNewLinePart.get(i).startsWith("S")) {
                            newStation.setStationId(anotherNewLinePart.get(i));
                        } else if (i == 1) {
                            newStation.setCapacity(Integer.parseInt((anotherNewLinePart.get(i))));
                        } else if (i == 2) {
                            newStation.setMultiFlag(Boolean.parseBoolean(anotherNewLinePart.get(i)));
                        } else if (i == 3) {
                            newStation.setFifoFlag(Boolean.parseBoolean(anotherNewLinePart.get(i)));
                        } else if (anotherNewLinePart.get(i).startsWith("T")) {
                            newTask.setId(anotherNewLinePart.get(i));
                        } else if (i == anotherNewLinePart.size() - 1) {
                            newStation.setSpeed(Double.parseDouble(anotherNewLinePart.getLast()));
                            continue;
                        } else if (anotherNewLinePart.contains("1") || anotherNewLinePart.contains("2") || anotherNewLinePart.contains("3") || anotherNewLinePart.contains(" 4") || anotherNewLinePart.contains("5") || anotherNewLinePart.contains("6") || anotherNewLinePart.contains("7") || anotherNewLinePart.contains("8") || anotherNewLinePart.contains("9")) {
                            if (anotherNewLinePart.contains("0.") || anotherNewLinePart.contains("-") || anotherNewLinePart.contains("_") || anotherNewLinePart.contains(".")) {
                                new SyntaxError();
                            } else {
                                newTask.setSize(Integer.parseInt(anotherNewLinePart.get(i)));
                            }
                        }
                        if (newTask.getId() == null) {
                            new SyntaxError();
                        } else {
                            Station.createStation(newStation.getStationId(), newStation.getCapacity(), newStation.isMultiFlag(anotherNewLinePart.get(1)), newStation.isFifoFlag(anotherNewLinePart.get(2)), newStation.getSpeed(), newTask);

                        }
                    }
                    System.out.println("Station :"+newStation.getStationId() + " " + newTask.getId() + "Eklendi :" + Station.specialTaskForStation);
                    Station.StationTypeList.add(newStation);

                }
            }
            System.out.println(" ");
            System.out.println("---Jobs and features---");

            while ((otherLine = nr.readLine()) != null) {
                int newlineNumber = otherLine.length();
                String newotherLine = otherLine.substring(0, newlineNumber);
                String newLastLine = newotherLine.replaceAll("[( )]", " ");
                LinkedList<String> newLinePart = new LinkedList<>(List.of(newLastLine.split(" ")));
                LinkedList<String> specialTask = new LinkedList<>();
                if (otherLine.startsWith("(J") && otherLine.endsWith(")")) {
                    newLinePart.remove(0);
                    Job newJob = new Job();
                    Task newTask = new Task();
                    for (int i = 0; i < newLinePart.size(); i++) {
                        if (newLinePart.get(i).startsWith("J")) {
                            newJob.setJobTypeId(newLinePart.get(i));  //J1
                        } else if (newLinePart.get(i).startsWith("T")) {
                            newTask.setId(newLinePart.get(i));
                        } else if (newLinePart.get(i).startsWith("") ||newLinePart.get(i).startsWith("0") ||newLinePart.get(i).startsWith("1") || newLinePart.get(i).startsWith("2") || newLinePart.get(i).startsWith("3") || newLinePart.get(i).startsWith("4") || newLinePart.get(i).startsWith("5") || newLinePart.get(i).startsWith("6") || newLinePart.get(i).startsWith("7") || newLinePart.get(i).startsWith("8") || newLinePart.get(i).startsWith("9")) {
                            int a = Integer.parseInt(newLinePart.get(i));
                            int b = Task.TaskList.get(newTask.getId());
                            if (newLinePart.get(i).startsWith("") ||newLinePart.get(i).startsWith("0")){
                                newTask.setSize((a+b)*b);
                            }else {
                                newTask.setSize(b * a);
                            }
                        } else {
                            new SyntaxError();
                        }
                    }
                    newJob.addTask(newTask);

                    if (!(newTask.getId() == null)) {
                        specialTask.add(newJob.getJobTypeId() + " " + newTask.getId() + " " + newTask.getSize());
                        System.out.println(specialTask);
                    }
                    if (Job.JobWithTaskList.containsKey(newJob.getJobTypeId())) {
                        System.out.println("This job already exist");
                        continue;
                    } else {
                        newJob.createJob(newJob.getJobTypeId(), newTask.getId(), newTask.getSize());//HER ŞEYİ BURASI YAPIYOR
                        System.out.println("---------");
                        System.out.println("Other job's tasks and time : ");
                        System.out.println("Jobs:"+Job.JobWithTaskList);
                    }
                }
            }

            System.out.println(" ");
            System.out.println(" ");
            System.out.println("-----JobPreferences------");
            System.out.println(JobPreferences.JobTypeList);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("----Station Types-----");
            System.out.println(Station.StationTypeList);
            System.out.println(" ");
            System.out.println(" ");
            makeEventQueue();
        }
    }
    public static void makeEventQueue() {
        int max = 0;
        int j =-1;
        for (JobPreferences jp : JobPreferences.JobTypeList){
            int i= jp.getStarTime()+ jp.getEndTime();
            if (i>=max){
                EventQueue.add(jp);
                max=i;
                j++;
            }else {
                EventQueue.add(j,jp);
            }
        }
        System.out.println("EVENT QUEUE:"+EventQueue);
        System.out.println(" ");
        System.out.println("Tasks will take :"+ Job.totalTime+" ");
        Job.calculateTardiness();
        //Job.calculateStationUtilization();
    }

    public static boolean checkIf(){
        boolean b ;
        Scanner sc = new Scanner(System.in);
        String dosyaAdi = sc.nextLine();
        file = new File("deneme.txt");
        if (dosyaAdi.equals(file.getPath())){
            b = true;
        }else {
            System.out.println("Try again :");
            dosyaAdi = sc.nextLine();
            if (dosyaAdi.equals(file.getPath())){
                b= true;
            }else {
                b = false;
            }
        }
        return b;
    }
}