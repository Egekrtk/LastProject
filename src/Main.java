import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //jobların başlangıç süresine göre event oluştur bitince o jobun görevi süreyi yazdır
        //for da jobun task ıdlerini döndür , for da stationların ıd lerini  döndür eşit olan varsa stationın speedini kullan yoksa taksize kullanmaya devam et

        ReadJobFile jobFile = new ReadJobFile("jobList.txt");
        ReadFile file = new ReadFile("deneme.txt");

        /*
        System.out.println("JobTypes :");
        System.out.println(Job.jobWithTaskList);


        System.out.println("Joblar ve  Özellikleri : ");
        System.out.println(Job.jobPreferences);

        System.out.println("Stations");
        System.out.println(Station.stationWithTaskList);

        //Bunları ekle eventqueuye ordan devam et,for eachle lisstekilere baksın eşitlesin, equalsla çek timeları



        /*System.out.println("----- DENEME -----");
        for (int i = 0;i<Task.taskTypesList.size();i++){
            System.out.println(Task.taskTypesList.get(i));
        }
        for (int i =0;i < Job.jobPreferences.size();i++){
            System.out.println(Job.jobPreferences.get(i));
        }
        for (int i = 0;i<Job.jobWithTaskList.size();i++){
            System.out.println(Job.jobWithTaskList.get(i));
        }
        for (int i = 0;i<Station.stationWithTaskList.size();i++){
            System.out.println(Station.stationWithTaskList.get(i));
        }
         */
    }
}