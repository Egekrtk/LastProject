import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //Arraylisti constructorda nasıl kullanabilirim
        //Joba özel task arrayi nasıl ekliyebilirim
        //Dosyayı okuduktan sonra oluşan objelere nasıl ulaşabilirim

        ReadJobFile jobFile = new ReadJobFile("jobList.txt");
        ReadFile file = new ReadFile("deneme.txt");
        Job job = new Job();

        System.out.println("JobTypes :");
        System.out.println(Job.jobWithTaskList);

        System.out.println("Joblar ve  Özellikleri : ");
        System.out.println(Job.jobPreferences);
        /*
        System.out.println(Job.jobPreferences.get(0));
        System.out.println(Job.jobPreferences.get(1));
        System.out.println(Job.jobPreferences.get(2));
        System.out.println(Job.jobPreferences.get(3));
        System.out.println(Job.jobPreferences.get(4));
*/
    }
}