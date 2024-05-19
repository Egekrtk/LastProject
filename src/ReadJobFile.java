import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReadJobFile  extends JobPreferences{
    static File jobFile ;
    public ReadJobFile() throws IOException,SyntaxError {
        if (checkIf()){
            try (BufferedReader br = new BufferedReader(new FileReader(jobFile.getPath()))) {
                String line = br.readLine();
                while ((line = br.readLine()) != null) {
                    int a = 0;
                    int lineNumber = line.length();
                    String newLine = line.substring(0, lineNumber);
                    String LastLine = newLine.replaceAll("[( )]", " ");
                    LinkedList<String> jobParts = new LinkedList<>(List.of(LastLine.split(" ")));
                    JobPreferences newJobPrenference = new JobPreferences("Default", "Default", 0, 0);
                    newJobPrenference.setJobId(jobParts.get(0));
                    newJobPrenference.setJobTypeId(jobParts.get(1));
                    newJobPrenference.setStarTime(Integer.parseInt(jobParts.get(2)));
                    newJobPrenference.setEndTime(Integer.parseInt(jobParts.get(3)));
                    //System.out.println(newJob.toString());

                    JobPreferenceList(newJobPrenference.getJobId(), newJobPrenference.getJobTypeId(), newJobPrenference.getStarTime(), newJobPrenference.getEndTime());
                }
            }
        }
    }

    public static boolean checkIf(){
        boolean b ;
        Scanner sc = new Scanner(System.in);
        String dosyaAdi = sc.nextLine();
        jobFile = new File("jobList.txt");
        if (dosyaAdi.equals(jobFile.getPath())){
            b = true;
        }else {
            System.out.println("Try again ");
            dosyaAdi = sc.nextLine();
            if (dosyaAdi.equals(jobFile.getPath())){
                b= true;
            }else {
                b = false;
            }
        }
        return b;
    }
}