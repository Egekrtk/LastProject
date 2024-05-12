import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadJobFile {
    public ReadJobFile(String jobFileName) throws IOException {
        File jobFile = new File("jobList.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(jobFile))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Job")) {
                    ArrayList<String> jobParts = new ArrayList<>(List.of(line.split(" ")));
                    line += 1;
                    Job newJob = new Job("Default", "Default", 0, 0);

                    newJob.setJobId(jobParts.get(0));
                    newJob.setJobTypeId(jobParts.get(1));
                    newJob.setStartTime(Integer.parseInt(jobParts.get(2)));
                    newJob.setDuration(Integer.parseInt(jobParts.get(3)));
                    System.out.println(newJob.toString());
                }

            }
        }
    }
}
