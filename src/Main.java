import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ReadJobFile jobFile = new ReadJobFile("jobList.txt");
        ReadFile file = new ReadFile("deneme.txt");

        System.out.println(Task.taskTypesList);

    }
}